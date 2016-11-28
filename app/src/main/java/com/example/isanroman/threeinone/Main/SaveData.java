package com.example.isanroman.threeinone.Main;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.isanroman.threeinone.Economics.Inventory;
import com.example.isanroman.threeinone.Economics.Mines;
import com.example.isanroman.threeinone.Economics.Prices;
import com.example.isanroman.threeinone.R;

/**
 * Created by Gamer-Isaiah on 10/18/2016.
 */

public class SaveData{

    private Context context;
    public static boolean marketPricesChange = false, resourceAmountChange = false, productionChange = false,
            costChange = false, productionLevelChange = false;

    public SaveData(Context con){
        context = con;
    }

    public void saveData(){
        SharedPreferences sp = context.getSharedPreferences("economics", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();

        editor.putString("userMoney", Double.toString(Inventory.getMoney()));

        if(marketPricesChange) {
            editor.putString("pCopper", Double.toString(Prices.getMarketPrices(context.getResources().getString(R.string.Copper))));
            editor.putString("pAluminum", Double.toString(Prices.getMarketPrices(context.getResources().getString(R.string.Aluminum))));
            editor.putString("pIron", Double.toString(Prices.getMarketPrices(context.getResources().getString(R.string.Iron))));
            editor.putString("pSilver", Double.toString(Prices.getMarketPrices(context.getResources().getString(R.string.Silver))));
            editor.putString("pTungsten", Double.toString(Prices.getMarketPrices(context.getResources().getString(R.string.Tungsten))));
            editor.putString("pOsmium", Double.toString(Prices.getMarketPrices(context.getResources().getString(R.string.Osmium))));
            editor.putString("pPlatinum", Double.toString(Prices.getMarketPrices(context.getResources().getString(R.string.Platinum))));
            editor.putString("pGold", Double.toString(Prices.getMarketPrices(context.getResources().getString(R.string.Gold))));
            editor.putString("pDiamond", Double.toString(Prices.getMarketPrices(context.getResources().getString(R.string.Diamond))));
            editor.putString("pUranium", Double.toString(Prices.getMarketPrices(context.getResources().getString(R.string.Uranium))));
            marketPricesChange = false;
        }

        if(resourceAmountChange) {
            editor.putString("iCopper", Integer.toString(Inventory.getResourceAmount(context.getResources().getString(R.string.Copper))));
            editor.putString("iAluminum", Integer.toString(Inventory.getResourceAmount(context.getResources().getString(R.string.Aluminum))));
            editor.putString("iIron", Integer.toString(Inventory.getResourceAmount(context.getResources().getString(R.string.Iron))));
            editor.putString("iSilver", Integer.toString(Inventory.getResourceAmount(context.getResources().getString(R.string.Silver))));
            editor.putString("iTungsten", Integer.toString(Inventory.getResourceAmount(context.getResources().getString(R.string.Tungsten))));
            editor.putString("iOsmium", Integer.toString(Inventory.getResourceAmount(context.getResources().getString(R.string.Osmium))));
            editor.putString("iPlatinum", Integer.toString(Inventory.getResourceAmount(context.getResources().getString(R.string.Platinum))));
            editor.putString("iGold", Integer.toString(Inventory.getResourceAmount(context.getResources().getString(R.string.Gold))));
            editor.putString("iDiamond", Integer.toString(Inventory.getResourceAmount(context.getResources().getString(R.string.Diamond))));
            editor.putString("iUranium", Integer.toString(Inventory.getResourceAmount(context.getResources().getString(R.string.Uranium))));
            resourceAmountChange = false;
        }

        if(productionChange) {
            editor.putString("mpCopper", Double.toString(Mines.getProduction(context.getResources().getString(R.string.Copper))));
            editor.putString("mpAluminum", Double.toString(Mines.getProduction(context.getResources().getString(R.string.Aluminum))));
            editor.putString("mpIron", Double.toString(Mines.getProduction(context.getResources().getString(R.string.Iron))));
            editor.putString("mpSilver", Double.toString(Mines.getProduction(context.getResources().getString(R.string.Silver))));
            editor.putString("mpTungsten", Double.toString(Mines.getProduction(context.getResources().getString(R.string.Tungsten))));
            editor.putString("mpOsmium", Double.toString(Mines.getProduction(context.getResources().getString(R.string.Osmium))));
            editor.putString("mpPlatinum", Double.toString(Mines.getProduction(context.getResources().getString(R.string.Platinum))));
            editor.putString("mpGold", Double.toString(Mines.getProduction(context.getResources().getString(R.string.Gold))));
            editor.putString("mpDiamond", Double.toString(Mines.getProduction(context.getResources().getString(R.string.Diamond))));
            editor.putString("mpUranium", Double.toString(Mines.getProduction(context.getResources().getString(R.string.Uranium))));
            productionChange = false;
        }

        if(costChange) {
            editor.putString("mcCopper", Double.toString(Mines.getCost(context.getResources().getString(R.string.Copper))));
            editor.putString("mcAluminum", Double.toString(Mines.getCost(context.getResources().getString(R.string.Aluminum))));
            editor.putString("mcIron", Double.toString(Mines.getCost(context.getResources().getString(R.string.Iron))));
            editor.putString("mcSilver", Double.toString(Mines.getCost(context.getResources().getString(R.string.Silver))));
            editor.putString("mcTungsten", Double.toString(Mines.getCost(context.getResources().getString(R.string.Tungsten))));
            editor.putString("mcOsmium", Double.toString(Mines.getCost(context.getResources().getString(R.string.Osmium))));
            editor.putString("mcPlatinum", Double.toString(Mines.getCost(context.getResources().getString(R.string.Platinum))));
            editor.putString("mcGold", Double.toString(Mines.getCost(context.getResources().getString(R.string.Gold))));
            editor.putString("mcDiamond", Double.toString(Mines.getCost(context.getResources().getString(R.string.Diamond))));
            editor.putString("mcUranium", Double.toString(Mines.getCost(context.getResources().getString(R.string.Uranium))));
            costChange = false;
        }

        if(productionLevelChange) {
            editor.putString("plCopper", Integer.toString(Mines.getProductionLevel(context.getResources().getString(R.string.Copper))));
            editor.putString("plAluminum", Integer.toString(Mines.getProductionLevel(context.getResources().getString(R.string.Aluminum))));
            editor.putString("plIron", Integer.toString(Mines.getProductionLevel(context.getResources().getString(R.string.Iron))));
            editor.putString("plSilver", Integer.toString(Mines.getProductionLevel(context.getResources().getString(R.string.Silver))));
            editor.putString("plTungsten", Integer.toString(Mines.getProductionLevel(context.getResources().getString(R.string.Tungsten))));
            editor.putString("plOsmium", Integer.toString(Mines.getProductionLevel(context.getResources().getString(R.string.Osmium))));
            editor.putString("plPlatinum", Integer.toString(Mines.getProductionLevel(context.getResources().getString(R.string.Platinum))));
            editor.putString("plGold", Integer.toString(Mines.getProductionLevel(context.getResources().getString(R.string.Gold))));
            editor.putString("plDiamond", Integer.toString(Mines.getProductionLevel(context.getResources().getString(R.string.Diamond))));
            editor.putString("plUranium", Integer.toString(Mines.getProductionLevel(context.getResources().getString(R.string.Uranium))));
            productionLevelChange = false;
        }

        editor.apply();
    }

    public void getData(){
        SharedPreferences sp = context.getSharedPreferences("economics", Context.MODE_PRIVATE);

        Inventory.setMoney(Double.parseDouble(sp.getString("userMoney", Double.toString(Inventory.getMoney()))));

        Prices.setMarketPrices(context.getResources().getString(R.string.Copper), Double.parseDouble(sp.getString("pCopper",Double.toString(Prices.getMarketPrices(context.getResources().getString(R.string.Copper))))));
        Prices.setMarketPrices(context.getResources().getString(R.string.Aluminum), Double.parseDouble(sp.getString("pAluminum", Double.toString(Prices.getMarketPrices(context.getResources().getString(R.string.Aluminum))))));
        Prices.setMarketPrices(context.getResources().getString(R.string.Iron), Double.parseDouble(sp.getString("pIron", Double.toString(Prices.getMarketPrices(context.getResources().getString(R.string.Iron))))));
        Prices.setMarketPrices(context.getResources().getString(R.string.Silver), Double.parseDouble(sp.getString("pSilver", Double.toString(Prices.getMarketPrices(context.getResources().getString(R.string.Silver))))));
        Prices.setMarketPrices(context.getResources().getString(R.string.Tungsten), Double.parseDouble(sp.getString("pTungsten", Double.toString(Prices.getMarketPrices(context.getResources().getString(R.string.Tungsten))))));
        Prices.setMarketPrices(context.getResources().getString(R.string.Osmium), Double.parseDouble(sp.getString("pOsmium", Double.toString(Prices.getMarketPrices(context.getResources().getString(R.string.Osmium))))));
        Prices.setMarketPrices(context.getResources().getString(R.string.Platinum), Double.parseDouble(sp.getString("pPlatinum", Double.toString(Prices.getMarketPrices(context.getResources().getString(R.string.Platinum))))));
        Prices.setMarketPrices(context.getResources().getString(R.string.Gold), Double.parseDouble(sp.getString("pGold", Double.toString(Prices.getMarketPrices(context.getResources().getString(R.string.Gold))))));
        Prices.setMarketPrices(context.getResources().getString(R.string.Diamond), Double.parseDouble(sp.getString("pDiamond", Double.toString(Prices.getMarketPrices(context.getResources().getString(R.string.Diamond))))));
        Prices.setMarketPrices(context.getResources().getString(R.string.Uranium), Double.parseDouble(sp.getString("pUranium", Double.toString(Prices.getMarketPrices(context.getResources().getString(R.string.Uranium))))));

        Inventory.setResources(context.getResources().getString(R.string.Copper), Integer.parseInt(sp.getString("iCopper",Integer.toString(Inventory.getResourceAmount(context.getResources().getString(R.string.Copper))))));
        Inventory.setResources(context.getResources().getString(R.string.Aluminum), Integer.parseInt(sp.getString("iAluminum", Integer.toString(Inventory.getResourceAmount(context.getResources().getString(R.string.Aluminum))))));
        Inventory.setResources(context.getResources().getString(R.string.Iron), Integer.parseInt(sp.getString("iIron", Integer.toString(Inventory.getResourceAmount(context.getResources().getString(R.string.Iron))))));
        Inventory.setResources(context.getResources().getString(R.string.Silver), Integer.parseInt(sp.getString("iSilver", Integer.toString(Inventory.getResourceAmount(context.getResources().getString(R.string.Silver))))));
        Inventory.setResources(context.getResources().getString(R.string.Tungsten), Integer.parseInt(sp.getString("iTungsten", Integer.toString(Inventory.getResourceAmount(context.getResources().getString(R.string.Tungsten))))));
        Inventory.setResources(context.getResources().getString(R.string.Osmium), Integer.parseInt(sp.getString("iOsmium", Integer.toString(Inventory.getResourceAmount(context.getResources().getString(R.string.Osmium))))));
        Inventory.setResources(context.getResources().getString(R.string.Platinum), Integer.parseInt(sp.getString("iPlatinum", Integer.toString(Inventory.getResourceAmount(context.getResources().getString(R.string.Platinum))))));
        Inventory.setResources(context.getResources().getString(R.string.Gold), Integer.parseInt(sp.getString("iGold", Integer.toString(Inventory.getResourceAmount(context.getResources().getString(R.string.Gold))))));
        Inventory.setResources(context.getResources().getString(R.string.Diamond), Integer.parseInt(sp.getString("iDiamond", Integer.toString(Inventory.getResourceAmount(context.getResources().getString(R.string.Diamond))))));
        Inventory.setResources(context.getResources().getString(R.string.Uranium), Integer.parseInt(sp.getString("iUranium", Integer.toString(Inventory.getResourceAmount(context.getResources().getString(R.string.Uranium))))));

        Mines.setProduction(context.getResources().getString(R.string.Copper), Double.parseDouble(sp.getString("mpCopper", Double.toString(Mines.getProduction(context.getResources().getString(R.string.Copper))))));
        Mines.setProduction(context.getResources().getString(R.string.Aluminum), Double.parseDouble(sp.getString("mpAluminum", Double.toString(Mines.getProduction(context.getResources().getString(R.string.Aluminum))))));
        Mines.setProduction(context.getResources().getString(R.string.Iron), Double.parseDouble(sp.getString("mpIron", Double.toString(Mines.getProduction(context.getResources().getString(R.string.Iron))))));
        Mines.setProduction(context.getResources().getString(R.string.Silver), Double.parseDouble(sp.getString("mpSilver", Double.toString(Mines.getProduction(context.getResources().getString(R.string.Silver))))));
        Mines.setProduction(context.getResources().getString(R.string.Tungsten), Double.parseDouble(sp.getString("mpTungsten", Double.toString(Mines.getProduction(context.getResources().getString(R.string.Tungsten))))));
        Mines.setProduction(context.getResources().getString(R.string.Osmium), Double.parseDouble(sp.getString("mpOsmium", Double.toString(Mines.getProduction(context.getResources().getString(R.string.Osmium))))));
        Mines.setProduction(context.getResources().getString(R.string.Platinum), Double.parseDouble(sp.getString("mpPlatinum", Double.toString(Mines.getProduction(context.getResources().getString(R.string.Platinum))))));
        Mines.setProduction(context.getResources().getString(R.string.Gold), Double.parseDouble(sp.getString("mpGold", Double.toString(Mines.getProduction(context.getResources().getString(R.string.Gold))))));
        Mines.setProduction(context.getResources().getString(R.string.Diamond), Double.parseDouble(sp.getString("mpDiamond", Double.toString(Mines.getProduction(context.getResources().getString(R.string.Diamond))))));
        Mines.setProduction(context.getResources().getString(R.string.Uranium), Double.parseDouble(sp.getString("mpUranium", Double.toString(Mines.getProduction(context.getResources().getString(R.string.Uranium))))));

        Mines.setCost(context.getResources().getString(R.string.Copper), Double.parseDouble(sp.getString("mcCopper", Double.toString(Mines.getCost(context.getResources().getString(R.string.Copper))))));
        Mines.setCost(context.getResources().getString(R.string.Aluminum), Double.parseDouble(sp.getString("mcAluminum", Double.toString(Mines.getCost(context.getResources().getString(R.string.Aluminum))))));
        Mines.setCost(context.getResources().getString(R.string.Iron), Double.parseDouble(sp.getString("mcIron", Double.toString(Mines.getCost(context.getResources().getString(R.string.Iron))))));
        Mines.setCost(context.getResources().getString(R.string.Silver), Double.parseDouble(sp.getString("mcSilver", Double.toString(Mines.getCost(context.getResources().getString(R.string.Silver))))));
        Mines.setCost(context.getResources().getString(R.string.Tungsten), Double.parseDouble(sp.getString("mcTungsten", Double.toString(Mines.getCost(context.getResources().getString(R.string.Tungsten))))));
        Mines.setCost(context.getResources().getString(R.string.Osmium), Double.parseDouble(sp.getString("mcOsmium", Double.toString(Mines.getCost(context.getResources().getString(R.string.Osmium))))));
        Mines.setCost(context.getResources().getString(R.string.Platinum), Double.parseDouble(sp.getString("mcPlatinum", Double.toString(Mines.getCost(context.getResources().getString(R.string.Platinum))))));
        Mines.setCost(context.getResources().getString(R.string.Gold), Double.parseDouble(sp.getString("mcGold", Double.toString(Mines.getCost(context.getResources().getString(R.string.Gold))))));
        Mines.setCost(context.getResources().getString(R.string.Diamond), Double.parseDouble(sp.getString("mcDiamond", Double.toString(Mines.getCost(context.getResources().getString(R.string.Diamond))))));
        Mines.setCost(context.getResources().getString(R.string.Uranium), Double.parseDouble(sp.getString("mcUranium", Double.toString(Mines.getCost(context.getResources().getString(R.string.Uranium))))));

        Mines.setProductionLevel(context.getResources().getString(R.string.Copper), Integer.parseInt(sp.getString("plCopper", Integer.toString(Mines.getProductionLevel(context.getResources().getString(R.string.Copper))))));
        Mines.setProductionLevel(context.getResources().getString(R.string.Aluminum), Integer.parseInt(sp.getString("plAluminum", Integer.toString(Mines.getProductionLevel(context.getResources().getString(R.string.Aluminum))))));
        Mines.setProductionLevel(context.getResources().getString(R.string.Iron), Integer.parseInt(sp.getString("plIron", Integer.toString(Mines.getProductionLevel(context.getResources().getString(R.string.Iron))))));
        Mines.setProductionLevel(context.getResources().getString(R.string.Silver), Integer.parseInt(sp.getString("plSilver", Integer.toString(Mines.getProductionLevel(context.getResources().getString(R.string.Silver))))));
        Mines.setProductionLevel(context.getResources().getString(R.string.Tungsten), Integer.parseInt(sp.getString("plTungsten", Integer.toString(Mines.getProductionLevel(context.getResources().getString(R.string.Tungsten))))));
        Mines.setProductionLevel(context.getResources().getString(R.string.Osmium), Integer.parseInt(sp.getString("plOsmium", Integer.toString(Mines.getProductionLevel(context.getResources().getString(R.string.Osmium))))));
        Mines.setProductionLevel(context.getResources().getString(R.string.Platinum), Integer.parseInt(sp.getString("plPlatinum", Integer.toString(Mines.getProductionLevel(context.getResources().getString(R.string.Platinum))))));
        Mines.setProductionLevel(context.getResources().getString(R.string.Gold), Integer.parseInt(sp.getString("plGold", Integer.toString(Mines.getProductionLevel(context.getResources().getString(R.string.Gold))))));
        Mines.setProductionLevel(context.getResources().getString(R.string.Diamond), Integer.parseInt(sp.getString("plDiamond", Integer.toString(Mines.getProductionLevel(context.getResources().getString(R.string.Diamond))))));
        Mines.setProductionLevel(context.getResources().getString(R.string.Uranium), Integer.parseInt(sp.getString("plUranium", Integer.toString(Mines.getProductionLevel(context.getResources().getString(R.string.Uranium))))));
    }
}