package com.example.isanroman.threeinone;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;


public class MainActivity extends AppCompatActivity {

    SaveData saveData = new SaveData(MainActivity.this);

    private static boolean volume = false, settings = true;
    private View vv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LocaleHelper.onCreate(this, Locale.getDefault().toString());
        setContentView(R.layout.activity_main);

        setResources();

        try {
            saveData.getData();
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
                    Intent ui = new Intent(MainActivity.this, Universe.class);
                    startActivity(ui);
                    break;
                case R.id.settingsButton:
                    settings = true;
                    registerForContextMenu(v);
                    openContextMenu(v);
                    vv = v;
                    System.out.println("Clicked");
                    break;
            }
        }
    };

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){
        super.onCreateContextMenu(menu, v, menuInfo);

        if(settings) {
            getMenuInflater().inflate(R.menu.settings_menu, menu);
            System.out.println("Clicked");
        }
        else
            getMenuInflater().inflate(R.menu.language_menu, menu);
    }

    public boolean onContextItemSelected(MenuItem item){
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)item.getMenuInfo();
        if(settings) {
            switch (item.getItemId()) {
                case R.id.inGameVolume:
                    AudioManager volumeControl = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
                    if (volume) {
                        volumeControl.setStreamVolume(AudioManager.STREAM_MUSIC, 20, 0);
                        Toast.makeText(this, R.string.volumeDisabled, Toast.LENGTH_SHORT).show();
                    } else {
                        volumeControl.setStreamVolume(AudioManager.STREAM_MUSIC, 20, 100);
                        Toast.makeText(this, R.string.volumeEnabled, Toast.LENGTH_SHORT).show();
                    }
                    break;
                case R.id.changeGameLanguage:
                    closeContextMenu();
                    settings = false;
                    registerForContextMenu(vv);
                    openContextMenu(vv);
                    break;
            }
        }else{
            switch (item.getItemId()){
                case R.id.languageOne:
                    LocaleHelper.setLocale(this, "en");
                    updateUI();
                    break;
                case R.id.languageTwo:
                    LocaleHelper.setLocale(this, "ja");
                    updateUI();
                    break;
                case R.id.languageThree:
                    LocaleHelper.setLocale(this, "es");
                    updateUI();
                    break;
                case R.id.languageFour:
                    LocaleHelper.setLocale(this, "ch");
                    updateUI();
                    break;
            }
        }
        return true;
    }

    @Override
    protected void onResume(){
        super.onResume();
        updateUI();
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

    private void updateUI(){
        TextView textView = (TextView)findViewById(R.id.totalMoney);
        String temp = Double.toString(Inventory.getMoney());
        textView.setText(temp);
    }

    public void setResources(){

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

        Mines.setProduction(getResources().getString(R.string.Copper), 0);
        Mines.setProduction(getResources().getString(R.string.Aluminum), 0);
        Mines.setProduction(getResources().getString(R.string.Diamond), 0);
        Mines.setProduction(getResources().getString(R.string.Gold), 0);
        Mines.setProduction(getResources().getString(R.string.Uranium), 0);
        Mines.setProduction(getResources().getString(R.string.Tungsten), 0);
        Mines.setProduction(getResources().getString(R.string.Silver), 0);
        Mines.setProduction(getResources().getString(R.string.Platinum), 0);
        Mines.setProduction(getResources().getString(R.string.Iron), 0);
        Mines.setProduction(getResources().getString(R.string.Osmium), 0);

        Mines.setCost(getResources().getString(R.string.Copper), 1400.00);
        Mines.setCost(getResources().getString(R.string.Aluminum), 400.00);
        Mines.setCost(getResources().getString(R.string.Diamond), 53493882640000.00);
        Mines.setCost(getResources().getString(R.string.Gold), 1007384.00);
        Mines.setCost(getResources().getString(R.string.Uranium), 24880.00);
        Mines.setCost(getResources().getString(R.string.Tungsten), 15880.00);
        Mines.setCost(getResources().getString(R.string.Silver), 189408.00);
        Mines.setCost(getResources().getString(R.string.Platinum), 1184000.00);
        Mines.setCost(getResources().getString(R.string.Iron), 200.00);
        Mines.setCost(getResources().getString(R.string.Osmium), 4727200.00);

        Mines.setProductionLevel(getResources().getString(R.string.Copper), 0);
        Mines.setProductionLevel(getResources().getString(R.string.Aluminum), 0);
        Mines.setProductionLevel(getResources().getString(R.string.Diamond), 0);
        Mines.setProductionLevel(getResources().getString(R.string.Gold), 0);
        Mines.setProductionLevel(getResources().getString(R.string.Uranium), 0);
        Mines.setProductionLevel(getResources().getString(R.string.Tungsten), 0);
        Mines.setProductionLevel(getResources().getString(R.string.Silver), 0);
        Mines.setProductionLevel(getResources().getString(R.string.Platinum), 0);
        Mines.setProductionLevel(getResources().getString(R.string.Iron), 0);
        Mines.setProductionLevel(getResources().getString(R.string.Osmium), 0);
    }
}
