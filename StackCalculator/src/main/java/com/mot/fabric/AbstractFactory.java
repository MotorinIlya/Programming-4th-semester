package com.mot.fabric;

import com.mot.commands.*;

public class AbstractFactory {
    public Comand createComand(String comandName) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        Class<?> nameFactoryClass = Class.forName(comandName);
        @SuppressWarnings("deprecation")
        Object comand = nameFactoryClass.newInstance();
        return (Comand) comand;
    }
}
