package com.mot;

import java.io.PrintWriter;
import java.net.Socket;

public class ClientSocket {
    public static void main(String [] args) throws Exception {
        Socket socket = new Socket("192.168.0.12",8081);
        PrintWriter out = new PrintWriter(socket.getOutputStream());
        out.println("Hello");
        out.println("World");

        out.close();
        socket.close();
    }
}
