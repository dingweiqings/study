#include <stdio.h>
#include <stdbool.h>
static int total = 0;
static int result[300][8]={0};

bool checkLine(int arr[8][8])
{
      int count = 0;
    int i=0;
    for (int j = 0; j< 8; j++)
    {
      count=0;
        //主对角线
        for (int k = 0; k < 8 && i + k < 8 && j + k < 8; k++)
        {
            count += arr[i + k][j + k];
        }
        if (count > 1)
        {
       //     puts("主对角线重复");
            return false;
        }
        count = 0;
        //副对角线
        for (int k = 0; k < 8 && i + k < 8 && j - k >= 0; k++)
        {
            count += arr[i + k][j - k];
        }
        if (count > 1)
        {
           //  puts("副对角线重复");
            return false;
        }
    }
    i=7;

    for (int j = 0; j< 8; j++)
    {
            count=0;
        //主对角线
      for (int k = 0; k < 8 && i - k >=0 && j + k <8; k++)
        {
            count += arr[i - k][j +k];
        }
        if (count > 1)
        {
     //       puts("7主对角线重复");
            return false;
        }        

        count = 0;
        //副对角线
          for (int k = 0; k < 8 && i - k >= 0 && j - k >= 0; k++)
        {
            count += arr[i - k][j - k];
        }
        if (count > 1)
        {
         //    puts("7副对角线重复");
            return false;
        }
    }


    return true;
}
bool check(int arr[8][8], int k, int j)
{
    int count = 0;
    for (int i = 0; i < 8; i++)
    {
        // arr[k][i] == arr[k][j] 行不用检查，同一行不会有
        count += arr[i][j];
        if (count > 1)
        {
            return false;
        }
    }

    return checkLine(arr);
}

void print(int arr[8][8])
{
    printf("now print %d\n", total);
    for (int i = 0; i < 8; i++)
    {
        for (int j = 0; j < 8; j++)
        {
            if(arr[i][j] == 1){
                result[total][i]=j;
            }
            printf("%d", arr[i][j]);
        }
        printf("\n");
        
    }
}
void queue(int arr[8][8], int k, int n)
{
    // printf("now place %d\n", k);
    if (k == n)
    {
        total++;
        print(arr);
        return;
    }
    for (int i = 0; i < n; i++)
    {
        arr[k][i] = 1;
        if (check(arr, k, i))
        {
            queue(arr, k + 1, n);
            arr[k][i] = 0;
        }
        else
        {
            arr[k][i] = 0;
        }
    }
}

int main()
{
    int arr[8][8] = {0};
    queue(arr, 0, 8);
    printf("total: %d\n", total);
    return 0;
}