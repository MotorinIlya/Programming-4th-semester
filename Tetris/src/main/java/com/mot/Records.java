package com.mot;

import javax.swing.JFrame;

public class Records extends JFrame {

    Records() {
        add(new RecordsPanel(this));
        setTitle("Tetris");
        setResizable(false);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
}
