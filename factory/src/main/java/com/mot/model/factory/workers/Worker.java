package com.mot.model.factory.workers;

import com.mot.service.BlockingQueue;

public class Worker extends Thread {
    private final BlockingQueue<Runnable> tasks;

    public Worker(BlockingQueue<Runnable> tasks) {
        this.tasks = tasks;
    }

    @Override
    public void run() {
        while (true) {
            Order task = (Order) tasks.get();
            task.run();
        }
    }
}
