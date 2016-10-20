package com.example.isanroman.threeinone;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by isanroman on 10/20/2016.
 */

public class SolarMap extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_universe_solar);
    }

    @Override
    protected void onPause(){
        super.onPause();
        overridePendingTransition(0,0);
    }
}
