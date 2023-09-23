#include<iostream>
int add1(int a, int b){
    return a+b;
}
class A{
    public:
         A()=default;
     ~A()=default;
    private:
     int i;
     int add(int delta){
        int j=0;
        j++;
        i =add1(i,delta);
        return i;
     }
};

class B{
    public:
    int j;
    A a;
};
using namespace std;
int main(){
    A a;
}