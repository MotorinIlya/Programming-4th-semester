package com.mot.model.factory.dealers;

import com.mot.model.factory.controller.FactoryController;
import com.mot.model.factory.elements.CarElement;
import com.mot.model.factory.FactoryStats;
import com.mot.util.IDGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Dealer extends Thread {
    private static final Logger logger = LoggerFactory.getLogger(Dealer.class);
    private final boolean log;

    private final int id;

    private final FactoryController factoryController;
    private int timeToSale;
    private final FactoryStats stats;

    public Dealer(FactoryController factoryController, int timeToSale, FactoryStats stats, boolean log) {
        this.factoryController = factoryController;
        this.timeToSale = timeToSale;
        this.stats = stats;
        this.id = IDGenerator.getID();
        this.log = log;
    }

    public int getTimeToSale() {
        return timeToSale;
    }

    public void setTimeToSale(int timeToSale) {
        this.timeToSale = timeToSale;
    }

    @Override
    public void run() {
        while (true) {
            CarElement carForSale;
            try {
                carForSale = orderCar();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (log) {
                logger.info("Dealer N{} ordered new Car (ID = {}) [Accessory ID = {}, Body ID = {}, Motor ID = {}]",
                        id, carForSale.getId(), carForSale.getAccessoryID(), carForSale.getBodyID(), carForSale.getMotorID());
            }
        }
    }

    private CarElement orderCar() throws InterruptedException {
        sleep(timeToSale);
        synchronized (factoryController) {
            factoryController.notify();
        }
        CarElement carElement = (CarElement) factoryController.getCarStorage().get();
        stats.decreaseStoredCount(FactoryStats.ELEMENT.CAR);
        return carElement;
    }
}
