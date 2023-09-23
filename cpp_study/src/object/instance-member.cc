#include<iostream>
class A{
    public:
     int i;
};
class B{
    public:
    int j;
};
// int A::i = 10;
B create(){
    B a;
    return a; 
}
using namespace std;
int main(){
    // B a = create();
    // a.str=10;
    // B b = create();
    // b.str= 100;
    // std::string res = a.str + b.str;
    B * b = new B;
    B a = *b;
    a.j=10;
    cout<<a.j;
}