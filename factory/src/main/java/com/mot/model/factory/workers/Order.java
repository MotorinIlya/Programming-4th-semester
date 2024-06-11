package com.mot.model.factory.workers;

import com.mot.model.factory.elements.AccessoryElement;
import com.mot.model.factory.elements.BodyElement;
import com.mot.model.factory.elements.CarElement;
import com.mot.model.factory.elements.MotorElement;
import com.mot.model.factory.storages.StorageMap;
import com.mot.model.factory.FactoryStats;
import com.mot.model.factory.elements.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static java.lang.Thread.sleep;

public class Order implements Runnable {
    private static final Logger logger = LoggerFactory.getLogger(Order.class);
    private final boolean log;

    private final StorageMap storageMap;
    private final FactoryStats stats;

    public Order(StorageMap storageMap, FactoryStats stats, boolean log) {
        this.storageMap = storageMap;
        this.stats = stats;
        this.log = log;
    }

    @Override
    public void run() {
        try {
            sleep(2000);    // time to create a car
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        AccessoryElement accessoryElement = (AccessoryElement) storageMap.get(StorageMap.Type.accessory).get();
        stats.decreaseStoredCount(FactoryStats.ELEMENT.ACCESSORY);
        if (log) {
            logger.info("Accessory was get from Accessory Storage. ID = {}", accessoryElement.getId());
        }


        BodyElement bodyElement = (BodyElement) storageMap.get(StorageMap.Type.body).get();
        stats.decreaseStoredCount(FactoryStats.ELEMENT.BODY);
        if (log) {
            logger.info("Body was get from Body Storage. ID = {}", bodyElement.getId());
        }

        MotorElement motorElement = (MotorElement) storageMap.get(StorageMap.Type.motor).get();
        stats.decreaseStoredCount(FactoryStats.ELEMENT.MOTOR);
        if (log) {
            logger.info("Motor was get from Motor Storage. ID = {}", motorElement.getId());
        }

        CarElement carElement = new CarElement(accessoryElement, bodyElement, motorElement);
        storageMap.get(StorageMap.Type.car).put(carElement);
        stats.increaseProducedCount(FactoryStats.ELEMENT.CAR);
    }
}
