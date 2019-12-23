package com.dingweiqings.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * cc.ketianyun.com copyright
 *
 * @Author kurt.ding
 * @Description
 * @Date 2018/11/9
 */

//这个类似于tomcat，启动main方法，等于启动tomcat
public class ServerMulti {
    /**
     * Socket服务端,
     */
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8888);
            System.out.println("服务端已启动，等待客户端连接..");
           // 相当于项目一直启动
            //然后开启新的线程，做事情
            while (true) {
                Socket socket = serverSocket.accept();// 侦听并接受到此套接字的连接,返回一个Socket对象
                SocketThread socketThread = new SocketThread(socket);
                socketThread.start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
