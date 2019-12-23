package com.dingweiqings.generic;

/**
 * cc.ketianyun.com copyright
 *
 * @Author kurt.ding
 * @Description
 * @Date 2018/9/12
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 定义泛型类
 *
 * 定义"模版"的时候，泛型用泛型字母：T 代替
 * 在使用的时候指定实际类型
 *
 * @author Administrator
 * @param <A>
 */
public class Student<A> {

    private  A javase;

    //private static T javaee;   //泛型不能使用在静态成员属性上,静态必须编译时便要确定，不能用于final属性，因为final必须初始化，泛型不知道如何初始化,但可以用于final集合属性
    public Student() {
    }

    public Student(A javase) {
        this();
        this.javase = javase;
    }

    public A getJavase() {
        return javase;
    }

    public void setJavase(A javase) {
        this.javase = javase;
    }

}
/**
 * 自定义泛型的使用
 * 在声明时指定具体的类型
 * 不能为基本类型
 * @author Administrator
 *
 */
class Demo02 {
    public static void main(String[] args) {
        //Student<int>  Student = new Student<int>(); //不能为基本类型，编译时异常

        Student<Integer> student = new Student<Integer>();
        student.setJavase(85);
        System.out.println(student.getJavase());
    }
}