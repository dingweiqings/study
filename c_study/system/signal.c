#define _POSIX_SOURCE
#include<stdio.h>
#include<signal.h>
#include<unistd.h>
 #include <stdlib.h>

void my_handler(int sig){
    printf("Received sig %d\n",sig);
    psignal(sig,"Sig Message");
   // exit(10);
}
int main(){
    //这个默认是core
//     signal( SIGABRT,my_handler);
//    // signal( SIGQUIT,my_handler);
//   signal(SIGTERM, my_handler);
    //SIGKILL 无法注册新的handler
    signal(SIGCHLD, SIG_DFL);
    signal(SIGPIPE, SIG_IGN);
    signal(SIGINT, my_handler);
    signal(SIGTERM, my_handler);
    while (1)
    {
        sleep(5);
        puts("I am running");
    }
    
    return 0;
}