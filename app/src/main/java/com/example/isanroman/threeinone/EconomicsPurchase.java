package com.example.isanroman.threeinone;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gamer-Isaiah on 10/11/2016.
 */

public class EconomicsPurchase extends AppCompatActivity{

    private List<Data> row_items;
    private static Data row_pos;
    private static double buyAmount, sellAmount;
    private static int buyQuantity, sellQuantity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_economics_purchace);

        row_items = ListFragmentView.getListData();
        row_pos = row_items.get(ListFragmentView.getPosition());

        TextView textName = (TextView)findViewById(R.id.resourceName);
        TextView textPrice = (TextView)findViewById(R.id.resourcePrice);
        TextView textQuantity = (TextView)findViewById(R.id.resourceQuantity);
        final TextView textMoney = (TextView)findViewById(R.id.resourceMoney);
        final TextView buyTotal = (TextView)findViewById(R.id.resourceTotalPrice);
        final TextView sellTotal = (TextView)findViewById(R.id.resourceTotalSellPrice);
        Button buyButton = (Button)findViewById(R.id.buyButton);
        Button sellButton = (Button)findViewById(R.id.sellButton);
        Button backButton = (Button)findViewById(R.id.epBackButton);

        final EditText editText = (EditText)findViewById(R.id.resourceSetQuantity);
        editText.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                try {
                    String text = editText.getText().toString();
                    String multiplier = row_pos.getId();
                    double times = Double.parseDouble(multiplier);
                    int value = Integer.parseInt(text);
                    buyQuantity = value;
                    buyAmount = value * times;
                    text = Double.toString(value * times);
                    buyTotal.setText(text);
                }catch(NumberFormatException e){e.printStackTrace();}
            }
        });

        final EditText editText1 = (EditText)findViewById(R.id.resourceSetSellQuantity);
        editText1.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                try {
                    String text = editText1.getText().toString();
                    String multiplier = row_pos.getId();
                    double times = Double.parseDouble(multiplier);
                    int value = Integer.parseInt(text);
                    sellQuantity = value;
                    sellAmount = (value * times) - ((value * times) * .2);
                    text = Double.toString((value * times) - ((value * times) * .2));
                    sellTotal.setText(text);
                }catch(NumberFormatException e){e.printStackTrace();}
            }
        });

        buyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Inventory.getMoney() >= buyAmount){
                    Toast.makeText(EconomicsPurchase.this, R.string.buy_successful, Toast.LENGTH_SHORT).show();
                    Inventory.subtractMoney(buyAmount);
                    Inventory.addResource(row_pos.getName(), buyQuantity);
                    Prices.setMarketPricesIncrease(row_pos.getName(), buyQuantity);
                    TextView textView = (TextView)v.findViewById(R.id.list_item_description);// this is a test to see if automatic changes happen to the list fragment
                    textView.setText(Double.toString(Prices.getMarketPrices(row_pos.getName())));
                    updateUI();
                }else Toast.makeText(EconomicsPurchase.this, R.string.buy_unsuccessful, Toast.LENGTH_SHORT).show();
            }
        });

        sellButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Inventory.getResourceAmount(row_pos.getName()) >= sellQuantity){
                    Toast.makeText(EconomicsPurchase.this, R.string.sell_successful, Toast.LENGTH_SHORT).show();
                    Inventory.addMoney(sellAmount);
                    Inventory.removeResource(row_pos.getName(), sellQuantity);
                    Prices.setMarketPricesDecrease(row_pos.getName(), sellQuantity);
                    TextView textView = (TextView)v.findViewById(R.id.list_item_description); //this is a test to see if automatic changes happen to the list fragment
                    textView.setText(Double.toString(Prices.getMarketPrices(row_pos.getName())));
                    updateUI();
                }else Toast.makeText(EconomicsPurchase.this, R.string.sell_unsuccessful, Toast.LENGTH_SHORT).show();
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String titles[] = getResources().getStringArray(R.array.economicsItems);
                String desc[] = new String[10];
                for(int i = 0; i < 10; i++){
                    desc[i] = Double.toString(Prices.getMarketPrices(titles[i]));
                }
                List<Data> data = new ArrayList<Data>();
                for(int i = 0; i < titles.length; i++){
                    Data temp = new Data(titles[i], desc[i]);
                    data.add(temp);
                }
                ListFragmentView.refreshedData(data);
                onBackPressed();
            }
        });

        textName.setText(row_pos.getName());
        textPrice.setText(row_pos.getId());
        textMoney.setText(Double.toString(Inventory.getMoney()));
        textQuantity.setText(Integer.toString(Inventory.getResourceAmount(row_pos.getName())));
    }

    private void updateUI(){
        TextView textView = (TextView)findViewById(R.id.resourceQuantity);
        textView.setText(Integer.toString(Inventory.getResourceAmount(row_pos.getName())));

        TextView textMoney = (TextView)findViewById(R.id.resourceMoney);
        textMoney.setText(Double.toString(Inventory.getMoney()));

        TextView textPrice = (TextView)findViewById(R.id.resourcePrice);
        textPrice.setText(Double.toString(Prices.getMarketPrices(row_pos.getName())));
    }

    @Override
    protected void onPause(){
        super.onPause();
        saveData();
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
