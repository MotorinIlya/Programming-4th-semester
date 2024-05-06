package com.mot.client;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

import static com.mot.Constants.*;

public class ClientSocket {
    private String name;
    private Socket socket;


    public ClientSocket(String name){
        this.name = name;
        socket = new Socket();
        try {
            socket.connect(new InetSocketAddress(IP_SERVER, PORT));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String [] args) {
        try(Socket newSocket = new Socket()) {
            newSocket.connect(new InetSocketAddress(IP_SERVER, PORT));
            Scanner scanner = new Scanner(newSocket.getInputStream());
            while(scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
