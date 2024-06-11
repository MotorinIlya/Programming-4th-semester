package com.mot.model.factory.suppliers;

import com.mot.model.factory.FactoryStats;
import com.mot.model.factory.elements.BodyElement;
import com.mot.model.factory.elements.Element;
import com.mot.model.factory.storages.Storage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BodySupplier extends Supplier<Element> {
    private static final Logger logger = LoggerFactory.getLogger(BodySupplier.class);
    private final boolean log;

    public BodySupplier(Storage<Element> storage, int timeToCreate, FactoryStats stats, boolean log) {
        super(storage, timeToCreate, stats);
        this.log = log;
    }

    @Override
    public void produceElement() throws InterruptedException {
        sleep(timeToCreate);
        BodyElement body = new BodyElement();
        storage.put(body);
        stats.increaseProducedCount(FactoryStats.ELEMENT.BODY);
        if (log) {
            logger.info("Produced new body. ID = {}", body.getId());
        }
    }
}
