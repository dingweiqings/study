#include<iostream>
#include<stdio.h>
using std::cout;
using std::cin;
typedef u_char byte;
int main(){
    // char * x=(char*)malloc(sizeof(char));
    // FILE * file=fopen("a.txt","w");
  //  cout<< x;
    byte * arr = (byte *)"8002";
    ulong len=4;

    byte * data;
    ulong i;
    for(data=arr,i=0;i<len;i++){
      printf("%d",(uint)*data++);
    }
    return 0;
}