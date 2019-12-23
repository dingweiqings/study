package interfacefeautes;

import java.util.function.Function;

/**
 * cc.ketianyun.com copyright
 *
 * @Author kurt.ding
 * @Description
 * @Date 2018/12/24
 */
public class C implements A,B {
    private static String NAME="THIS NAME";

    //static 方法不能被重载
    @Override
    public void sayMessage() {

    }

    //接口A和B都有这个default方法，编译器不知道重写的是哪个方法，所以必须重写这个方法，有多个default 的相同方法，default不起作用
    @Override
    public void doSomething(){
        A.super.doSomething();
        //调用A中default方法
        System.out.println("C do something");
    }
    public  void test(){

    }
    public static void main(String[] args) {
        A a= new C();
        a.doSomething();
        //调用被C重写的方法
        //C do something
        B b=new C();
        b.doSomething();
        //C do something
        C c=new C();
        c.doSomething();
        //C do something

        A ad= new D();
        ad.doSomething();

        Function<String,String> f=(R)->{
             System.out.println(C.NAME+R);
             return "";
        };

        f.apply("Function test");
    }


}
