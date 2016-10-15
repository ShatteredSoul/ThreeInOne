package com.example.isanroman.threeinone;

import android.support.v7.app.AppCompatActivity;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by isanroman on 10/12/2016.
 */

public class Inventory extends AppCompatActivity {

    private static double userMoney = 500;
    private static Map<String, Integer> userResources = new HashMap<>();

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

    public static void setResources(String name, int amount){
        userResources.put(name, amount);
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
        if(userResources.get(name) == null)
            return 0;
        else
            return userResources.get(name);
    }
}
