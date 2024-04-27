package com.mot.commands;

import java.util.EmptyStackException;

import com.mot.storage.*;;

public class Pop implements ComandWithoutParams {
    public void execute(StorageValue storage) throws EmptyStackException {
        if (!storage.isEmpty()) {
            storage.pop();
        }
        else { throw new EmptyStackException(); }
    }
}
