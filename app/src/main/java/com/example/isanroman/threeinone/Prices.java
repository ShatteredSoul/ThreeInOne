package com.example.isanroman.threeinone;

import android.support.v7.app.AppCompatActivity;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Gamer-Isaiah on 10/14/2016.
 */

public class Prices extends AppCompatActivity {

    private static Map<String, Double> marketPrices = new HashMap<>();

    public static void setMarketPrices(String name, double price){
        marketPrices.put(name, price);
    }

    public static void setMarketPricesIncrease(String name, int quantity){
        double price = marketPrices.get(name);
        double temp = price * (quantity * 0.001);
        marketPrices.put(name, price + temp);
    }

    public static void setMarketPricesDecrease(String name, int quantity){
        double price = marketPrices.get(name);
        double temp = price * (quantity * 0.001);
        marketPrices.put(name, price - temp);
    }

    public static double getMarketPrices(String name){
        return numberFormat(name);
    }

    private static double numberFormat(String name){
        NumberFormat nf = NumberFormat.getNumberInstance();
        nf.setMinimumFractionDigits(1);
        nf.setMaximumFractionDigits(2);

        double number = marketPrices.get(name);
        String temp = nf.format(number);
        String finalString = "";

        for(int i = 0; i < temp.length(); i++){
            if(temp.charAt(i) == ','){

            }else{
                finalString += temp.charAt(i);
            }
        }

        return Double.parseDouble(finalString);
    }
}
