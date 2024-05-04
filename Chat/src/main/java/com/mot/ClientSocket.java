package com.mot;

import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class ClientSocket {
    public static void main(String [] args) throws Exception {
        Socket socket = new Socket();
        socket.connect(new InetSocketAddress("192.168.0.12",8081));
        PrintWriter out = new PrintWriter(socket.getOutputStream());

        //Scanner cons = new Scanner(System.in);

//        while(cons.hasNext()) {
//            out.println(cons.nextLine());
//        }
        out.println("hello Moscow");

//        cons.close();
        out.close();
        socket.close();
    }
}
