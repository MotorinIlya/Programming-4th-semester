package com.mot.commands;

import com.mot.storage.*;

import java.util.EmptyStackException;

import com.mot.exceptions.*;

public class Sqrt implements ComandWithoutParams{
    @Override
    public void execute(StorageValue storage) throws EmptyStackException, NegativeNumberException {
        double a = 0;
        if (!storage.isEmpty()) {
            a = storage.pop();
        }
        else { throw new EmptyStackException(); }
        if (a >= 0) {
            storage.push(Math.sqrt(a));
        }
        else { throw new NegativeNumberException(); }
    }
}
