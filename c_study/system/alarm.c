#include"../include/tpl.h"
// #define __POSIX_C_SOURCE 199506L
#define __POSIX_C_SOURCE 199309
#include<signal.h>
#include<time.h>
#include<math.h>
void threadFunc(sigval_t val){
    printf("I am a new thread \n");
}
int main(){
    sigevent_t bbb;
    bbb.sigev_notify=SIGEV_SIGNAL;
    bbb.sigev_signo=SIGALRM;
    bbb._sigev_un._sigev_thread._function=threadFunc;
    printf("aaa");
    sqrt(10);
    return 0;
}