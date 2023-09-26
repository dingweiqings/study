#include<iostream>
using namespace std;
class PClass
{
public:
	double operator()(double x, double y) const;
	double operator()(double x) const;
};

double PClass::operator()(double x, double y)const
{
	if (x < y) return (y);
	else return (x);
}
double PClass::operator()(double x) const
{
	if (x < 0) return (-x);
	else return (x);
}
int main()
{
	PClass fun;
	cout << fun(1.2, 2.3) << endl;
	cout << fun(-6) << endl;
	return 0;
}