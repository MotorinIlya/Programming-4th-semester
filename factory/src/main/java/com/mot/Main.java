package com.mot;

import com.mot.model.factory.Factory;
import com.mot.model.factory.FactoryStats;
import com.mot.util.Config;
import com.mot.util.Settings;
import com.mot.view.FactoryView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        Config config = new Config();
        Settings settings = new Settings(1000, 1000, 1000, 3000);

        FactoryStats stats = new FactoryStats();
        Factory factory = new Factory(config, settings, stats);

        if (config.getLog()) {
            logger.info("The Factory successfully created with settings: " +
                            "accessorySupplyTime = {} ms, " +
                            "bodySupplyTime = {}, " +
                            "motorSupplyTime = {}, " +
                            "dealerSaleTime = {}",
                    settings.getAccessorySupplyTime(), settings.getBodySupplyTime(),
                    settings.getMotorSupplyTime(), settings.getDealerSaleTime());
        }


        new FactoryView(factory, stats);

        factory.run();
    }
}