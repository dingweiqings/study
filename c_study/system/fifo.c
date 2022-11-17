#include<stdio.h>
#include<sys/stat.h>
int main(){
    mkfifo("/tmp/ddd",S_IRUSR|S_IWUSR|S_IRGRP|S_IWGRP |S_IROTH|S_IWOTH);
    FILE* file=fopen("/tmp/ddd","r");
    char buf[100];
    size_t size=fread(buf,100,1,file);
    buf[size+1]='\0';
    puts(buf);
    return 0;
}