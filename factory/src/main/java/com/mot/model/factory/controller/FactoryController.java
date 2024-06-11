package com.mot.model.factory.controller;

import com.mot.service.BlockingQueue;
import com.mot.service.ThreadPool;
import com.mot.model.factory.FactoryStats;
import com.mot.model.factory.storages.CarStorage;
import com.mot.model.factory.storages.StorageMap;
import com.mot.model.factory.workers.Order;
import com.mot.util.Config;

import static com.mot.model.factory.storages.StorageMap.Type.car;

public class FactoryController extends Thread {
    private final boolean log;

    private final StorageMap storageMap;
    private final int orderSize;      // the number of cars that the controller will request, if the storage is empty (default = 5)
    private final FactoryStats stats;

    private final BlockingQueue<Runnable> orders;

    public FactoryController(StorageMap storageMap, Config config, int orderSize, FactoryStats stats, boolean log) {
        this.storageMap = storageMap;
        this.orderSize = orderSize;
        this.stats = stats;
        this.log = log;

        orders = new BlockingQueue<>();
        ThreadPool workers = new ThreadPool(config.getWorkers(), orders);
        workers.start();
    }

    public CarStorage getCarStorage() {
        return (CarStorage) storageMap.get(car);
    }

    public BlockingQueue<Runnable> getOrders() {
        return orders;
    }

    @Override
    public synchronized void run() {
        while (true) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            synchronized (storageMap.get(car)) {
                if (storageMap.get(car).isEmpty()) {
                    addTasks(orderSize);
                }
            }
        }
    }

    private void addTasks(int count) {
        for (int i = 0; i < count; i++) {
            orders.put(new Order(storageMap, stats, log));
        }
    }
}
