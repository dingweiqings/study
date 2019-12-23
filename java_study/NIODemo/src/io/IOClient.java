package io;

/**
 * cc.ketianyun.com copyright
 *
 * @Author kurt.ding
 * @Description
 * @Date 2019/3/7
 */

import java.io.IOException;
import java.net.Socket;
import java.util.Date;

/**
 * @author 闪电侠
 */
public class IOClient {

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                Socket socket = new Socket("127.0.0.1", 8000);//获取主机socket
                while (true) {
                    try {
                        socket.getOutputStream().write((new Date() + ": hello world").getBytes());//客户端，获得输出流
                        socket.getOutputStream().flush();//刷新
                        Thread.sleep(2000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } catch (IOException e) {
            }
        }).start();
    }
}