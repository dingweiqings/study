#include<string.h>
#include<stdio.h>
#include<stdio.h>
int main(){
    int x;
	//freopen("input.txt","r",stdin);  //只加这一句输入将被重定向到文件input.txt
    while(scanf("%d",&x)!=EOF){
            int result=func(x);
            if(result){
                printf("%d是回文\n",x);
            }else{
                printf("%d不是回文\n",x);
            }
    }
    return 0;
}
#include<math.h>
int func(int x){
    char arr[15];
    int i=0;
    char ch=0;
    while(x>0){
        ch= x%10 + '0';
        arr[i++]=ch;
        x/=10;
    }
    arr[i]='\0';
    int len=strlen(arr);
    int j=len-1;
    i=0;
    while (i<j)
    {
        if(arr[i++]!=arr[j--]){
            return 0;
        }
    }
    return 1;
}