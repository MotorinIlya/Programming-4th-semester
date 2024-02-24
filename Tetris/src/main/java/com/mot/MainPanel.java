package com.mot;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPanel extends JFrame {

    Image name;

    MainPanel() {
        super("Tetris");

        setSize(500, 750);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.name = new ImageIcon("src/tetris_name.png").getImage();     

        JButton start = new JButton("Start");
        start.setBounds(40, 300, 420, 100);
        start.setBackground(Color.DARK_GRAY);
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                Game game = new Game();
                game.run();
                setVisible(true);
            }
        });
        JButton records = new JButton("Records");
        records.setBounds(40, 450, 420, 100);
        records.setBackground(Color.DARK_GRAY);
        JButton exit = new JButton("Exit");
        exit.setBounds(40, 600, 420, 100);
        exit.setBackground(Color.DARK_GRAY);
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        JPanel buttons = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(name, 0, 0, null);
            }
        };
        buttons.setLayout(null);
        buttons.add(start);
        buttons.add(records);
        buttons.add(exit);
        buttons.setBackground(Color.BLACK);
        add(buttons);

        setResizable(false);

        setLocation(710, 200);

        setVisible(true);
    }

}
