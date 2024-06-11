package com.mot.model.factory.storages;

import com.mot.model.factory.elements.Element;

import java.util.HashMap;

public class StorageMap {
    private final HashMap<Type, Storage<Element>> map;

    public enum Type {
        accessory,
        body,
        motor,
        car
    }

    public StorageMap() {
        map = new HashMap<>();
    }

    public void put(Type type, Storage<Element> storage) {
        map.put(type, storage);
    }

    public Storage<Element> get(Type type) {
        return map.get(type);
    }
}
