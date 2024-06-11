package com.mot.service;

import java.util.LinkedList;

public class BlockingQueue<T> {
    protected LinkedList<T> tasks;

    public BlockingQueue() {
        this.tasks = new LinkedList<>();
    }

    synchronized public T get() {
        while (tasks.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        return tasks.pop();
    }

    synchronized public void put(T task) {
        tasks.add(task);
        notify();
    }
}
