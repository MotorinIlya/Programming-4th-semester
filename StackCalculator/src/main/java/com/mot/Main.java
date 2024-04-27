package com.mot;

import com.mot.comanders.*;
import java.util.List;

public class Main {
    static String path = "./";
    public static void main(String[] args) {
        if (args.length != 0) {
            List<String> comands = GetComander.getComands(path, args[0]);
            ExecuteComander.executeFileComands(comands);
        }
        else {
            ExecuteComander.executeInputComands();
        }
    }
}