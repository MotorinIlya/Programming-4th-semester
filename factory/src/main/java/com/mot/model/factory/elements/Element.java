package com.mot.model.factory.elements;

import com.mot.util.IDGenerator;

public class Element {
    protected final int id;

    public Element() {
        synchronized (this) {
            this.id = IDGenerator.getID();
        }
    }

    public int getId() {
        return id;
    }
}
