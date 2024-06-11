package com.mot.util;

public class IDGenerator {
    private static int lastID = 0;

    public synchronized static int getID() {
        return ++lastID;
    }
}