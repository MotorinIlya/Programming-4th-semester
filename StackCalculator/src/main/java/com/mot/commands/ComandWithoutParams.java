package com.mot.commands;

import java.util.EmptyStackException;

import com.mot.storage.*;
import com.mot.exceptions.*;;

public interface ComandWithoutParams extends Comand {
    public void execute(StorageValue storage) throws EmptyStackException, NegativeNumberException;
}
