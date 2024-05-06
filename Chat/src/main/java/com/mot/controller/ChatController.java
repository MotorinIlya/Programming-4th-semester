package com.mot.controller;

import com.mot.network.TCPConnection;
import com.mot.network.TCPConnectionListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ChatController implements ActionListener, TCPConnectionListener {


    @Override
    public void onConnectionReady(TCPConnection connection) {

    }

    @Override
    public void onReceiveString(TCPConnection connection, String msg) {

    }

    @Override
    public void onDisconnect(TCPConnection connection) {

    }

    @Override
    public void onException(TCPConnection connection, Exception e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
