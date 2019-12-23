package io;

import java.io.*;

/**
 * cc.ketianyun.com copyright
 *
 * @Author kurt.ding
 * @Description
 * @Date 2019/3/8
 */
public class TryWithResourceDemo {
    public static void main(String[] args){
//        //不能先声明再实例化，必须声明和实例化放在一起
//        try(OutputStream outputStream = new FileOutputStream("classpath:src/resources/A.txt",true);
//            BufferedOutputStream buffer=new BufferedOutputStream(outputStream)
//        ){
//            buffer.write("\nabc".getBytes());
//            System.out.println("Write to buffer ");
//            System.out.println("Write success");
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        //finally中的exception被抑制
        try(TestTryWithResource testTryWithResource=new TestTryWithResource();
        ){
            System.out.println("Write to buffer ");
            System.out.println("Write success");
            throw new FileNotFoundException("File not found exception");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
