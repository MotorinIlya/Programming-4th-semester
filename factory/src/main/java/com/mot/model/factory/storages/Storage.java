package com.mot.model.factory.storages;

import com.mot.service.BlockingQueue;
import com.mot.model.factory.FactoryStats;
import com.mot.model.factory.elements.Element;

public class Storage<T extends Element> extends BlockingQueue<T> {
    protected final int capacity;
    protected final FactoryStats stats;

    public Storage(int capacity, FactoryStats stats) {
        this.capacity = capacity;
        this.stats = stats;
    }

    @Override
    public synchronized void put(T element) {
        while (isFull()) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        super.put(element);
    }

    @Override
    public synchronized T get() {
        notify();
        return super.get();
    }

    public synchronized boolean isFull() {
        return getSize() >= capacity;
    }

    public boolean isEmpty() {
        return tasks.isEmpty();
    }

    public synchronized int getSize() {
        return tasks.size();
    }
}
