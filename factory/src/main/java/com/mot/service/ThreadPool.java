package com.mot.service;

import com.mot.model.factory.workers.Worker;

import java.util.LinkedList;

public class ThreadPool extends Thread {
    private final LinkedList<Worker> workers;

    public ThreadPool(int threadsCnt, BlockingQueue<Runnable> tasks) {
        workers = new LinkedList<>();
        for (int i = 0; i < threadsCnt; i++) {
            workers.add(new Worker(tasks));
        }
    }

    @Override
    public void run() {
        for (Worker worker : workers) {
            worker.start();
        }
    }
}
