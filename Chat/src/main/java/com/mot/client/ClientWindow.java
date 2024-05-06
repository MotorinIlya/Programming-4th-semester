package com.mot.client;

import com.mot.Constants;
import com.mot.controller.ChatController;
import com.mot.network.TCPConnection;
import com.mot.network.TCPConnectionListener;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.WriteAbortedException;

import static com.mot.Constants.*;

public class ClientWindow extends JFrame implements TCPConnectionListener {

    JPanel chatPanel;
    JTextArea log;
    TCPConnection connection;

    public static void main(String[] args) {
        //Create UI on EDT
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ClientWindow();
            }
        });
    }

    public ClientWindow() {
        super();

        try {
            connection = new TCPConnection(this, IP_SERVER, PORT);
        } catch (IOException e) {
            onException(connection, e);
        }

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setAlwaysOnTop(true);

        createPanel();
        setVisible(true);

    }

    private void createPanel() {
        chatPanel = new JPanel(new BorderLayout());



        JTextField fieldInput = new JTextField();
        JTextField fieldName = new JTextField();

        fieldInput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    String msg = fieldInput.getText();
                    if (msg.equals("")) return;
                    if (msg.equals("!exit")) connection.disconnect();
                    fieldInput.setText("");
                    connection.sendMessage(fieldName.getText() + ": " + msg);
            }
        });
        chatPanel.add(fieldInput, BorderLayout.SOUTH);


        chatPanel.add(fieldName, BorderLayout.NORTH);

        log = new JTextArea();
        log.setEditable(false);
        log.setLineWrap(true);
        chatPanel.add(log, BorderLayout.CENTER);

        add(chatPanel);

        setSize(Constants.WIDTH, Constants.HEIGHT);
    }

    @Override
    public void onConnectionReady(TCPConnection connection) {
        printMsg("Connection ready!");
    }

    @Override
    public void onReceiveString(TCPConnection connection, String msg) {
        printMsg(msg);
    }

    @Override
    public void onDisconnect(TCPConnection connection) {
        printMsg("Connection close.");
    }

    @Override
    public void onException(TCPConnection connection, Exception e) {
        printMsg("Connection exception: " + e);
    }

    private synchronized void printMsg(String msg) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                log.append(msg + "\n");
                log.setCaretPosition(log.getDocument().getLength());
            }
        });
    }
}
