#include <stdio.h>

class A
{
public:
    int a;
    virtual ~A(void) {}
};
class B : virtual public A
{
};
class C : virtual public A
{
    virtual void FuncC(void) {}
};
class D : public B, public C
{
};
class E : public B
{
    virtual void FuncE(void) {}
};

int main(int argc, char **argv)
{
    A a;
    B b;
    C c;
    D d;
    E e;
    printf("%d %d %d %d %d\n",
           sizeof(A), sizeof(B), sizeof(C), sizeof(D), sizeof(E));
    return 0;
}