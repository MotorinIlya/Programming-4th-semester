package com.mot.model.factory;

import com.mot.model.factory.controller.FactoryController;
import com.mot.model.factory.dealers.Dealer;
import com.mot.model.factory.storages.*;
import com.mot.model.factory.suppliers.AccessorySupplier;
import com.mot.model.factory.suppliers.BodySupplier;
import com.mot.model.factory.suppliers.MotorSupplier;
import com.mot.model.factory.storages.*;
import com.mot.util.Config;
import com.mot.util.Settings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;

public class Factory implements Runnable {
    private static final Logger logger = LoggerFactory.getLogger(Factory.class);

    private final boolean log;

    private final Settings settings;
    private final Config config;

    private final BodySupplier bodySupplier;
    private final MotorSupplier motorSupplier;
    private final LinkedList<AccessorySupplier> accessorySuppliers;

    private final FactoryController factoryController;

    private final LinkedList<Dealer> dealers;

    public Factory(Config config, Settings settings, FactoryStats stats) {
        this.settings = settings;
        this.config = config;
        this.log = config.getLog();

        StorageMap storageMap = new StorageMap();

        AccessoryStorage accessoryStorage = new AccessoryStorage(config.getStorageAccessorySize(), stats, log);
        storageMap.put(StorageMap.Type.accessory, accessoryStorage);
        BodyStorage bodyStorage = new BodyStorage(config.getStorageBodySize(), stats, log);
        storageMap.put(StorageMap.Type.body, bodyStorage);
        MotorStorage motorStorage = new MotorStorage(config.getStorageMotorSize(), stats, log);
        storageMap.put(StorageMap.Type.motor, motorStorage);
        CarStorage carStorage = new CarStorage(config.getStorageCarSize(), stats, log);
        storageMap.put(StorageMap.Type.car, carStorage);

        bodySupplier = new BodySupplier(bodyStorage, settings.getBodySupplyTime(), stats, log);
        motorSupplier = new MotorSupplier(motorStorage, settings.getMotorSupplyTime(), stats, log);
        accessorySuppliers = new LinkedList<>();
        for (int i = 0; i < config.getAccessorySuppliers(); i++) {
            accessorySuppliers.add(new AccessorySupplier(accessoryStorage, settings.getAccessorySupplyTime(), stats, log));
        }

        factoryController = new FactoryController(storageMap, config, 5, stats, log);

        dealers = new LinkedList<>();
        for (int i = 0; i < config.getDealers(); i++) {
            dealers.add(new Dealer(factoryController, settings.getDealerSaleTime(), stats, log));
        }
    }

    @Override
    public void run() {
        int i = 0;
        for (AccessorySupplier accessorySupplier : accessorySuppliers) {
            i++;
            accessorySupplier.start();
            if (log) {
                logger.info("Accessory Supplier N{} was successfully executed", i);
            }
        }
        bodySupplier.start();
        if (log) {
            logger.info("Body Supplier was successfully executed");
        }

        motorSupplier.start();
        if (log) {
            logger.info("Motor Supplier was successfully executed");
        }

        i = 0;
        for (Dealer dealer : dealers) {
            i++;
            dealer.start();
            if (log) {
                logger.info("Dealer N{} was successfully executed", i);
            }
        }

        factoryController.start();
        if (log) {
            logger.info("Factory Controller was successfully executed");
        }
    }

    public Config getConfig() {
        return config;
    }

    public void setAccessoriesTimeToSupply(int newValue) {
        for (AccessorySupplier acsSupplier : accessorySuppliers) {
            acsSupplier.setTimeToSupply(newValue);
        }
        settings.setAccessorySupplyTime(newValue);
        if (log) {
            logger.info("Accessory Supply Time to produce was set to {} ms", newValue);
        }
    }

    public void setBodyTimeToSupply(int newValue) {
        bodySupplier.setTimeToSupply(newValue);
        settings.setBodySupplyTime(newValue);
        if (log) {
            logger.info("Body Supply Time to produce was set to {} ms", newValue);
        }
    }

    public void setMotorTimeToSupply(int newValue) {
        motorSupplier.setTimeToSupply(newValue);
        settings.setMotorSupplyTime(newValue);
        if (log) {
            logger.info("Motor Supply Time to produce was set to {} ms", newValue);
        }
    }

    public void setDealersTimeToSale(int newValue) {
        for (Dealer dealer : dealers) {
            dealer.setTimeToSale(newValue);
        }
        settings.setDealerSaleTime(newValue);
        if (log) {
            logger.info("Dealer Sale Time was set to {} ms", newValue);
        }
    }
}
