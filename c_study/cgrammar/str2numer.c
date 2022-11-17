#include<stdlib.h>
#include<unistd.h>
#include<stdio.h>
int main(){
 int i;
  char buffer [33];
  printf ("Enter a number: ");
  scanf ("%d",&i);
  printf ("decimal: %s\n",buffer);
  itoa (i,buffer,16);
  printf ("hexadecimal: %s\n",buffer);
  itoa (i,buffer,2);
  printf ("binary: %s\n",buffer);
  return 0;
}