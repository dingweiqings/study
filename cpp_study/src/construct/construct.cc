#include<string>
#include<iostream>

// };
// 只有int类型的变量
// class A {
//     public:
//     std::string str;
//     int i;
// };
// int main(){
//     A a;
//     std::cout<<a.i<<std::endl;
//     return 0;
// }

//只定义拷贝构造函数，编译器不会生成无参构造函数 
class A {
    public: 
     int i;
     std::string str;
    A(const A& other){
       
    }
};
int main(){
    A a;
    A c =a;
    return 0;
}