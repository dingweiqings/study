void syscall();
#include<stdio.h>
int main(int argc, char const *argv[])
{
    // puts("HelloWorld");
    //调用linux syscall来打印你好
    syscall();
    return 0;
}
