package com.example.isanroman.threeinone;

import android.support.v7.app.AppCompatActivity;

import java.text.NumberFormat;
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

    public static void increaseProductionLevel(String name){
        int temp = productionLevel.get(name);
        productionLevel.put(name, temp + 1);
    }

    public static void setProduction(String name, double prod){
        production.put(name, prod);
    }

    public static void increaseProduction(String name){
        double temp = production.get(name);
        temp = temp + (temp * 0.25);
        production.put(name, temp);
    }

    public static double getProduction(String name){
        return numberFormat(name, "production");
    }

    public static void setCost(String name, double cost){
        upgradeCost.put(name, cost);
    }

    public static void increaseCost(String name){
        double temp = upgradeCost.get(name);
        temp = temp + (temp * 0.25);
        upgradeCost.put(name, temp);
    }

    public static double getCost(String name){
       return numberFormat(name, "upgradeCost");
    }

    private static double numberFormat(String name, String type){
        NumberFormat nf = NumberFormat.getNumberInstance();
        nf.setMinimumFractionDigits(1);
        nf.setMaximumFractionDigits(2);

        double number;

        if(type.equals("production"))
            number = production.get(name);
        else
            number = upgradeCost.get(name);

        nf.format(number);
        String a = Double.toString(number);

        boolean mark = false;
        String b = "";
        int count = 0;

        for(int i = 0; i < a.length(); i++){
            if(!mark){
                b += a.charAt(i);
                if(a.charAt(i) == '.')
                    mark = true;
            }else{
                if(count < 2) {
                    b += a.charAt(i);
                    count++;
                }
            }
        }

        return Double.parseDouble(b);
    }
}
