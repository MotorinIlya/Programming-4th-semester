package com.mot;


import com.mot.client.ClientWindow;
import com.mot.controller.ChatController;

public class App
{
    public static void main (String[] args) {
        ChatController controller = new ChatController();
        ClientWindow window = new ClientWindow();
    }
}
