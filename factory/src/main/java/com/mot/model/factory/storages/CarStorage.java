package com.mot.model.factory.storages;

import com.mot.model.factory.FactoryStats;
import com.mot.model.factory.elements.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CarStorage extends Storage<Element> {
    private static final Logger logger = LoggerFactory.getLogger(CarStorage.class);
    private final boolean log;

    public CarStorage(int capacity, FactoryStats stats, boolean log) {
        super(capacity, stats);
        this.log = log;
    }

    @Override
    public synchronized void put(Element element) {
        super.put(element);
        stats.increaseStoredCount(FactoryStats.ELEMENT.CAR);
        if (log) {
            logger.info("New Car was put into Car Storage. ID = {}", element.getId());
        }
    }

    @Override
    public synchronized Element get() {
        return super.get();
    }
}
