package com.mot.view.menu;

import javax.swing.*;

import static com.mot.Constants.BUTTON_EXIT;
import static com.mot.Constants.BUTTON_RECORDS;
import static com.mot.Constants.BUTTON_START;

import java.awt.*;

import com.mot.controller.MenuController;

public class ButtonsMenuPanel extends JPanel {

    private final Image image;

    public ButtonsMenuPanel(MenuController menuController) {
        super();
        
        JButton start = new JButton(BUTTON_START);
        start.setBounds(40, 300, 420, 100);
        start.setBackground(Color.WHITE);
        start.addActionListener(menuController);

        JButton records = new JButton(BUTTON_RECORDS);
        records.setBounds(40, 450, 420, 100);
        records.setBackground(Color.RED);
        records.addActionListener(menuController);

        JButton exit = new JButton(BUTTON_EXIT);
        exit.setBounds(40, 600, 420, 100);
        exit.setBackground(Color.YELLOW);
        exit.addActionListener(menuController);

        image = new ImageIcon("src/tetris_name.png").getImage();  
        
        setLayout(null);
        add(start);
        add(records);
        add(exit);
        setBackground(Color.BLACK);
    }

    @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(image, 0, 0, null);
        }
}
