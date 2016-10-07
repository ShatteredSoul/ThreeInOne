package com.example.isanroman.threeinone;

/**
 * Created by isanroman on 10/7/2016.
 */

public class Currency {

    private static int totalCurrency = 0;

    public static void addCurrency(int add){
        totalCurrency += add;
    }

    public static void removeCurrency(int rem){
        totalCurrency -= rem;
    }

    public static int getTotalCurrency(){
        return totalCurrency;
    }
}
