package com.mot.service;

import java.util.ArrayList;
import java.util.List;
import com.mot.event.Event;

public abstract class Observable {
    private List<Observer>  observers = new ArrayList<>();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void update(Event event) {
        for (Observer ob : observers) {
            ob.update(event);
        }
    }

    public void removeObserver(Observer o) {
        observers.remove(o);
    }
}
