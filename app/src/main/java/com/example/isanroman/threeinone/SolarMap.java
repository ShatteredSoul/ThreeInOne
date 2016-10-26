package com.example.isanroman.threeinone;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Created by isanroman on 10/20/2016.
 */

public class SolarMap extends AppCompatActivity {

    private static int id;
    private static int systemId;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_universe_solar);

        String name[];
        int id = GalaxyMap.getSolarSystem();
        if(R.id.solarSystemOne == id) {
            name = getResources().getStringArray(R.array.galaxyOneSolarSystems);
            setSystemId(R.id.solarSystemOne);
        }
        else if(R.id.solarSystemTwo == id) {
            name = getResources().getStringArray(R.array.galaxyTwoSolarSystems);
            setSystemId(R.id.solarSystemTwo);
        }
        else {
            name = getResources().getStringArray(R.array.galaxyThreeSolarSystems);
            setSystemId(R.id.solarSystemThree);
        }

        TextView planetOneName = (TextView)findViewById(R.id.planetOneName);
        TextView planetTwoName = (TextView)findViewById(R.id.planetTwoName);
        TextView planetThreeName = (TextView)findViewById(R.id.planetThreeName);
        TextView planetFourName = (TextView)findViewById(R.id.planetFourName);
        TextView planetFiveName = (TextView)findViewById(R.id.planetFiveName);

        ImageButton planetOne = (ImageButton)findViewById(R.id.planetOne);
        ImageButton planetTwo = (ImageButton)findViewById(R.id.planetTwo);
        ImageButton planetThree = (ImageButton)findViewById(R.id.planetThree);
        ImageButton planetFour = (ImageButton)findViewById(R.id.planetFour);
        ImageButton planetFive = (ImageButton)findViewById(R.id.planetFive);

        planetOne.setOnClickListener(onClickListener);
        planetTwo.setOnClickListener(onClickListener);
        planetThree.setOnClickListener(onClickListener);
        planetFour.setOnClickListener(onClickListener);
        planetFive.setOnClickListener(onClickListener);

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
                case R.id.planetOne:
                    setPlanetId(R.id.planetOne);
                    break;
                case R.id.planetTwo:
                    setPlanetId(R.id.planetTwo);
                    break;
                case R.id.planetThree:
                    setPlanetId(R.id.planetThree);
                    break;
                case R.id.planetFour:
                    setPlanetId(R.id.planetFour);
                    break;
                case R.id.planetFive:
                    setPlanetId(R.id.planetFive);
                    break;
            }
        }
    };

    @Override
    protected void onPause(){
        super.onPause();
        overridePendingTransition(0,0);
    }

    private void setPlanetId(int i){
        id = i;
    }

    private void setSystemId(int i){
        systemId = i;
    }

    public static int getPlanetId(){
        return id;
    }

    public static int getSystemId(){
        return systemId;
    }
}
