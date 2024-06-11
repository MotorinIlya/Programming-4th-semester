package com.mot.model.factory.storages;

import com.mot.model.factory.FactoryStats;
import com.mot.model.factory.elements.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BodyStorage extends Storage<Element> {
    private static final Logger logger = LoggerFactory.getLogger(BodyStorage.class);
    private final boolean log;

    public BodyStorage(int capacity, FactoryStats stats, boolean log) {
        super(capacity, stats);
        this.log = log;
    }

    @Override
    public synchronized void put(Element element) {
        super.put(element);
        stats.increaseStoredCount(FactoryStats.ELEMENT.BODY);
        if (log) {
            logger.info("New Body was put into Body Storage. ID = {}", element.getId());
        }
    }

    @Override
    public synchronized Element get() {
        return super.get();
    }
}
