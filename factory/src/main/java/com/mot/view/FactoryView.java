package com.mot.view;

import com.mot.model.factory.Factory;
import com.mot.model.factory.FactoryStats;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class FactoryView extends JFrame {
    private final Factory factory;

    public FactoryView(Factory factory, FactoryStats stats) {
        super("Factory");
        this.setLayout(new GridBagLayout());
        this.factory = factory;

        this.setSize(new Dimension(1366, 768));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new GridBagLayout());
        this.setResizable(false);

        StatPanel statPanel = new StatPanel(stats);
        stats.addObserver(statPanel);
        this.add(statPanel, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(1, 5, 10, 5), 0, 0));

        SlidersPanel slidersPanel = new SlidersPanel(factory);
        this.add(slidersPanel, new GridBagConstraints(1, 0, 1, 3, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(1, 5, 10, 5), 0, 0));

        ImageIcon icon = new ImageIcon(Objects.requireNonNull(FactoryView.class.getResource("/factory.gif")));
        JLabel label = new JLabel(icon);
        this.add(label, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(1, 5, 10, 5), 0, 0));

        JPanel configPanel = createConfigPanel();
        this.add(configPanel, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(1, 5, 10, 5), 0, 0));

        this.setVisible(true);
    }

    private JPanel createConfigPanel() {
        int accessoryStorageSize = factory.getConfig().getStorageAccessorySize();
        int bodyStorageSize = factory.getConfig().getStorageBodySize();
        int motorStorageSize = factory.getConfig().getStorageMotorSize();
        int accessorySuppliersCnt = factory.getConfig().getAccessorySuppliers();
        int workersCnt = factory.getConfig().getWorkers();
        int dealersCnt = factory.getConfig().getDealers();

        JPanel panel = new JPanel(new GridBagLayout());

        JLabel logoLabel = createLabel("                FACTORY CONFIGURATION");
        panel.add(logoLabel, new GridBagConstraints(0, 0, 2, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(1, 5, 10, 5), 0, 0));

        JLabel acsStorageLabel = createLabel("Accessory Storage size: " + accessoryStorageSize);
        panel.add(acsStorageLabel, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(1, 5, 10, 5), 0, 0));

        JLabel bodyStorageLabel = createLabel("Body Storage size: " + bodyStorageSize);
        panel.add(bodyStorageLabel, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(1, 5, 10, 5), 0, 0));

        JLabel motorStorageLabel = createLabel("Motor Storage size: " + motorStorageSize);
        panel.add(motorStorageLabel, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(1, 5, 10, 5), 0, 0));

        JLabel acsSuppliersLabel = createLabel("Accessory Suppliers count: " + accessorySuppliersCnt);
        panel.add(acsSuppliersLabel, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(1, 5, 10, 5), 0, 0));

        JLabel workersCntLabel = createLabel("Workers count: " + workersCnt);
        panel.add(workersCntLabel, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(1, 5, 10, 5), 0, 0));

        JLabel dealersCntLabel = createLabel("Dealers count: " + dealersCnt);
        panel.add(dealersCntLabel, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(1, 5, 10, 5), 0, 0));

        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panel.setBackground(Color.LIGHT_GRAY);

        return panel;
    }

    private JLabel createLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
        return label;
    }
}
