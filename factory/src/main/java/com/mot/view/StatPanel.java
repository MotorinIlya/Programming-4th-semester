package com.mot.view;

import com.mot.model.events.Event;
import com.mot.model.factory.FactoryStats;
import com.mot.service.Observer;

import javax.swing.*;
import java.awt.*;

public class StatPanel extends JPanel implements Observer {
    private final FactoryStats stats;

    private JLabel acsStoredCntLabel;
    private JLabel bodyStoredCntLabel;
    private JLabel motorStoredCntLabel;
    private JLabel carStoredCntLabel;
    private JLabel acsProdCntLabel;
    private JLabel bodyProdCntLabel;
    private JLabel motorProdCntLabel;
    private JLabel carsProdCntLabel;


    public StatPanel(FactoryStats stats) {
        super(new GridBagLayout());
        this.stats = stats;

        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.setBackground(Color.LIGHT_GRAY);

        addLabels();
    }

    private void addLabels() {
        synchronized (stats) {
            acsStoredCntLabel = createLabel();
            acsStoredCntLabel.setText("Accessories in storage: " + stats.getAccessoryStoredCount());
            this.add(acsStoredCntLabel, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(1, 5, 10, 5), 0, 0));
        }
        bodyStoredCntLabel = createLabel();
        bodyStoredCntLabel.setText("Bodies in storage: " + stats.getBodyStoredCount());
        this.add(bodyStoredCntLabel, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(1, 5, 10, 5), 0, 0));

        motorStoredCntLabel = createLabel();
        motorStoredCntLabel.setText("Motors in storage: " + stats.getMotorStoredCount());
        this.add(motorStoredCntLabel, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(1, 5, 10, 5), 0, 0));

        carStoredCntLabel = createLabel();
        carStoredCntLabel.setText("Cars in storage: " + stats.getCarStoredCount());
        this.add(carStoredCntLabel, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(1, 5, 10, 5), 0, 0));

        acsProdCntLabel = createLabel();
        acsProdCntLabel.setText("Accessories produced: " + stats.getAccessoryProducedCount());
        this.add(acsProdCntLabel, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(1, 5, 10, 5), 0, 0));

        bodyProdCntLabel = createLabel();
        bodyProdCntLabel.setText("Body produced: " + stats.getBodyProducedCount());
        this.add(bodyProdCntLabel, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(1, 5, 10, 5), 0, 0));

        motorProdCntLabel = createLabel();
        motorProdCntLabel.setText("Motors produced: " + stats.getMotorProducedCount());
        this.add(motorProdCntLabel, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(1, 5, 10, 5), 0, 0));

        carsProdCntLabel = createLabel();
        carsProdCntLabel.setText("Cars produced: " + stats.getCarProducedCount());
        this.add(carsProdCntLabel, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(1, 5, 10, 5), 0, 0));

    }

    private JLabel createLabel() {
        JLabel label = new JLabel();
        label.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
        return label;
    }

    @Override
    public void update(Event event) {
        switch (event.getEventType()) {
            case UPD_ACCESSORY_STORED_CNT:
                synchronized (stats) {
                    acsStoredCntLabel.setText("Accessories in storage: " + stats.getAccessoryStoredCount());
                    break;
                }

            case UPD_BODY_STORED_CNT:
                bodyStoredCntLabel.setText("Bodies in storage: " + stats.getBodyStoredCount());
                break;

            case UPD_MOTOR_STORED_CNT:
                motorStoredCntLabel.setText("Motors in storage: " + stats.getMotorStoredCount());
                break;

            case UPD_CAR_STORED_CNT:
                carStoredCntLabel.setText("Cars in storage: " + stats.getCarStoredCount());
                break;

            case UPD_ACCESSORY_PROD_CNT:
                acsProdCntLabel.setText("Accessories produced: " + stats.getAccessoryProducedCount());
                break;

            case UPD_BODY_PROD_CNT:
                bodyProdCntLabel.setText("Body produced: " + stats.getBodyProducedCount());
                break;

            case UPD_MOTOR_PROD_CNT:
                motorProdCntLabel.setText("Motors produced: " + stats.getMotorProducedCount());
                break;

            case UPD_CAR_PROD_CNT:
                carsProdCntLabel.setText("Cars produced: " + stats.getCarProducedCount());
                break;
        }
    }

}
