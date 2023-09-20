#include <iostream>
#include <thread>
#include <mutex> // 互斥量头文件

std::mutex mtx; // 互斥量对象

// 线程函数
void hello(int num) {
    mtx.lock(); // 上锁
    std::cout << "Hello, concurrent world! There are " << num << " threads." << std::endl;
    mtx.unlock(); // 解锁
}

int main() {
    int num = std::thread::hardware_concurrency();
    std::thread t1(hello, num);
    std::thread t2(hello, num); // 创建两个线程
    t1.join();
    t2.join(); // 等待两个线程结束
    return 0;
}