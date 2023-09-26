//设置一个Assoc类，其中用一个数组表示每个单词的情况，而且每个单词除了他出现的次数，
//还应保存该单词本身，因此定义一个结构。该类中有一个重载运算符“[ ]”成员函数，用来返回
//某个单词已经出现的次数，返回值是一个引用，可用于改变值。在每查找到一种单词后返回以出
//现的次数在运算符后边进行++运算，相对于返回值++，间接地起到每找到一个单词便将它的出现次数
//+1的目的。
#include<iostream>
#include<string.h>
using namespace std;
struct Pair//说明结构体类型
{
	char *name;//单词
	int num;//出现的次数
};
class Assoc
{
	struct Pair *vec;//指向结构体变量的指针
	int size;//分配总的单元个数
	int used;//已使用的单元个数
public:
	Assoc(int m)//构造函数
	{
		size = (m > 16) ? m : 16;//size至少大于16
		used = 0;
		vec = new Pair[size];//分配空间
	}
	int & operator [] (char *);
	void disp();
};
int & Assoc::operator[](char *p)//返回的是pp->num的引用
{
	struct Pair *pp;
	for (pp = vec; pp < vec + used; pp++)//在已有的单词中查找
	if (strcmp(p, pp->name) == 0)//若找到返回次数
		return pp->num;
	pp = &vec[used++];//在已有的单词中未找到，则使用的单元个数+1
	pp->name = new char[strlen(p) + 1];//分配一个单元空间
	strcpy(pp->name, p);
	pp->num = 0;
	return pp->num;//返回0
}
void Assoc::disp()
{
	cout << "单词出现次数统计：" << endl;
	for (int i = 0; i < used; i++)
	{
		cout << " " << vec[i].name << ":" << vec[i].num << "次" << endl;
	}
}
int  main()
{
	char buf[16];
	Assoc vecc(20);//设置20个单元存放单词
	int k = 10;
	cout << "请输入" << k << "个单词" << endl;
	for (int i = 0; i < k; i++)
	{
		cout << "第" << i + 1 << "个单词：";
		cin >> buf;
		vecc[buf]++;//调用“[]”，并将该单词出现次数增1
	}
	vecc.disp();
    return 0;
}