#include<iostream>
using namespace std;
int main()
{
    int x = 10;
    
    auto add_x = [x](int a) { return a + x; };  // 复制捕捉x
    auto multiply_x = [&x](int a) { return a * x; };  // 引用捕捉x
    
    cout << add_x(10) << " " << multiply_x(10) << endl;
    // 输出：20 100
    return 0;
}