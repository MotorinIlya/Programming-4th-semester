package com.mot.service;

import com.mot.model.events.Event;

import java.util.ArrayList;
import java.util.List;

public abstract class Observable {
    private final List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void notifyObservers(Event event) {
        for (Observer o: observers) {
            o.update(event);
        }
    }

    public void removeSubscriber(Observer o) {
        observers.remove(o);
    }
}
