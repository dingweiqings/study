#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<errno.h>
#include<stdbool.h>
void read();
void write();
void readAscii();
void writeAscii();
int main(){
    // read();
    write();
    return 0;
}
void read(){
    errno=0;
    FILE * fp=fopen("input.txt","rb");
    //处理打开文件失败
    if(fp==NULL){
        perror("Open file error");
        printf("%s\n", strerror(errno));
        exit(1);
    }
    //拷贝到内存缓冲区，用char数组作为buf
    char buf[11];
    while(!feof(fp)){
        //fread,从fp 读取10*char字节大小到buf
       fread(buf,sizeof(char),10,fp);
       buf[10]='\0';
       puts(buf);
       memset(buf,0,sizeof(buf));
    }
    //关闭文件
    fclose(fp);
}
void write(){
    errno=0;
    FILE * fp=fopen("input.txt","rb");
    FILE * outfp=fopen("output.txt","wb");
    //处理打开文件失败
    if(fp==NULL || outfp==NULL){
        perror("Open file error");
        printf("%s\n", strerror(errno));
        exit(1);
    }
    //拷贝到内存缓冲区，用char数组作为buf
    char buf[10];
    int n=0;
    // while(!feof(fp)){
    //     //fread,从fp 读取10*char字节大小到buf
        //必须拷贝read的字节数，因为最后一块，可能没满10个字节，会把buf数组中额外的字节拷贝进去
    //    int n= fread(buf,sizeof(char),10,fp);
    //    fwrite(buf,sizeof(char),n,outfp);
    // }
    while( (n=fread(buf,sizeof(char),10,fp))>0){
        //fread,从fp 读取10*char字节大小到buf
        fwrite(buf,sizeof(char),n,outfp);
    }

    //关闭文件
    fclose(outfp);
    fclose(fp);
}
void readAscii(){
    errno=0;
    FILE * fp=fopen("input.txt","r");
    if(fp==NULL){
        perror("Open file error");
        printf("%s\n", strerror(errno));
        exit(1);
    }
    //注意必须用int
    int ch;
    //getc读取文件
    while((ch=getc(fp))!=EOF){
        putchar(ch);
    }
    fclose(fp);
}
void writeAscii(){
    errno=0;
    FILE* fp=fopen("output.txt","a+");
    if(fp==NULL){
        perror("Open output file error");
        exit(1);
    }
    char * arr="abcdef \nghit";
    char *p=arr;
    while(*p!='\0'){
        // putc(*p,fp);
        fputc(*p,fp);
   //     fprintf(fp,"%c",*p);
        p++;
    }
}