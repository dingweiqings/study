package optional;

import bean.Student;
import bean.Teacher;
import interfacefeautes.A;
import interfacefeautes.B;
import interfacefeautes.C;
import interfacefeautes.D;

import java.util.ArrayList;
import java.util.Optional;
import java.util.function.Function;

/**
 * cc.ketianyun.com copyright
 *
 * @Author kurt.ding
 * @Description
 * @Date 2018/12/24
 */
public class OptionalDemo {

    public static void main(String[] args) {
        Optional.ofNullable(new Student()).map(Student::getId);
        Student obj=new Student();
        obj.setId("1");
        obj.setName("kurt");
        Teacher teacher=new Teacher();
        Double x=0.0;
        teacher.setStudents(new ArrayList<>());
        ArrayList<String> list=new ArrayList<>();

        //一般写在service 方法中,当不是null才继续往下走，同时不抛异常
        list.forEach(e->{
            Optional.ofNullable(e).ifPresent(ee->{

            });
        });
        Optional.ofNullable(obj).ifPresent((t)->{
            teacher.getStudents().add(t);
            System.out.println(t.getId());
            //不能使用基本类型，无法对final的基本类型,基本类型的包装类的进行操作，
           // x++;
            //无法返回值，consumer是消费
           // return "132";

        });

        System.out.println(teacher.getStudents());
    }
}
