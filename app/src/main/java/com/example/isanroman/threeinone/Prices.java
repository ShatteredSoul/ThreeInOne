package com.example.isanroman.threeinone;

import android.support.v7.app.AppCompatActivity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Gamer-Isaiah on 10/14/2016.
 */

public class Prices extends AppCompatActivity {

    private static Map<String, Double> marketPrices = new HashMap<>();

    public Prices(){
        marketPrices.put(getResources().getString(R.string.Copper), 1.75);
        marketPrices.put(getResources().getString(R.string.Aluminum), 0.50);
        marketPrices.put(getResources().getString(R.string.Diamond), 66867353300.80);
        marketPrices.put(getResources().getString(R.string.Gold), 1259.23);
        marketPrices.put(getResources().getString(R.string.Uranium), 31.10);
        marketPrices.put(getResources().getString(R.string.Tungsten), 19.85);
        marketPrices.put(getResources().getString(R.string.Silver), 236.76);
        marketPrices.put(getResources().getString(R.string.Platinum), 1480.00);
        marketPrices.put(getResources().getString(R.string.Iron), 0.24);
        marketPrices.put(getResources().getString(R.string.Osmium), 5909.00);
    }

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
        return marketPrices.get(name);
    }
}
