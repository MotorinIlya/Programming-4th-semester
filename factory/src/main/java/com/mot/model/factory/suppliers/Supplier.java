package com.mot.model.factory.suppliers;

import com.mot.model.factory.FactoryStats;
import com.mot.model.factory.elements.Element;
import com.mot.model.factory.storages.Storage;

public abstract class Supplier<T extends Element> extends Thread {
    protected final Storage<T> storage;
    protected int timeToCreate;
    protected final FactoryStats stats;

    public Supplier(Storage<T> storage, int timeToCreate, FactoryStats stats) {
        this.storage = storage;
        this.timeToCreate = timeToCreate;
        this.stats = stats;
    }

    public int getTimeToCreate() {
        return timeToCreate;
    }

    public void setTimeToSupply(int timeToCreate) {
        if (timeToCreate <= 0) {
            throw new RuntimeException("Time to create an element can't be <= 0");
        }
        this.timeToCreate = timeToCreate;
    }

    @Override
    public void run() {
        while (true) {
            try {
                produceElement();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public abstract void produceElement() throws InterruptedException;
}
