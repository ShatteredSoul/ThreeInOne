package com.example.isanroman.threeinone;


import android.util.SparseIntArray;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by isanroman on 10/12/2016.
 */

public class Inventory {

    private static double userMoney = 0;
    private static Map<String, Integer> userResources = new HashMap<>();

    public Inventory(){
        userResources.put("Copper", 0);
        userResources.put("Aluminum", 0);
        userResources.put("Diamond", 0);
        userResources.put("Gold", 0);
        userResources.put("Uranium", 0);
        userResources.put("Tungsten", 0);
        userResources.put("Silver", 0);
        userResources.put("Platinum", 0);
        userResources.put("Iron", 0);
        userResources.put("Osmium", 0);
    }

    public static void setMoney(double m){
        userMoney = m;
    }

    public static double getMoney(){
        return userMoney;
    }

    public static void subtractMoney(double m){
        userMoney -= m;
    }

    public static void addMoney(double m){
        userMoney += m;
    }

    public static void addResource(String name, int amount){
        int temp = userResources.get(name);
        userResources.put(name, temp + amount);
    }

    public static void removeResource(String name, int amount){
        int temp = userResources.get(name);
        userResources.put(name, temp - amount);
    }

    public static int getResourceAmount(String name){
        return userResources.get(name);
    }
}
