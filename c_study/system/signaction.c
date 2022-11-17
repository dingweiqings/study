#define _POSIX_SOURCE
#include<stdio.h>
#include<signal.h>
#include<unistd.h>
 #include <stdlib.h>

void better_handler(int sig){
    printf("Better handler received sig %d\n",sig);
}
int main(){
    struct sigaction act,oldact;

    sigset_t sig_set;
    //必须用这个函数来初始化，不能用memset
    sigemptyset(&sig_set);

    sigaddset(&sig_set,SIGQUIT);
    
    act.sa_handler=better_handler;
    act.sa_mask=sig_set;//mask表示信号处理器在调用时屏蔽的信号集
    //第一个act表示这个信号的处理策略，第二个表示这个信号当前的处理策略
 //   sigaction(SIGABRT,&act,&oldact);
    //常见的，设置这个信号的处理器
    sigaction(SIGABRT,&act,NULL);
    while (1)
    {
        sleep(5);
        puts("I am running");
    }
    
    return 0;
}