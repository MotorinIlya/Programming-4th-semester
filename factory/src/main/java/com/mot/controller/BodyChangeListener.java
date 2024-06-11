package com.mot.controller;

import com.mot.model.factory.Factory;

import javax.swing.*;
import javax.swing.event.ChangeEvent;

public class BodyChangeListener extends ViewController {
    public BodyChangeListener(Factory factory) {
        super(factory);
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        int newValue = ((JSlider) e.getSource()).getValue();
        factory.setBodyTimeToSupply(newValue * 1000);
    }
}
