package com.example.isanroman.threeinone;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by isanroman on 10/20/2016.
 */

public class SolarMap extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_universe_solar);

        String name[];
        int id = GalaxyMap.getSolarSystem();
        if(R.id.solarSystemOne == id)
            name = getResources().getStringArray(R.array.galaxyOneSolarSystems);
        else if(R.id.solarSystemTwo == id)
            name = getResources().getStringArray(R.array.galaxyTwoSolarSystems);
        else
            name = getResources().getStringArray(R.array.galaxyThreeSolarSystems);

        TextView planetOneName = (TextView)findViewById(R.id.planetOneName);
        TextView planetTwoName = (TextView)findViewById(R.id.planetTwoName);
        TextView planetThreeName = (TextView)findViewById(R.id.planetThreeName);
        TextView planetFourName = (TextView)findViewById(R.id.planetFourName);
        TextView planetFiveName = (TextView)findViewById(R.id.planetFiveName);

        planetOneName.setText(name[0]);
        planetTwoName.setText(name[1]);
        planetThreeName.setText(name[2]);
        planetFourName.setText(name[3]);
        planetFiveName.setText(name[4]);
    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch(view.getId()){

            }
        }
    };

    @Override
    protected void onPause(){
        super.onPause();
        overridePendingTransition(0,0);
    }
}
