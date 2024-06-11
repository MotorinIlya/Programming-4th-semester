package com.mot.controller;

import com.mot.model.factory.Factory;
import com.mot.service.Observable;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public abstract class ViewController extends Observable implements ChangeListener {
    protected final Factory factory;

    public ViewController(Factory factory) {
        this.factory = factory;
    }

    @Override
    public abstract void stateChanged(ChangeEvent e);
}
