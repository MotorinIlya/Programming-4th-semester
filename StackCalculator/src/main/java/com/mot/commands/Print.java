package com.mot.commands;

import java.util.EmptyStackException;

import com.mot.storage.*;;

public class Print implements ComandWithoutParams {
    public void execute(StorageValue storage) throws EmptyStackException {
        if (!storage.isEmpty()) {
            System.out.println(storage.peek());
        }
        else {
            throw new EmptyStackException();
        }
    }
}
