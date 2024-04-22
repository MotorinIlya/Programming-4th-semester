package com.mot.view.menu;

import javax.swing.*;

import com.mot.controller.MenuController;

import java.awt.*;
import static com.mot.Constants.*;

public class MainView extends JFrame {

    private JPanel cardPanel;
    private ButtonsMenuPanel buttons;
    private RecordsPanel records;

    private CardLayout cardLayout;
    private final MenuController menuController;
    
    public MainView() {
        super("Tetris");

        setSize(500, 750);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        menuController = new MenuController(this);

        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);
        buttons = new ButtonsMenuPanel(menuController);
        records = new RecordsPanel(menuController);

        cardPanel.add(buttons, MAIN);
        cardPanel.add(records, RECORDS);
        add(cardPanel);
        setVisible(true);
    }

    public void switchPanel(String panel) {
        cardLayout.show(cardPanel, panel);
    }
}
