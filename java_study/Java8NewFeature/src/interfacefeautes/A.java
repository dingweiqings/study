package interfacefeautes;

/**
 * cc.ketianyun.com copyright
 *
 * @Author kurt.ding
 * @Description
 * @Date 2018/12/24
 */
public interface A {

    //不能有static代码块
//    static {
//
//    }

    String TEST="Interface A";
    //static 方法不能被重载
    static void sayHelloWorld(){
        System.out.println(" Static A say hello world"+TEST);
    }

    void sayMessage();

    default void doSomething(){
        System.out.println("Default A do something ");
    }


}
