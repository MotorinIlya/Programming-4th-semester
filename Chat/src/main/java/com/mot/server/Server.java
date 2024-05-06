package com.mot.server;

import com.mot.network.TCPConnection;
import com.mot.network.TCPConnectionListener;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import static com.mot.Constants.*;

public class Server  implements TCPConnectionListener {

    private final ArrayList<TCPConnection> connections = new ArrayList<>();

    public static void main(String [] args) throws IOException {
        new Server();
    }



    private Server() {
        System.out.println("server running..."); {
            try(ServerSocket serverSocket = new ServerSocket(PORT)) {
                while(true) {
                    try {
                        new TCPConnection(serverSocket.accept(), this);
                    } catch (IOException e) {
                        System.out.println("TCPConnection exception: " + e);
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public synchronized void onConnectionReady(TCPConnection connection) {
        connections.add(connection);
        sendAllConnections("Client connected: " + connection);
    }

    @Override
    public synchronized void onReceiveString(TCPConnection connection, String msg) {
        sendAllConnections(msg);
    }

    @Override
    public synchronized void onDisconnect(TCPConnection connection) {
        connections.remove(connection);
        sendAllConnections("Client disconnected: " + connection);
    }

    @Override
    public synchronized void onException(TCPConnection connection, Exception e) {
        System.out.println("TCPConnection exception: " + e);
    }

    private void sendAllConnections(String msg) {
        System.out.println(msg);
        for (TCPConnection connection : connections) {
            connection.sendMessage(msg);
        }
    }
}
