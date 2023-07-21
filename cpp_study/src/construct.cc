#include<string>
class Person {
    int age;
    std::string name;
};
class Student : public Person{
    int no;
};
class College {
    private:
    Student& student;
    public:
    // College(Student& stu): student(stu){

    // }
    // College(Student& stu){
    //     student = stu;
    // }

};