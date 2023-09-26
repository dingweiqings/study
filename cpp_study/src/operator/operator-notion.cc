#include<iostream>
using	namespace	std;
class MyClass2
{
	int n;
public:
	MyClass2(int i){ n = i; }
	MyClass2 operator +(int a){ n+=a; return n; }
	void display()
	{
		cout << "n=" << n << endl;
	}
    friend  MyClass2 operator +(MyClass2 a, int  b){ 
       a.n += b;
       return a;
    }
};

int main()
{
	MyClass2 A(5), B(5);
    A = 5 + A;// 会报错
	A.display();
	B.display();
    return 0;
}