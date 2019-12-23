package com.ding.MySpring;

import com.ding.beanfactory.BeanFactory;
import com.ding.beanfactory.ClassPathXmlApplicationContext;
import com.ding.entity.Person;
import com.ding.entity.Student;
import com.ding.entity.Teacher;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	BeanFactory context = new ClassPathXmlApplicationContext("/applicationContext.xml");
    	Student stu=(Student)context.getBean("student");
    	System.out.println(stu.toString());
    	Teacher tea=(Teacher)context.getBean("teacher");
    	System.out.println(tea.toString());
    	Person per=(Person)context.getBean("person");
    	System.out.println(per.toString());
    }
}