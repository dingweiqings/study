#include<iostream>
class A{
    public:
    int m;
    int n;
    virtual void doWork(){

    }
};
using namespace std;
int main(){
cout<<"m:"<<offsetof(A,m)<<" "<<"n:" <<offsetof(A,n)<<endl;
cout<<"m:"<< &A::m<<" "<<"n:" << &A::n<<endl;
A a;
cout<<"size:"<<sizeof(a)<<endl;
}