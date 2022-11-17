#define _BSD_SOURCE
#include <netdb.h>
#include <sys/socket.h>
#include <string.h>
#include <errno.h>
#include <stdlib.h>
#include <stdio.h>
#include <time.h>
#include <unistd.h>
#include <arpa/inet.h>
#define MAXLINE 1000
int main()
{
    char buff[MAXLINE];

    // struct addrinfo hints;
    // struct addrinfo *result, *rp;

    // char ip[50];
    // int lfd = 0;
    // hints.ai_canonname = NULL;
    // hints.ai_addr = NULL;
    // hints.ai_next = NULL;
    // hints.ai_socktype = SOCK_STREAM;
    // hints.ai_family = AF_UNSPEC;
    // hints.ai_flags = AI_PASSIVE ;

    // getaddrinfo("localhost", "2000", &hints, &result);
    // // domain 表示是Internet还是unix domain, type表示是SOCK_STREAM还是另外的，protocol表示是tcp还是udp
    // // addrinfo中都会提供
    // for (rp = result; rp != NULL; rp = rp->ai_next)
    // {
    //     lfd = socket(rp->ai_family, rp->ai_socktype, rp->ai_protocol);
    //     if (lfd == -1)
    //     {
    //         continue;
    //     }
    //     inet_ntop(AF_INET, rp->ai_addr, ip,sizeof(struct sockaddr));
    //     printf("%s\n", ip);
    //     int result = bind(lfd, rp->ai_addr, rp->ai_addrlen);
    //     if (!result)
    //     {
    //         break;
    //     }
    // }

    struct sockaddr_in listen_addr;
    struct in_addr in_addr;
    //用固定ip来获取in_addr
    // inet_pton(AF_INET, "127.0.0.1", &in_addr);
    //转换成网络字节序,这里long实际上是int
    in_addr.s_addr = INADDR_ANY;
    //获取sockaddr_in
    listen_addr.sin_addr = in_addr;
    listen_addr.sin_family = AF_INET;
    // 转换成网络字节序，端口是short
    listen_addr.sin_port = htons(2000);
    //创建server
    int lfd = socket(AF_INET, SOCK_STREAM, 0);
    int one = 1;
    if (setsockopt(lfd, SOL_SOCKET, SO_REUSEADDR, &one, sizeof(one)) < 0)
    {
        close(lfd);
        return -1;
    }
    bind(lfd, (struct sockaddr *)&listen_addr, sizeof(struct sockaddr));

    listen(lfd, 1000);
    puts("Server started\n");


    sleep(10);
    while (1)
    {
        sleep(1);
        struct sockaddr c_addr;
        socklen_t socklen;
        //获取和客户端通信的socket的id，这里第二个参数用来记录client的地址，第三个是socklen_t的指针
        int cfd = accept(lfd, &c_addr, &socklen);
        if (cfd == -1)
        {
            perror("Accept connection error");
            continue;
        }
        printf("Connection is accepted\n");
        //读取数据
        int n = recv(cfd, buff, MAXLINE, 0);
        buff[n] = '\0';
        printf("recv msg from client: %s\n", buff);
    }

    return 0;
}