#include "../include/tpl.h"
#include <sys/inotify.h>
#include<sys/stat.h>
#include<sys/file.h>
#define BUF_LEN 10 * sizeof(struct inotify_event) + 100 + 1
extern int errno;
int main(int argc, char **argv)
{
    int fd = inotify_init();
    if (fd == -1)
    {
        perror("Inotify init!");
        exit(1);
    }
    if (argc < 2)
    {
        printf("%s filename \n", argv[0]);
        exit(EXIT_SUCCESS);
    }
    
    char *filename = *++argv;
    FILE *__file = fopen(filename, "r+");
    printf("Now watch %s\n", filename);

    //监控某个文件
    inotify_add_watch(fd, filename, IN_MODIFY | IN_CREATE | IN_CLOSE_WRITE);
    char buf[BUF_LEN];
    char fileBuf[1024] = {0};
    char *p = NULL;

    struct inotify_event *event;
    while (1)
    {
        int num = read(fd, buf, BUF_LEN);
        puts("Read loop");
        for (p = buf; p < buf + num;)
        {

            event = (struct inotify_event *)p;
            //用IN_CLOSE_WRITE，用IN_MODIRY会出现两次，好像是vi 的swap出现的，具体还不知道
            if (event->mask & IN_CLOSE_WRITE)
            {
                printf("num: %d, add size %d; %s write\n", num, sizeof(struct inotify_event) + event->len, filename);
                printf("Read ptr %d\n",__file->_IO_read_ptr);
                while (fread(fileBuf, sizeof(char), 256, __file) > 0)
                {
                    puts(fileBuf);
                    memset(fileBuf, 0, sizeof(fileBuf));
                }
            }

            p += sizeof(struct inotify_event) + event->len;
        }
    }
    close(fd);
    fclose(__file);

    return 0;
}