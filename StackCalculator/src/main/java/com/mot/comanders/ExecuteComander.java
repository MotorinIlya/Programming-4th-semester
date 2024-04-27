package com.mot.comanders;

import java.util.EmptyStackException;
import java.util.List;
import com.mot.commands.*;
import com.mot.fabric.*;
import com.mot.storage.*;
import com.mot.exceptions.*;


public class ExecuteComander {
    public static void executeFileComands(List<String> comands) {
        StorageValue storage = new StorageValue();
        
        for (String comand : comands) {
            ExecuteComander.executeComand(storage, comand);
        }
    }

    public static void executeInputComands() {
        StorageValue storage = new StorageValue();
        String comand = System.console().readLine();
        
        while (!comand.equalsIgnoreCase("exit")) {
            ExecuteComander.executeComand(storage, comand);
            comand = System.console().readLine();
        }
    }

    private static void executeComand(StorageValue storage, String comand) {
        String[] signature = comand.split(" ");
        if (signature[0].charAt(0) != '#') {
            try {
                String comandName = "com.mot.commands." + signature[0];

                AbstractFactory factory = new AbstractFactory();
                Comand newComand = factory.createComand(comandName);

                if (newComand instanceof ComandWithParams) {
                    ((ComandWithParams)newComand).execute(storage, signature);
                }             
                else if (newComand instanceof ComandWithoutParams) {
                    ((ComandWithoutParams)newComand).execute(storage);
                }
            }
            catch (InstantiationException e) {
                System.out.println("bad input");
            }
            catch (IllegalAccessException e) {
                System.out.println("bad input");
            }
            catch (ClassNotFoundException e) {
                System.out.println("bad input");
            }
            catch (IllegalArgumentException e) {
                System.out.println("bad input");
            }
            catch (EmptyStackException e) {
                System.out.println("Invisible for count");
            }
            catch (NegativeNumberException e) {
                System.out.println("Нow can't take the root of a negative number");
            }
        }
    }
}
