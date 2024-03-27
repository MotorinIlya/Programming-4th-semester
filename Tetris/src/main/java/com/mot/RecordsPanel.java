package com.mot;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import static com.mot.Constants.*;

public class RecordsPanel extends JPanel {

    Records records;

    RecordsPanel(Records records) {
        this.records = records;
        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        setFocusable(true);
        JButton exit = new JButton("exit");
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                close();
            }
        });
        add(exit);
    }

    private void close() {
        records.dispose();
        new MainPanel();
    }
}
