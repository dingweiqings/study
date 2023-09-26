#include<iostream>
using namespace std;
class vector
{
	int x, y;
public:
	vector(){ };//默认构造函数
	vector(int x1, int y1)//重载函数
	{
		x = x1; y = y1;
	}
	friend vector operator+(vector v, vector v1)
	{
		vector tmp;
		tmp.x = v1.x + v.x;
		tmp.y = v1.y + v.y;
		return tmp;
	}
	friend vector operator-(vector v, vector v1)
	{
		vector tmp;
		tmp.x = v1.x - v.x;
		tmp.y = v1.y - v.y;
		return tmp;
	}
	void display()
	{
		cout << "(" << x << "," << y << ")";
	}
};
int main()
{
	vector v1(2, 3), v2(3, 5), v3, v4;
	cout << "v1:"; v1.display();
	cout << "v2:"; v2.display();
	v3 = v1 + v2; v4 = v1 - v2;
	cout << "v3:"; v3.display();
	cout << "v4:"; v4.display();
}