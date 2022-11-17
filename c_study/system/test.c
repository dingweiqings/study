#include <stdio.h>
#include <stdbool.h>
#include <sys/socket.h>
#include <netdb.h>
#include <time.h>
#include<arpa/inet.h>
#include <unistd.h>
#include<stdlib.h>
#include<string.h>

int main(int argc, char **argv)
{
    //声明一个serverfd
    char buf[1024];
    int serverfd = socket(AF_INET, SOCK_STREAM, 0);
    int one = 1;
    if (setsockopt(serverfd, SOL_SOCKET, SO_REUSEADDR, &one, sizeof(one)) < 0)
    {
        close(serverfd);
        return -1;
    }

    memset(buf, 0, sizeof(buf));
    struct sockaddr_in server_addr;
    struct in_addr inaddr;
    // inaddr.s_addr=INADDR_ANY;
    server_addr.sin_family = AF_INET;
    //不转换就会报错
    server_addr.sin_addr.s_addr = INADDR_ANY;
//    char ip[]="192.168.16.108";
//     server_addr.sin_addr.s_addr = inet_addr("192.168.16.108");
    //  inet_pton(AF_INET, ip,&server_addr.sin_addr.s_addr);
    server_addr.sin_port = htons(9005);
    // bind,listen
    bind(serverfd, (struct sockaddr *)&server_addr, sizeof(struct sockaddr));
    listen(serverfd, 100);
    printf("server fd is %d\n", serverfd);
    // accept
    while (1)
    {
        struct sockaddr client;
        socklen_t socklen;
        int clientfd = accept(serverfd, &client, &socklen);
        if (clientfd ==-1)
        {
            perror("accept");
            exit(EXIT_FAILURE);
        }
        puts("Happy accepted");
        int n = recv(clientfd, buf, 100, 0);
        buf[n] = '\0';
        puts(buf);
        memset(buf, 0, sizeof(buf));
        // sleep(5);
    }

    return 0;
}