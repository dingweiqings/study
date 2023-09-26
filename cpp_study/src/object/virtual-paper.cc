#include <stdio.h>

class A
{
public:
    int a;
    virtual void af(){

    }
};
class B : virtual public A
{
    public:
    int b;
    virtual void bf(){

    }
};
class C : virtual public A
{
    public:
    int c;
    virtual void cf(){

    }
};
class D : public B, public C
{
    public:
    int d;
    virtual void df(){

    }
};

int main(int argc, char **argv)
{
    A a;
    B b;
    C c;
    D d;
    printf("%d %d %d %d %d\n",
           sizeof(A), sizeof(B), sizeof(C), sizeof(D));
    return 0;
}