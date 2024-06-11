package com.mot.model.factory.suppliers;

import com.mot.model.factory.FactoryStats;
import com.mot.model.factory.elements.Element;
import com.mot.model.factory.elements.MotorElement;
import com.mot.model.factory.storages.Storage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MotorSupplier extends Supplier<Element> {
    private static final Logger logger = LoggerFactory.getLogger(MotorSupplier.class);
    private final boolean log;

    public MotorSupplier(Storage<Element> storage, int timeToCreate, FactoryStats stats, boolean log) {
        super(storage, timeToCreate, stats);
        this.log = log;
    }

    @Override
    public void produceElement() throws InterruptedException {
        sleep(timeToCreate);
        MotorElement motor = new MotorElement();
        storage.put(motor);
        stats.increaseProducedCount(FactoryStats.ELEMENT.MOTOR);
        if (log) {
            logger.info("Produced new motor. ID = {}", motor.getId());
        }
    }
}
