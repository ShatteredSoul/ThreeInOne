package com.example.isanroman.threeinone;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Inventory.setResources(getResources().getString(R.string.Copper), 0);
        Inventory.setResources(getResources().getString(R.string.Aluminum), 0);
        Inventory.setResources(getResources().getString(R.string.Diamond), 0);
        Inventory.setResources(getResources().getString(R.string.Gold), 0);
        Inventory.setResources(getResources().getString(R.string.Uranium), 0);
        Inventory.setResources(getResources().getString(R.string.Tungsten), 0);
        Inventory.setResources(getResources().getString(R.string.Silver), 0);
        Inventory.setResources(getResources().getString(R.string.Platinum), 0);
        Inventory.setResources(getResources().getString(R.string.Iron), 0);
        Inventory.setResources(getResources().getString(R.string.Osmium), 0);

        Prices.setMarketPrices(getResources().getString(R.string.Copper), 1.75);
        Prices.setMarketPrices(getResources().getString(R.string.Aluminum), 0.50);
        Prices.setMarketPrices(getResources().getString(R.string.Diamond), 66867353300.80);
        Prices.setMarketPrices(getResources().getString(R.string.Gold), 1259.23);
        Prices.setMarketPrices(getResources().getString(R.string.Uranium), 31.10);
        Prices.setMarketPrices(getResources().getString(R.string.Tungsten), 19.85);
        Prices.setMarketPrices(getResources().getString(R.string.Silver), 236.76);
        Prices.setMarketPrices(getResources().getString(R.string.Platinum), 1480.00);
        Prices.setMarketPrices(getResources().getString(R.string.Iron), 0.24);
        Prices.setMarketPrices(getResources().getString(R.string.Osmium), 5909.00);

        try {
            getData();
        }catch (NullPointerException e){e.printStackTrace();}

        CharSequence start = "" + Inventory.getMoney();
        TextView name = (TextView)findViewById(R.id.totalMoney);
        name.setText(start);

        Button sButton = (Button)findViewById(R.id.shipButton);
        sButton.setOnClickListener(onClickListener);

        Button pButton = (Button)findViewById(R.id.playerButton);
        pButton.setOnClickListener(onClickListener);

        Button mButton = (Button)findViewById(R.id.mineButton);
        mButton.setOnClickListener(onClickListener);

        Button shButton = (Button)findViewById(R.id.shopButton);
        shButton.setOnClickListener(onClickListener);

        ImageButton eButton = (ImageButton)findViewById(R.id.economicsButton);
        eButton.setOnClickListener(onClickListener);

        ImageButton uButton = (ImageButton)findViewById(R.id.universeButton);
        uButton.setOnClickListener(onClickListener);

        ImageButton seButton = (ImageButton)findViewById(R.id.settingsButton);
        seButton.setOnClickListener(onClickListener);
    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch(v.getId()){
                case R.id.shipButton:
                    ListFragmentView.setContent(R.string.shipTab);
                    Intent si = new Intent(MainActivity.this,FragmentView.class);
                    startActivity(si);
                    break;
                case R.id.playerButton:
                    ListFragmentView.setContent(R.string.playerTab);
                    Intent pi = new Intent(MainActivity.this, FragmentView.class);
                    startActivity(pi);
                    break;
                case R.id.mineButton:
                    ListFragmentView.setContent(R.string.mineTab);
                    Intent mi = new Intent(MainActivity.this, FragmentView.class);
                    startActivity(mi);
                    break;
                case R.id.shopButton:
                    break;
                case R.id.economicsButton:
                    ListFragmentView.setContent(R.string.economicsTab);
                    Intent ei = new Intent(MainActivity.this, EconomicsActivity.class);
                    startActivity(ei);
                    break;
                case R.id.universeButton:
                    break;
                case R.id.settingsButton:
                    break;
            }
        }
    };

    @Override
    protected void onResume(){
        super.onResume();
        updateUI();
    }

    @Override
    protected void onPause(){
        super.onPause();
        saveData();
    }

    private void updateUI(){
        TextView textView = (TextView)findViewById(R.id.totalMoney);
        String temp = Double.toString(Inventory.getMoney());
        textView.setText(temp);
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

        editor.apply();
    }

    public void getData(){
        SharedPreferences sp = this.getPreferences(Context.MODE_PRIVATE);

        Inventory.setMoney(Double.parseDouble(sp.getString("userMoney", Double.toString(Inventory.getMoney()))));

        Prices.setMarketPrices(getResources().getString(R.string.Copper), Double.parseDouble(sp.getString("pCopper",Double.toString(Prices.getMarketPrices(getResources().getString(R.string.Copper))))));
        Prices.setMarketPrices(getResources().getString(R.string.Aluminum), Double.parseDouble(sp.getString("pAluminum", Double.toString(Prices.getMarketPrices(getResources().getString(R.string.Aluminum))))));
        Prices.setMarketPrices(getResources().getString(R.string.Iron), Double.parseDouble(sp.getString("pIron", Double.toString(Prices.getMarketPrices(getResources().getString(R.string.Iron))))));
        Prices.setMarketPrices(getResources().getString(R.string.Silver), Double.parseDouble(sp.getString("pSilver", Double.toString(Prices.getMarketPrices(getResources().getString(R.string.Silver))))));
        Prices.setMarketPrices(getResources().getString(R.string.Tungsten), Double.parseDouble(sp.getString("pTungsten", Double.toString(Prices.getMarketPrices(getResources().getString(R.string.Tungsten))))));
        Prices.setMarketPrices(getResources().getString(R.string.Osmium), Double.parseDouble(sp.getString("pOsmium", Double.toString(Prices.getMarketPrices(getResources().getString(R.string.Osmium))))));
        Prices.setMarketPrices(getResources().getString(R.string.Platinum), Double.parseDouble(sp.getString("pPlatinum", Double.toString(Prices.getMarketPrices(getResources().getString(R.string.Platinum))))));
        Prices.setMarketPrices(getResources().getString(R.string.Gold), Double.parseDouble(sp.getString("pGold", Double.toString(Prices.getMarketPrices(getResources().getString(R.string.Gold))))));
        Prices.setMarketPrices(getResources().getString(R.string.Diamond), Double.parseDouble(sp.getString("pDiamond", Double.toString(Prices.getMarketPrices(getResources().getString(R.string.Diamond))))));
        Prices.setMarketPrices(getResources().getString(R.string.Uranium), Double.parseDouble(sp.getString("pUranium", Double.toString(Prices.getMarketPrices(getResources().getString(R.string.Uranium))))));

        Inventory.setResources(getResources().getString(R.string.Copper), Integer.parseInt(sp.getString("iCopper",Integer.toString(Inventory.getResourceAmount(getResources().getString(R.string.Copper))))));
        Inventory.setResources(getResources().getString(R.string.Aluminum), Integer.parseInt(sp.getString("iAluminum", Integer.toString(Inventory.getResourceAmount(getResources().getString(R.string.Aluminum))))));
        Inventory.setResources(getResources().getString(R.string.Iron), Integer.parseInt(sp.getString("iIron", Integer.toString(Inventory.getResourceAmount(getResources().getString(R.string.Iron))))));
        Inventory.setResources(getResources().getString(R.string.Silver), Integer.parseInt(sp.getString("iSilver", Integer.toString(Inventory.getResourceAmount(getResources().getString(R.string.Silver))))));
        Inventory.setResources(getResources().getString(R.string.Tungsten), Integer.parseInt(sp.getString("iTungsten", Integer.toString(Inventory.getResourceAmount(getResources().getString(R.string.Tungsten))))));
        Inventory.setResources(getResources().getString(R.string.Osmium), Integer.parseInt(sp.getString("iOsmium", Integer.toString(Inventory.getResourceAmount(getResources().getString(R.string.Osmium))))));
        Inventory.setResources(getResources().getString(R.string.Platinum), Integer.parseInt(sp.getString("iPlatinum", Integer.toString(Inventory.getResourceAmount(getResources().getString(R.string.Platinum))))));
        Inventory.setResources(getResources().getString(R.string.Gold), Integer.parseInt(sp.getString("iGold", Integer.toString(Inventory.getResourceAmount(getResources().getString(R.string.Gold))))));
        Inventory.setResources(getResources().getString(R.string.Diamond), Integer.parseInt(sp.getString("iDiamond", Integer.toString(Inventory.getResourceAmount(getResources().getString(R.string.Diamond))))));
        Inventory.setResources(getResources().getString(R.string.Uranium), Integer.parseInt(sp.getString("iUranium", Integer.toString(Inventory.getResourceAmount(getResources().getString(R.string.Uranium))))));
    }
}
