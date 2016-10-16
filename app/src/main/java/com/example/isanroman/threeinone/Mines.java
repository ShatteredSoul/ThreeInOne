package com.example.isanroman.threeinone;

import android.support.v7.app.AppCompatActivity;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Gamer-Isaiah on 10/15/2016.
 */

public class Mines extends AppCompatActivity {

    private static Map<String, Double> production = new HashMap<>();
    private static Map<String, Double> upgradeCost = new HashMap<>();
    private static Map<String, Integer> productionLevel = new HashMap<>();

    public static void setProductionLevel(String name, int level){
        productionLevel.put(name, level);
    }

    public static int getProductionLevel(String name){
        return productionLevel.get(name);
    }

    public static void setProduction(String name, double prod){
        production.put(name, prod);
    }

    public static void increaseProduction(String name){
        double temp = production.get(name);
        temp = temp + (temp * 0.05);
        production.put(name, temp);
    }

    public static double getProduction(String name){
        return production.get(name);
    }

    public static void setCost(String name, double cost){
        upgradeCost.put(name, cost);
    }

    public static void increaseCost(String name){
        double temp = production.get(name);
        temp = temp + (temp * 0.05);
        production.put(name, temp);
    }

    public static double getCost(String name){
       return upgradeCost.get(name);
    }
}
