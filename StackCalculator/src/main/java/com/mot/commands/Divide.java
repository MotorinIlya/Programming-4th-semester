package com.mot.commands;

import java.util.EmptyStackException;

import com.mot.storage.*;;

public class Divide implements ComandWithoutParams {
    @Override
    public void execute(StorageValue storage) throws EmptyStackException {
        double a = 0, b = 0;
        if (!storage.isEmpty()) {
            a = storage.pop();
        }
        else { throw new EmptyStackException(); }

        if (!storage.isEmpty()) {
            b = storage.pop();
        }
        else { throw new EmptyStackException(); }
        storage.push(b / a);
    }
}
