package com.dingweiqings;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Base64;

public class Main {

    public static void main(String[] args) throws IOException {
        File file = new File("C:\\MyProject\\JavaSEDemo\\src\\com\\dingweiqings\\logo.jpg");
        //InputStream inputStream=new FileInputStream(file);
        InputStream inputStream = new FileInputStream(file);
        OutputStream outputStream = System.out;

        byte[] bytes = new byte[inputStream.available()];

        inputStream.read(bytes);


        byte[] data = Base64.getEncoder().encode(bytes);

        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < bytes.length; i++) {
            sb.append(data[i]);
        }
        System.out.println(sb.toString());
    }
}
