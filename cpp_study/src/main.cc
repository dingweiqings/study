#include<iostream>
#include<fstream>
#include<stdio.h>
#include<array>
#include<vector>
#include<map>
#include<new>
#include<functional>
#include<iterator>
#include<algorithm>
#define likely(x)	 __builtin_expect(!!(x), 1)
#define unlikely(x) __builtin_expect(!!(x), 0)
struct  fff
{
  /* data */
};
class Zero{
  public:
  int a;
};
struct FA{
  typedef int mm;
};


void inline test_ruc(){
  printf("%d\n",111);
  // test_ruc();
}
class F {
int a;
int *str;
public:
 F(int fa) try :a(fa)
 {

  try{
    str=new int;
  }catch(const char * s){
    delete str;
  }

 }catch(const char *s ){
  
 }

// F(int fa){
//   try{
//     str=new int;
//   }catch(const char * s){
//     delete str;
//   }
// }

};

extern int ccc;
class A{
  public:
  A(){

  };
};
// using std::cout;
// using std::cin;
// typedef u_char byte;
int aaa(int a){
  return a+1;
}
int bbb(int a){
  return a+1;
}
int main(){
  using namespace std;
  // int * p =new int;
  // *p=10;
  // delete p;
  // int m =10;
  // int * a=&m;
  // *a=100;
  // string a1="123";
  // string a2=a1+"456";
  test_ruc();
  map<string,int> map ;
  map.insert(make_pair("1",1));
  map.erase(map.begin());
  map.insert(map.begin(),make_pair("1",3));
  map.insert(make_pair("4",3));
  map.insert(make_pair("2",3));
  cout<<"not exists" <<map["afdasfafd"]<<endl;
  auto it = map.find("mmmfgfdgsdf");
  if(it!=map.end()){
  cout<< "not found" <<(*it).first <<" "<< (*it).second <<endl;
  }

  int * p=new int;
  for(auto it : map){
  cout<< it.first <<" "<< it.second <<endl;
  }
  vector<int> fadfas={1,2,3,4,5};
  vector<int> mm;
  mm.push_back(1);
  mm.insert(mm.begin(),5);
  copy(mm.begin(),mm.end(),ostream_iterator<int>(cout," "));
  return 0;
}
