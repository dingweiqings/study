#include<iostream>

#include <mutex>
#define N 6
int result[N];
int total=0;
void pailie(int arr[],int start,int end){
	if(start == end){
		for(int i=0;i<N;i++){
			printf("%d",result[i]);
		}
		printf("\n");
		total+=1;
	}
	int tmp=0;
	for(int i=start;i<end;i++){
		tmp=arr[i];
		arr[i]=arr[start];
		arr[start]=tmp;
		//add to result
		result[start]=arr[start];
		pailie(arr,start+1,end);
	}
	printf()
	{};
	// std::mutex mutex ;
	// std::lock_guard<std::mutex> guard(mutex);
	// std::unique_lock<std::mutex> lock(mutex);
}


int main(int argc, char* argv[])
{
    // short int a = -1, b = a + 1;//定义短型无符号
	// std::cout << "a......" << a << "--------" << "b......" << b << std::endl;
	// // cout << endl;
	// // cout<<"hello world"<<endl;
    // // cout<<"二进制:"<<bitset<32>(2000000000)<<endl;
    // // printf("%ld",(ulong)a);
	// int arr[N]={6,2,3,4,5,1};
	// pailie(arr,0,N);
	// printf("total: %d \n",total);
	int len =24;
	  while ( len-- )
  {
    std::cout<< len<<std::endl;
  }
	return 0;
   
}