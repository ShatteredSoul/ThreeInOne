package com.example.isanroman.threeinone;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by G4ame on 10/25/2016.
 */

public class PlanetMap extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_universe_planet);

        String info[] = getPlanetInfo();
    }

    public String[] getPlanetInfo(){
        int systemId = SolarMap.getSystemId();
        int planetId = SolarMap.getPlanetId();
        String temp[];

        if(R.id.solarSystemOne == systemId){
            if(R.id.planetOne == planetId)
                temp = getResources().getStringArray(R.array.systemOnePlanetOne);
            else if(R.id.planetTwo == planetId)
                temp = getResources().getStringArray(R.array.systemOnePlanetTwo);
            else if(R.id.planetThree == planetId)
                temp = getResources().getStringArray(R.array.systemOnePlanetThree);
            else if(R.id.planetFour == planetId)
                temp = getResources().getStringArray(R.array.systemOnePlanetFour);
            else
                temp = getResources().getStringArray(R.array.systemOnePlanetFive);
        }else if(R.id.solarSystemTwo == systemId){
            if(R.id.planetOne == planetId)
                temp = getResources().getStringArray(R.array.systemTwoPlanetOne);
            else if(R.id.planetTwo == planetId)
                temp = getResources().getStringArray(R.array.systemTwoPlanetTwo);
            else if(R.id.planetThree == planetId)
                temp = getResources().getStringArray(R.array.systemTwoPlanetThree);
            else if(R.id.planetFour == planetId)
                temp = getResources().getStringArray(R.array.systemTwoPlanetFour);
            else
                temp = getResources().getStringArray(R.array.systemTwoPlanetFive);
        }else{
            if(R.id.planetOne == planetId)
                temp = getResources().getStringArray(R.array.systemThreePlanetOne);
            else if(R.id.planetTwo == planetId)
                temp = getResources().getStringArray(R.array.systemThreePlanetTwo);
            else if(R.id.planetThree == planetId)
                temp = getResources().getStringArray(R.array.systemThreePlanetThree);
            else if(R.id.planetFour == planetId)
                temp = getResources().getStringArray(R.array.systemThreePlanetFour);
            else
                temp = getResources().getStringArray(R.array.systemThreePlanetFive);
        }

        return temp;
    }
}
