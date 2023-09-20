#include<iostream>
//继承情况
class A
{
public:
   A() {TRACE(" construct A\n");}
   ~A() {TRACE(" destruct A\n");}
};

class B
{
public:
   B() {TRACE(" construct B\n");}
   ~B() {TRACE(" destruct B\n");}
};

class A1 :A
{
public:
   A1() {TRACE(" construct A1\n");}
   ~A1() {TRACE(" destruct A1\n");}
   B b;
};

int main(){
    A1* a1  = new A1;
    delete a1;
    return 0;
}
