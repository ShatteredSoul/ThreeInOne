package com.example.isanroman.threeinone;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by isanroman on 10/10/2016.
 */

public class EconomicsActivity extends FragmentActivity{

    @Override
    protected void onCreate(Bundle savedInstanceBundle){
        super.onCreate(savedInstanceBundle);
        setContentView(R.layout.activity_economics);

        TextView textView = (TextView)findViewById(R.id.economicsTitle);
        textView.setText(ListFragmentView.getContent());

        Button bButton = (Button)findViewById(R.id.ebackbutton);
        bButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    @Override
    protected void onPause(){
        super.onPause();
        saveData();
    }

    @Override
    protected void onResume(){
        super.onResume();
        List<Data> data = new ArrayList<Data>();
        String title[] = getTitles();
        String desc[] = getDescr();
        for(int i = 0; i < title.length; i++){
            Data temp = new Data(title[i], desc[i]);
            data.add(temp);
        }

        ListFragmentView.refreshedData(data);
    }

    private String[] getTitles(){
        String titles[] = getResources().getStringArray(R.array.economicsItems);
        return titles;
    }

    private String[] getDescr(){
        String titles[] = getResources().getStringArray(R.array.economicsItems);
        String desc[] = new String[10];
        for(int i = 0; i < 10; i++){
            desc[i] = Double.toString(Prices.getMarketPrices(titles[i]));
        }

        return desc;
    }

    public void saveData() {
        SharedPreferences sp = this.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();

        editor.putString("userMoney", Double.toString(Inventory.getMoney()));

        editor.putString("pCopper", Double.toString(Prices.getMarketPrices(getResources().getString(R.string.Copper))));
        editor.putString("pAluminum", Double.toString(Prices.getMarketPrices(getResources().getString(R.string.Aluminum))));
        editor.putString("pIron", Double.toString(Prices.getMarketPrices(getResources().getString(R.string.Iron))));
        editor.putString("pSilver", Double.toString(Prices.getMarketPrices(getResources().getString(R.string.Silver))));
        editor.putString("pTungsten", Double.toString(Prices.getMarketPrices(getResources().getString(R.string.Tungsten))));
        editor.putString("pOsmium", Double.toString(Prices.getMarketPrices(getResources().getString(R.string.Osmium))));
        editor.putString("pPlatinum", Double.toString(Prices.getMarketPrices(getResources().getString(R.string.Platinum))));
        editor.putString("pGold", Double.toString(Prices.getMarketPrices(getResources().getString(R.string.Gold))));
        editor.putString("pDiamond", Double.toString(Prices.getMarketPrices(getResources().getString(R.string.Diamond))));
        editor.putString("pUranium", Double.toString(Prices.getMarketPrices(getResources().getString(R.string.Uranium))));

        editor.putString("iCopper", Integer.toString(Inventory.getResourceAmount(getResources().getString(R.string.Copper))));
        editor.putString("iAluminum", Integer.toString(Inventory.getResourceAmount(getResources().getString(R.string.Aluminum))));
        editor.putString("iIron", Integer.toString(Inventory.getResourceAmount(getResources().getString(R.string.Iron))));
        editor.putString("iSilver", Integer.toString(Inventory.getResourceAmount(getResources().getString(R.string.Silver))));
        editor.putString("iTungsten", Integer.toString(Inventory.getResourceAmount(getResources().getString(R.string.Tungsten))));
        editor.putString("iOsmium", Integer.toString(Inventory.getResourceAmount(getResources().getString(R.string.Osmium))));
        editor.putString("iPlatinum", Integer.toString(Inventory.getResourceAmount(getResources().getString(R.string.Platinum))));
        editor.putString("iGold", Integer.toString(Inventory.getResourceAmount(getResources().getString(R.string.Gold))));
        editor.putString("iDiamond", Integer.toString(Inventory.getResourceAmount(getResources().getString(R.string.Diamond))));
        editor.putString("iUranium", Integer.toString(Inventory.getResourceAmount(getResources().getString(R.string.Uranium))));

        editor.putString("mpCopper", Double.toString(Mines.getProduction(getResources().getString(R.string.Copper))));
        editor.putString("mpAluminum", Double.toString(Mines.getProduction(getResources().getString(R.string.Aluminum))));
        editor.putString("mpIron", Double.toString(Mines.getProduction(getResources().getString(R.string.Iron))));
        editor.putString("mpSilver", Double.toString(Mines.getProduction(getResources().getString(R.string.Silver))));
        editor.putString("mpTungsten", Double.toString(Mines.getProduction(getResources().getString(R.string.Tungsten))));
        editor.putString("mpOsmium", Double.toString(Mines.getProduction(getResources().getString(R.string.Osmium))));
        editor.putString("mpPlatinum", Double.toString(Mines.getProduction(getResources().getString(R.string.Platinum))));
        editor.putString("mpGold", Double.toString(Mines.getProduction(getResources().getString(R.string.Gold))));
        editor.putString("mpDiamond", Double.toString(Mines.getProduction(getResources().getString(R.string.Diamond))));
        editor.putString("mpUranium", Double.toString(Mines.getProduction(getResources().getString(R.string.Uranium))));

        editor.putString("mcCopper", Double.toString(Mines.getCost(getResources().getString(R.string.Copper))));
        editor.putString("mcAluminum", Double.toString(Mines.getCost(getResources().getString(R.string.Aluminum))));
        editor.putString("mcIron", Double.toString(Mines.getCost(getResources().getString(R.string.Iron))));
        editor.putString("mcSilver", Double.toString(Mines.getCost(getResources().getString(R.string.Silver))));
        editor.putString("mcTungsten", Double.toString(Mines.getCost(getResources().getString(R.string.Tungsten))));
        editor.putString("mcOsmium", Double.toString(Mines.getCost(getResources().getString(R.string.Osmium))));
        editor.putString("mcPlatinum", Double.toString(Mines.getCost(getResources().getString(R.string.Platinum))));
        editor.putString("mcGold", Double.toString(Mines.getCost(getResources().getString(R.string.Gold))));
        editor.putString("mcDiamond", Double.toString(Mines.getCost(getResources().getString(R.string.Diamond))));
        editor.putString("mcUranium", Double.toString(Mines.getCost(getResources().getString(R.string.Uranium))));

        editor.putString("plCopper", Integer.toString(Mines.getProductionLevel(getResources().getString(R.string.Copper))));
        editor.putString("plAluminum", Integer.toString(Mines.getProductionLevel(getResources().getString(R.string.Aluminum))));
        editor.putString("plIron", Integer.toString(Mines.getProductionLevel(getResources().getString(R.string.Iron))));
        editor.putString("plSilver", Integer.toString(Mines.getProductionLevel(getResources().getString(R.string.Silver))));
        editor.putString("plTungsten", Integer.toString(Mines.getProductionLevel(getResources().getString(R.string.Tungsten))));
        editor.putString("plOsmium", Integer.toString(Mines.getProductionLevel(getResources().getString(R.string.Osmium))));
        editor.putString("plPlatinum", Integer.toString(Mines.getProductionLevel(getResources().getString(R.string.Platinum))));
        editor.putString("plGold", Integer.toString(Mines.getProductionLevel(getResources().getString(R.string.Gold))));
        editor.putString("plDiamond", Integer.toString(Mines.getProductionLevel(getResources().getString(R.string.Diamond))));
        editor.putString("plUranium", Integer.toString(Mines.getProductionLevel(getResources().getString(R.string.Uranium))));

        editor.apply();
    }

}
