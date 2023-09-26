#include<iostream>
using	namespace	std;
class MyClass2
{
	int n;
public:
	MyClass2(int i){ n = i; }
	int operator ++(){ n++; return n; }
	int operator ++(int){ n += 2; return n; }
	void display()
	{
		cout << "n=" << n << endl;
	}
};

int main()
{
	MyClass2 A(5), B(5);
	A++;
	++B;
	A.display();
	B.display();
    return 0;
}