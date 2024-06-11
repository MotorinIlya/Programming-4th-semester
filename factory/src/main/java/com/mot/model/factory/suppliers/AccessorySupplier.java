package com.mot.model.factory.suppliers;

import com.mot.model.factory.FactoryStats;
import com.mot.model.factory.elements.AccessoryElement;
import com.mot.model.factory.elements.Element;
import com.mot.model.factory.storages.Storage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AccessorySupplier extends Supplier<Element> {
    private static final Logger logger = LoggerFactory.getLogger(AccessorySupplier.class);
    private final boolean log;

    public AccessorySupplier(Storage<Element> storage, int timeToCreate, FactoryStats stats, boolean log) {
        super(storage, timeToCreate, stats);
        this.log = log;
    }

    @Override
    public void produceElement() throws InterruptedException {
        sleep(timeToCreate);
        AccessoryElement accessory = new AccessoryElement();
        storage.put(accessory);
        stats.increaseProducedCount(FactoryStats.ELEMENT.ACCESSORY);
        if (log) {
            logger.info("Produced new accessory. ID = {}", accessory.getId());
        }
    }
}
