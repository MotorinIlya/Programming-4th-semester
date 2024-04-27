package com.mot.commands;

import com.mot.storage.*;

public interface ComandWithParams extends Comand {
    public void execute(StorageValue storage, String[] args);  
}
