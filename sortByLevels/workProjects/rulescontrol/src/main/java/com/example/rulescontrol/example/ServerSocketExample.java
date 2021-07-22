package com.example.rulescontrol.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

public class ServerSocketExample {
    public static void main(String[] args) throws IOException {
        Socket socket =new Socket("192.168.17.97",5060);
        String str;
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
        while ((str = bufferedReader.readLine())!= null) {
            System.out.println(str);
        }
    }
}
