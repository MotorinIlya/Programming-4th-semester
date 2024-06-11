package com.mot.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {

    private final Properties properties;

    public Config() {
        properties = new Properties();
        loadConfig();
    }

    public int getStorageBodySize() {
        return Integer.parseInt(properties.getProperty("StorageBodySize"));
    }

    public int getStorageMotorSize() {
        return Integer.parseInt(properties.getProperty("StorageMotorSize"));
    }

    public int getStorageAccessorySize() {
        return Integer.parseInt(properties.getProperty("StorageAccessorySize"));
    }

    public int getStorageCarSize() {
        return Integer.parseInt(properties.getProperty("StorageCarSize"));
    }

    public int getAccessorySuppliers() {
        return Integer.parseInt(properties.getProperty("AccessorySuppliers"));
    }

    public int getWorkers() {
        return Integer.parseInt(properties.getProperty("Workers"));
    }

    public int getDealers() {
        return Integer.parseInt(properties.getProperty("Dealers"));
    }

    public boolean getLog() {
        return Boolean.parseBoolean(properties.getProperty("Log"));
    }

    private void loadConfig() {
        InputStream input = Config.class.getResourceAsStream("/factory_config.properties");
        try {
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
