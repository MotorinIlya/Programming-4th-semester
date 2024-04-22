package com.mot.controller;

import com.mot.model.Game;
import com.mot.service.Observable;
import com.mot.view.menu.MainView;

import static com.mot.Constants.*;

import java.awt.event.*;


public class MenuController extends Observable implements ActionListener {

    private MainView mainPanel;

    public MenuController(MainView mainPanel) {
        this.mainPanel = mainPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        switch (cmd) {
            case "Start":
                mainPanel.dispose();
                new Game();
                break;
            case "Records":
                mainPanel.switchPanel(RECORDS);
                break;
            case "Exit":
                System.exit(0);
            case "Back":
                mainPanel.switchPanel(MAIN);
                break;
        }
    }
}
