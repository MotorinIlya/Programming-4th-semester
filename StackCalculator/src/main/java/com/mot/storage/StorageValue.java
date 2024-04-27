package com.mot.storage;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.Map;

public class StorageValue {
    
    static private Deque<Double> stack;
    static private Map<String, Double> dictParams;

    public StorageValue() {
        stack = new ArrayDeque<Double>();
        dictParams = new HashMap<String, Double>();
    }

    public void push(Double value) {
        stack.push(value);
    }

    public Double pop() throws EmptyStackException {
        if (!stack.isEmpty()) {
            return stack.pop();
        }
        else { throw new EmptyStackException(); }
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public void put(String name, Double value) {
        dictParams.put(name, value);
    }

    public Double get(String name) {
        return dictParams.get(name);
    }

    public Double peek() {
        return stack.peek();
    }

    public boolean contains(String name) {
        return dictParams.containsKey(name);
    }
}
