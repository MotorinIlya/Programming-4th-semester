package com.mot.view.menu;

import static com.mot.Constants.BUTTON_BACK_MENU;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPanel;

import com.mot.controller.MenuController;

public class RecordsPanel extends JPanel{
    public RecordsPanel(MenuController menuController) {
        super();

        JButton back = new JButton(BUTTON_BACK_MENU);
        back.setBounds(40, 600, 420, 100);
        back.setBackground(Color.white);
        back.addActionListener(menuController);

        setLayout(null);
        add(back);
        setBackground(Color.BLACK);
    }
}
