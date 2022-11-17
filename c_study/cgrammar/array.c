#include<stdio.h>
#include<string.h>
void print_array(int * a ,int n){
    //循环数组，如果用指针，必须使用次数循环，因为指针++一直加下去，引用非法内存
        for(int i=0;i<n;i++){
                printf("%d ",*a++);
        }
        printf("\n");
}
void print_char_array(char * a ,int n){
        for(int i=0;i<n;i++){
                printf("%c ",*a++);
        }
        printf("\n");
}
int main(int argc,char ** argv){
    //固定大小，c99支持数组大小支持变量
    int a[10];//局部变量需要初始化
    //按字节赋值，每个字节是0，int是32位，所以4个0结果就都是0，然后sizeof返回的是a的字节长度
    memset(a,0,sizeof(a));
    printf("array inlizalize with 0\n");
    print_array(a,sizeof(a)/sizeof(a[0]));
    //16843009 0x01010101
    memset(a,1,sizeof(a));
    printf("array inlizalize with 1\n");

    print_array(a,sizeof(a)/sizeof(a[0]));

    //动态大小
    int x;
    printf("input dynamic array size\n");

    scanf("%d",&x);
    int b[x];
    printf("Dynamic array size:%zu\n",sizeof(b));






    //字符数组
    char c[5]="abc";//字符串字面量赋值编译器会自动增加'\0'
    char f[5]={'a','b','c','\0'};//需要手动增加，结束符可能会导致bug
    printf("char array\n");
    print_char_array(c,sizeof(c)/sizeof(c[0]));


    //常量数组,不能修改数组中元素
    const char d[10]={0,[2]='b'};
    printf("Const char array");
   // d[0]='a';


    //二维数组
    int twoarr[10][10];
    memset(twoarr,0,sizeof(twoarr));
    int (*p)[10]=twoarr;
    
    

    //指针数组
    int (*pp)[10];




    return 0;
}
