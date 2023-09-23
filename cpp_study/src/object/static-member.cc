#include<iostream>
class A{
    public:
    static int i;
};
// int A::i = 10;
using namespace std;
int main(){
    cout<<A::i;
}