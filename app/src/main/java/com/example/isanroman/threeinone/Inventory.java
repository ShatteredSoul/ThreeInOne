package com.example.isanroman.threeinone;

import android.support.v7.app.AppCompatActivity;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by isanroman on 10/12/2016.
 */

public class Inventory extends AppCompatActivity {

    private static double userMoney = 50000.0;
    private static Map<String, Integer> userResources = new HashMap<>();
    private static List<Integer> userItems = new ArrayList<>();

    public static void setMoney(double m){
        userMoney = m;
    }

    public static double getMoney(){
        return numberFormat();
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

    public static void addItem(int id){
        userItems.add(id);
    }

    public static int getItem(int index){
        return userItems.get(index);
    }

    public static void removeItem(int index){
        userItems.remove(index);
    }

    public static int getItemIndex(int id){
        return userItems.indexOf(id);
    }

    public static String[] getUsersItemsNames(){
        String temp[] = new String[userItems.size()];
        for(int i = 0; i < userItems.size(); i++){
            temp[i] = Items.getItemName(userItems.get(i));
        }

        return temp;
    }

    public static String[] getUsersItemsDesc(){
        String temp[] = new String[userItems.size()];
        for(int i = 0; i < userItems.size(); i++){
            temp[i] = Items.getItemDesc(userItems.get(i));
        }
        return temp;
    }

    private static double numberFormat(){
        NumberFormat nf = NumberFormat.getNumberInstance();
        nf.setMinimumFractionDigits(1);
        nf.setMaximumFractionDigits(2);

        double number = userMoney;
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
