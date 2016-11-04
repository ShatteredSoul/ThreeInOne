package com.example.isanroman.threeinone;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by isanroman on 11/3/2016.
 */

public class Items {

    private static Map<Integer, String> itemNames = new HashMap<>();
    private static Map<Integer, String> itemDesc = new HashMap<>();
    private static Map<Integer, Integer> itemImage = new HashMap<>();
    private static Map<Integer, Integer> itemLevel = new HashMap<>();
    private static Map<Integer, Double> itemPrice = new HashMap<>();

    public static void setItems(String name, String desc, int id, int image, int level, double sellValue){
        itemNames.put(id, name);
        itemDesc.put(id, desc);
        itemImage.put(id, image);
        itemLevel.put(id, level);
        itemPrice.put(id, sellValue);
    }

    public static String getItemName(int id){
        return itemNames.get(id);
    }

    public static String getItemDesc(int id){
        return itemDesc.get(id);
    }

    public static String[] getItemNameArray(){
        String temp[] = new String[itemNames.size()];
        for(int i = 0; i < itemNames.size(); i++){
            temp[i] = itemNames.get(i);
        }
        return temp;
    }

    public static String[] getItemDescArray(){
        String temp[] = new String[itemDesc.size()];
        for(int i = 0; i < itemDesc.size(); i++){
            temp[i] = itemDesc.get(i);
        }
        return temp;
    }

    public static int getItemImage(int id){
        return itemImage.get(id);
    }

    public static int getItemId(String name){
        int id = 0;
        for(int i = 1; i <= itemNames.size(); i++){
            String temp = "00" + i;
            if(itemNames.get(Integer.parseInt(temp)).equals(name))
                id = Integer.parseInt(temp);
        }
        return id;
    }

    public static int getItemLevel(int id){
        return itemLevel.get(id);
    }

    public static double getItemPrice(int id){
        return itemPrice.get(id);
    }
}
