package io;

/**
 * cc.ketianyun.com copyright
 *
 * @Author kurt.ding
 * @Description
 * @Date 2019/3/8
 */
public class FinallyExcetionDemo {
    public static void main(String[] args){
        System.out.println(f());
        //finally中return 抑制try catch块中异常
    }
    public static int f(){
        try{
            int x=1/0;
        }finally {
           return 1;
        }
    }
}
