package com.example.isanroman.threeinone.Economics;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.isanroman.threeinone.Main.Data;
import com.example.isanroman.threeinone.Main_Fragment.ListFragmentView;
import com.example.isanroman.threeinone.R;
import com.example.isanroman.threeinone.Main.SaveData;

import java.text.NumberFormat;
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
    private static String multiplier;
    SaveData saveData = new SaveData(EconomicsPurchase.this);

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

        multiplier = Double.toString(Prices.getMarketPrices(row_pos.getName()));

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
                    buyQuantity = Integer.parseInt(editText.getText().toString());
                    buyTotal.setText(numberFormat(buyQuantity, multiplier, "buy"));
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
                    sellQuantity = Integer.parseInt(editText1.getText().toString());
                    sellTotal.setText(numberFormat(sellQuantity, multiplier, "sell"));
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
                    SaveData.marketPricesChange = true;
                    SaveData.resourceAmountChange = true;
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
                    SaveData.marketPricesChange = true;
                    SaveData.resourceAmountChange = true;
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

        multiplier = Double.toString(Prices.getMarketPrices(row_pos.getName()));
        buyAmount = Double.parseDouble(numberFormat(buyQuantity, multiplier, "buy"));
        sellAmount = Double.parseDouble(numberFormat(sellQuantity, multiplier, "sell"));

        TextView textBuyTotal = (TextView)findViewById(R.id.resourceTotalPrice);
        textBuyTotal.setText(Double.toString(buyAmount));

        TextView textSellTotal = (TextView)findViewById(R.id.resourceTotalSellPrice);
        textSellTotal.setText(Double.toString(sellAmount));
    }

    @Override
    protected void onPause(){
        super.onPause();
        new Thread(new Runnable() {
            @Override
            public void run() {
                saveData.saveData();
            }
        }).start();
    }

    private String numberFormat(double value, String multiplier, String mode){
        NumberFormat nf = NumberFormat.getNumberInstance();
        nf.setMinimumFractionDigits(1);
        nf.setMaximumFractionDigits(2);

        double temp;

        if(mode.equals("buy"))
            temp = value * Double.parseDouble(multiplier);
        else
            temp = (value * Double.parseDouble(multiplier)) - ((value * Double.parseDouble(multiplier)) * 0.2);

            nf.format(temp);

            String a = Double.toString(temp);

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

            return b;
    }
}
