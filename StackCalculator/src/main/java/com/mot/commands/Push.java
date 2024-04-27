package com.mot.commands;

import com.mot.storage.*;;

public class Push implements ComandWithParams {
    @Override
    public void execute(StorageValue storage, String[] signature) {
        if (storage.contains(signature[1])) {
            storage.push(storage.get(signature[1]));
        }
        else {
            try {
                storage.push(Double.parseDouble(signature[1]));
            }
            catch (NumberFormatException e) {
                e.getMessage();
            }
        }
        
    }
}
