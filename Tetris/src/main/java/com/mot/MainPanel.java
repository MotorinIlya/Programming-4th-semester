package com.mot;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPanel extends JFrame {

    JPanel cardPanel;
    JPanel buttons;
    JPanel records;
    
    MainPanel() {
        super("Tetris");
        setSize(500, 750);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocation(710, 200);
        
    }


    public void start() {
        cardPanel = new JPanel(new CardLayout());
        createButtonsPanel();
        createRecordsPanel();
        
        
        add(cardPanel);
        setVisible(true);
    }

    public void createButtonsPanel() {
        JButton start = new JButton("Start");
        start.setBounds(40, 300, 420, 100);
        start.setBackground(Color.WHITE);
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Game();
            }
        });

        JButton records = new JButton("Records");
        records.setBounds(40, 450, 420, 100);
        records.setBackground(Color.RED);
        records.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) cardPanel.getLayout();
                cardLayout.show(cardPanel, "records");
            }
        });

        JButton exit = new JButton("Exit");
        exit.setBounds(40, 600, 420, 100);
        exit.setBackground(Color.YELLOW);
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        final Image name = new ImageIcon("src/tetris_name.png").getImage();     
        buttons = new JPanel() {
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
        cardPanel.add(buttons, "main");
    }


    public void createRecordsPanel() {
        records = new JPanel();

        JButton back = new JButton("back");
        back.setBounds(40, 600, 420, 100);
        back.setBackground(Color.white);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) cardPanel.getLayout();
                cardLayout.show(cardPanel, "main");
            }
        });
        records.setLayout(null);
        records.add(back);
        records.setBackground(Color.BLACK);
        cardPanel.add(records, "records");
    }
}
