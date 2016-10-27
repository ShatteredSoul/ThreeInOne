package com.example.isanroman.threeinone;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by isanroman on 10/26/2016.
 */

public class Universe extends AppCompatActivity {

    String galaxyNames[] = new String[3];
    String solarSystemOneNames[];
    String solarSystemTwoNames[];
    String solarSystemThreeNames[];
    String systemOnePlanetNames[];
    String systemTwoPlanetNames[];
    String systemThreePlanetNames[];
    String planetInformation[];

    boolean galaxy = false, solar = false, planet = false;
    boolean galaxyOne = false, galaxyTwo = false, galaxyThree = false;
    boolean solarOne = false, solarTwo = false, solarThree = false;
    boolean planetOne = false, planetTwo = false, planetThree = false, planetFour = false, planetFive = false;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_universe);

        galaxyNames[0] = getResources().getString(R.string.galaxyOneName);
        galaxyNames[1] = getResources().getString(R.string.galaxyTwoName);
        galaxyNames[2] = getResources().getString(R.string.galaxyThreeName);

        solarSystemOneNames = getResources().getStringArray(R.array.galaxyOneSolarSystems);
        solarSystemTwoNames = getResources().getStringArray(R.array.galaxyTwoSolarSystems);
        solarSystemThreeNames = getResources().getStringArray(R.array.galaxyThreeSolarSystems);
        systemOnePlanetNames = getResources().getStringArray(R.array.solarSystemOnePlanets);
        systemTwoPlanetNames = getResources().getStringArray(R.array.solarSystemTwoPlanets);
        systemThreePlanetNames = getResources().getStringArray(R.array.solarSystemThreePlanets);

        ImageButton galaxyOne = (ImageButton)findViewById(R.id.galaxyOne);
        ImageButton galaxyTwo = (ImageButton)findViewById(R.id.galaxyTwo);
        ImageButton galaxyThree = (ImageButton)findViewById(R.id.galaxyThree);
        ImageButton solarSystemOne = (ImageButton)findViewById(R.id.solarSystemOne);
        ImageButton solarSystemTwo = (ImageButton)findViewById(R.id.solarSystemTwo);
        ImageButton solarSystemThree = (ImageButton)findViewById(R.id.solarSystemThree);
        ImageButton planetOne = (ImageButton)findViewById(R.id.planetOne);
        ImageButton planetTwo = (ImageButton)findViewById(R.id.planetTwo);
        ImageButton planetThree = (ImageButton)findViewById(R.id.planetThree);
        ImageButton planetFour = (ImageButton)findViewById(R.id.planetFour);
        ImageButton planetFive = (ImageButton)findViewById(R.id.planetFive);

        galaxyOne.setOnClickListener(onClickListener);
        galaxyTwo.setOnClickListener(onClickListener);
        galaxyThree.setOnClickListener(onClickListener);
        solarSystemOne.setOnClickListener(onClickListener);
        solarSystemTwo.setOnClickListener(onClickListener);
        solarSystemThree.setOnClickListener(onClickListener);
        planetOne.setOnClickListener(onClickListener);
        planetTwo.setOnClickListener(onClickListener);
        planetThree.setOnClickListener(onClickListener);
        planetFour.setOnClickListener(onClickListener);
        planetFive.setOnClickListener(onClickListener);

        solarSystemOne.setVisibility(View.INVISIBLE);
        solarSystemTwo.setVisibility(View.INVISIBLE);
        solarSystemThree.setVisibility(View.INVISIBLE);
        planetOne.setVisibility(View.INVISIBLE);
        planetTwo.setVisibility(View.INVISIBLE);
        planetThree.setVisibility(View.INVISIBLE);
        planetFour.setVisibility(View.INVISIBLE);
        planetFive.setVisibility(View.INVISIBLE);

        TextView galaxyOneName = (TextView)findViewById(R.id.galaxyOneName);
        TextView galaxyTwoName = (TextView)findViewById(R.id.galaxyTwoName);
        TextView galaxyThreeName = (TextView)findViewById(R.id.galaxyThreeName);
        TextView solarSystemOneName = (TextView)findViewById(R.id.solarSystemOneName);
        TextView solarSystemTwoName = (TextView)findViewById(R.id.solarSystemTwoName);
        TextView solarSystemThreeName = (TextView)findViewById(R.id.solarSystemThreeName);
        TextView planetOneName = (TextView)findViewById(R.id.planetOneName);
        TextView planetTwoName = (TextView)findViewById(R.id.planetTwoName);
        TextView planetThreeName = (TextView)findViewById(R.id.planetThreeName);
        TextView planetFourName = (TextView)findViewById(R.id.planetFourName);
        TextView planetFiveName = (TextView)findViewById(R.id.planetFiveName);
        TextView planetName = (TextView)findViewById(R.id.planetName);
        TextView planetLevelRange = (TextView)findViewById(R.id.planetLevelRange);
        TextView galaxyName = (TextView)findViewById(R.id.galaxyName);
        TextView solarName = (TextView)findViewById(R.id.solarSystemName);

        solarSystemOneName.setVisibility(View.INVISIBLE);
        solarSystemTwoName.setVisibility(View.INVISIBLE);
        solarSystemThreeName.setVisibility(View.INVISIBLE);
        planetOneName.setVisibility(View.INVISIBLE);
        planetTwoName.setVisibility(View.INVISIBLE);
        planetThreeName.setVisibility(View.INVISIBLE);
        planetFourName.setVisibility(View.INVISIBLE);
        planetFiveName.setVisibility(View.INVISIBLE);
        planetName.setVisibility(View.INVISIBLE);
        planetLevelRange.setVisibility(View.INVISIBLE);
        galaxyName.setVisibility(View.INVISIBLE);
        solarName.setVisibility(View.INVISIBLE);

        ImageView planetImage = (ImageView)findViewById(R.id.planetImage);
        planetImage.setVisibility(View.INVISIBLE);

        galaxyOneName.setText(galaxyNames[0]);
        galaxyTwoName.setText(galaxyNames[1]);
        galaxyThreeName.setText(galaxyNames[2]);

        Button backButton = (Button)findViewById(R.id.umBackButton);
        Button planetSelect = (Button)findViewById(R.id.selectPlanet);

        backButton.setOnClickListener(onClickListener);
        planetSelect.setOnClickListener(onClickListener);

        backButton.setVisibility(View.VISIBLE);
        planetSelect.setVisibility(View.INVISIBLE);
    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.galaxyOne:
                    galaxy = true;
                    galaxyOne = true;
                    updateUI();
                    break;
                case R.id.galaxyTwo:
                    galaxy = true;
                    galaxyTwo = true;
                    updateUI();
                    break;
                case R.id.galaxyThree:
                    galaxy = true;
                    galaxyTwo = true;
                    updateUI();
                    break;
                case R.id.solarSystemOne:
                    solar = true;
                    solarOne = true;
                    updateUI();
                    break;
                case R.id.solarSystemTwo:
                    solar = true;
                    solarTwo = true;
                    updateUI();
                    break;
                case R.id.solarSystemThree:
                    solar = true;
                    solarThree = true;
                    updateUI();
                    break;
                case R.id.planetOne:
                    planet = true;
                    planetOne = true;
                    updateUI();
                    break;
                case R.id.planetTwo:
                    planet = true;
                    planetTwo = true;
                    updateUI();
                    break;
                case R.id.planetThree:
                    planet = true;
                    planetThree = true;
                    updateUI();
                    break;
                case R.id.planetFour:
                    planet = true;
                    planetFour = true;
                    updateUI();
                    break;
                case R.id.planetFive:
                    planet = true;
                    planetFive = true;
                    updateUI();
                    break;
                case R.id.umBackButton:
                    break;
                case R.id.selectPlanet:
                    break;
            }
        }
    };

    public void updateUI(){

        if (galaxy){
            TextView systemOne = (TextView)findViewById(R.id.solarSystemOneName);
            TextView systemTwo = (TextView)findViewById(R.id.solarSystemTwoName);
            TextView systemThree = (TextView)findViewById(R.id.solarSystemThreeName);

            systemOne.setVisibility(View.VISIBLE);
            systemTwo.setVisibility(View.VISIBLE);
            systemThree.setVisibility(View.VISIBLE);

            if(galaxyOne){
                systemOne.setText(solarSystemOneNames[0]);
                systemTwo.setText(solarSystemOneNames[1]);
                systemThree.setText(solarSystemOneNames[2]);
            }else if(galaxyTwo){
                systemOne.setText(solarSystemTwoNames[0]);
                systemTwo.setText(solarSystemTwoNames[1]);
                systemThree.setText(solarSystemTwoNames[2]);
            }else{
                systemOne.setText(solarSystemThreeNames[0]);
                systemTwo.setText(solarSystemThreeNames[1]);
                systemThree.setText(solarSystemThreeNames[2]);
            }

            ImageButton galaxyOne = (ImageButton)findViewById(R.id.galaxyOne);
            ImageButton galaxyTwo = (ImageButton)findViewById(R.id.galaxyTwo);
            ImageButton galaxyThree = (ImageButton)findViewById(R.id.galaxyThree);

            galaxyOne.setVisibility(View.INVISIBLE);
            galaxyTwo.setVisibility(View.INVISIBLE);
            galaxyThree.setVisibility(View.INVISIBLE);

            TextView galaxyOneName = (TextView)findViewById(R.id.galaxyOneName);
            TextView galaxyTwoName = (TextView)findViewById(R.id.galaxyTwoName);
            TextView galaxyThreeName = (TextView)findViewById(R.id.galaxyThreeName);

            galaxyOneName.setVisibility(View.INVISIBLE);
            galaxyTwoName.setVisibility(View.INVISIBLE);
            galaxyThreeName.setVisibility(View.INVISIBLE);

            ImageButton solarOne = (ImageButton)findViewById(R.id.solarSystemOne);
            ImageButton solarTwo = (ImageButton)findViewById(R.id.solarSystemTwo);
            ImageButton solarThree = (ImageButton)findViewById(R.id.solarSystemThree);

            solarOne.setVisibility(View.VISIBLE);
            solarTwo.setVisibility(View.VISIBLE);
            solarThree.setVisibility(View.VISIBLE);
        }
        else if(solar){
            TextView planetOneName = (TextView)findViewById(R.id.planetOneName);
            TextView planetTwoName = (TextView)findViewById(R.id.planetTwoName);
            TextView planetThreeName = (TextView)findViewById(R.id.planetThreeName);
            TextView planetFourName = (TextView)findViewById(R.id.planetFourName);
            TextView planetFiveName = (TextView)findViewById(R.id.planetFiveName);

            planetOneName.setVisibility(View.VISIBLE);
            planetTwoName.setVisibility(View.VISIBLE);
            planetThreeName.setVisibility(View.VISIBLE);
            planetFourName.setVisibility(View.VISIBLE);
            planetFiveName.setVisibility(View.VISIBLE);

            if(solarOne){
                planetOneName.setText(systemOnePlanetNames[0]);
                planetTwoName.setText(systemOnePlanetNames[1]);
                planetThreeName.setText(systemOnePlanetNames[2]);
                planetFourName.setText(systemOnePlanetNames[3]);
                planetFiveName.setText(systemOnePlanetNames[4]);
            }else if(solarTwo){
                planetOneName.setText(systemTwoPlanetNames[0]);
                planetTwoName.setText(systemTwoPlanetNames[1]);
                planetThreeName.setText(systemTwoPlanetNames[2]);
                planetFourName.setText(systemTwoPlanetNames[3]);
                planetFiveName.setText(systemTwoPlanetNames[4]);
            }else{
                planetOneName.setText(systemThreePlanetNames[0]);
                planetTwoName.setText(systemThreePlanetNames[1]);
                planetThreeName.setText(systemThreePlanetNames[2]);
                planetFourName.setText(systemThreePlanetNames[3]);
                planetFiveName.setText(systemThreePlanetNames[4]);
            }

            ImageButton solarOne = (ImageButton)findViewById(R.id.solarSystemOne);
            ImageButton solarTwo = (ImageButton)findViewById(R.id.solarSystemTwo);
            ImageButton solarThree = (ImageButton)findViewById(R.id.solarSystemThree);

            solarOne.setVisibility(View.INVISIBLE);
            solarTwo.setVisibility(View.INVISIBLE);
            solarThree.setVisibility(View.INVISIBLE);

            TextView solarOneName = (TextView)findViewById(R.id.solarSystemOneName);
            TextView solarTwoName = (TextView)findViewById(R.id.solarSystemTwoName);
            TextView solarThreeName = (TextView)findViewById(R.id.solarSystemThreeName);

            solarOneName.setVisibility(View.INVISIBLE);
            solarTwoName.setVisibility(View.INVISIBLE);
            solarThreeName.setVisibility(View.INVISIBLE);

            ImageButton planetOne = (ImageButton)findViewById(R.id.planetOne);
            ImageButton planetTwo = (ImageButton)findViewById(R.id.planetTwo);
            ImageButton planetThree = (ImageButton)findViewById(R.id.planetThree);
            ImageButton planetFour = (ImageButton)findViewById(R.id.planetFour);
            ImageButton planetFive = (ImageButton)findViewById(R.id.planetFive);

            planetOne.setVisibility(View.VISIBLE);
            planetTwo.setVisibility(View.VISIBLE);
            planetThree.setVisibility(View.VISIBLE);
            planetFour.setVisibility(View.VISIBLE);
            planetFive.setVisibility(View.VISIBLE);
        }
        else if(planet){

            TextView planetName = (TextView)findViewById(R.id.planetName);
            TextView planetLevelRange = (TextView)findViewById(R.id.planetLevelRange);
            TextView galaxyName = (TextView)findViewById(R.id.galaxyName);
            TextView solarName = (TextView)findViewById(R.id.solarSystemName);

            planetName.setVisibility(View.VISIBLE);
            planetLevelRange.setVisibility(View.VISIBLE);
            galaxyName.setVisibility(View.VISIBLE);
            solarName.setVisibility(View.VISIBLE);

            ImageView planetImage = (ImageView)findViewById(R.id.planetImage);
            planetImage.setVisibility(View.VISIBLE);

            String temp[];

            if(galaxyOne){

                if(solarOne){

                    if(planetOne){
                        temp = getResources().getStringArray(R.array.galaxyOneSystemOnePlanetOne);
                        planetName.setText(temp[0]);
                        planetLevelRange.setText(temp[1]);
                        galaxyName.setText(temp[2]);
                        solarName.setText(temp[3]);
                    }else if(planetTwo){
                        temp = getResources().getStringArray(R.array.galaxyOneSystemOnePlanetTwo);
                        planetName.setText(temp[0]);
                        planetLevelRange.setText(temp[1]);
                        galaxyName.setText(temp[2]);
                        solarName.setText(temp[3]);
                    }else if(planetThree){
                        temp = getResources().getStringArray(R.array.galaxyOneSystemOnePlanetThree);
                        planetName.setText(temp[0]);
                        planetLevelRange.setText(temp[1]);
                        galaxyName.setText(temp[2]);
                        solarName.setText(temp[3]);
                    }else if(planetFour){
                        temp = getResources().getStringArray(R.array.galaxyOneSystemOnePlanetFour);
                        planetName.setText(temp[0]);
                        planetLevelRange.setText(temp[1]);
                        galaxyName.setText(temp[2]);
                        solarName.setText(temp[3]);
                    }else{
                        temp = getResources().getStringArray(R.array.galaxyOneSystemOnePlanetFive);
                        planetName.setText(temp[0]);
                        planetLevelRange.setText(temp[1]);
                        galaxyName.setText(temp[2]);
                        solarName.setText(temp[3]);
                    }

                }else if(solarTwo){

                    if(planetOne){
                        temp = getResources().getStringArray(R.array.galaxyOneSystemTwoPlanetOne);
                        planetName.setText(temp[0]);
                        planetLevelRange.setText(temp[1]);
                        galaxyName.setText(temp[2]);
                        solarName.setText(temp[3]);
                    }else if(planetTwo){
                        temp = getResources().getStringArray(R.array.galaxyOneSystemTwoPlanetTwo);
                        planetName.setText(temp[0]);
                        planetLevelRange.setText(temp[1]);
                        galaxyName.setText(temp[2]);
                        solarName.setText(temp[3]);
                    }else if(planetThree){
                        temp = getResources().getStringArray(R.array.galaxyOneSystemTwoPlanetThree);
                        planetName.setText(temp[0]);
                        planetLevelRange.setText(temp[1]);
                        galaxyName.setText(temp[2]);
                        solarName.setText(temp[3]);
                    }else if(planetFour){
                        temp = getResources().getStringArray(R.array.galaxyOneSystemTwoPlanetFour);
                        planetName.setText(temp[0]);
                        planetLevelRange.setText(temp[1]);
                        galaxyName.setText(temp[2]);
                        solarName.setText(temp[3]);
                    }else{
                        temp = getResources().getStringArray(R.array.galaxyOneSystemTwoPlanetFive);
                        planetName.setText(temp[0]);
                        planetLevelRange.setText(temp[1]);
                        galaxyName.setText(temp[2]);
                        solarName.setText(temp[3]);
                    }

                }else{

                    if(planetOne){
                        temp = getResources().getStringArray(R.array.galaxyOneSystemThreePlanetOne);
                        planetName.setText(temp[0]);
                        planetLevelRange.setText(temp[1]);
                        galaxyName.setText(temp[2]);
                        solarName.setText(temp[3]);
                    }else if(planetTwo){
                        temp = getResources().getStringArray(R.array.galaxyOneSystemThreePlanetTwo);
                        planetName.setText(temp[0]);
                        planetLevelRange.setText(temp[1]);
                        galaxyName.setText(temp[2]);
                        solarName.setText(temp[3]);
                    }else if(planetThree){
                        temp = getResources().getStringArray(R.array.galaxyOneSystemThreePlanetThree);
                        planetName.setText(temp[0]);
                        planetLevelRange.setText(temp[1]);
                        galaxyName.setText(temp[2]);
                        solarName.setText(temp[3]);
                    }else if(planetFour){
                        temp = getResources().getStringArray(R.array.galaxyOneSystemThreePlanetFour);
                        planetName.setText(temp[0]);
                        planetLevelRange.setText(temp[1]);
                        galaxyName.setText(temp[2]);
                        solarName.setText(temp[3]);
                    }else{
                        temp = getResources().getStringArray(R.array.galaxyOneSystemThreePlanetFive);
                        planetName.setText(temp[0]);
                        planetLevelRange.setText(temp[1]);
                        galaxyName.setText(temp[2]);
                        solarName.setText(temp[3]);
                    }

                }

            }else if(galaxyTwo){

                if(solarOne){

                    if(planetOne){
                        temp = getResources().getStringArray(R.array.galaxyTwoSystemOnePlanetOne);
                        planetName.setText(temp[0]);
                        planetLevelRange.setText(temp[1]);
                        galaxyName.setText(temp[2]);
                        solarName.setText(temp[3]);
                    }else if(planetTwo){
                        temp = getResources().getStringArray(R.array.galaxyTwoSystemOnePlanetTwo);
                        planetName.setText(temp[0]);
                        planetLevelRange.setText(temp[1]);
                        galaxyName.setText(temp[2]);
                        solarName.setText(temp[3]);
                    }else if(planetThree){
                        temp = getResources().getStringArray(R.array.galaxyTwoSystemOnePlanetThree);
                        planetName.setText(temp[0]);
                        planetLevelRange.setText(temp[1]);
                        galaxyName.setText(temp[2]);
                        solarName.setText(temp[3]);
                    }else if(planetFour){
                        temp = getResources().getStringArray(R.array.galaxyTwoSystemOnePlanetFour);
                        planetName.setText(temp[0]);
                        planetLevelRange.setText(temp[1]);
                        galaxyName.setText(temp[2]);
                        solarName.setText(temp[3]);
                    }else{
                        temp = getResources().getStringArray(R.array.galaxyTwoSystemOnePlanetFive);
                        planetName.setText(temp[0]);
                        planetLevelRange.setText(temp[1]);
                        galaxyName.setText(temp[2]);
                        solarName.setText(temp[3]);
                    }

                }else if(solarTwo){

                    if(planetOne){
                        temp = getResources().getStringArray(R.array.galaxyTwoSystemTwoPlanetOne);
                        planetName.setText(temp[0]);
                        planetLevelRange.setText(temp[1]);
                        galaxyName.setText(temp[2]);
                        solarName.setText(temp[3]);
                    }else if(planetTwo){
                        temp = getResources().getStringArray(R.array.galaxyTwoSystemTwoPlanetTwo);
                        planetName.setText(temp[0]);
                        planetLevelRange.setText(temp[1]);
                        galaxyName.setText(temp[2]);
                        solarName.setText(temp[3]);
                    }else if(planetThree){
                        temp = getResources().getStringArray(R.array.galaxyTwoSystemTwoPlanetThree);
                        planetName.setText(temp[0]);
                        planetLevelRange.setText(temp[1]);
                        galaxyName.setText(temp[2]);
                        solarName.setText(temp[3]);
                    }else if(planetFour){
                        temp = getResources().getStringArray(R.array.galaxyTwoSystemTwoPlanetFour);
                        planetName.setText(temp[0]);
                        planetLevelRange.setText(temp[1]);
                        galaxyName.setText(temp[2]);
                        solarName.setText(temp[3]);
                    }else{
                        temp = getResources().getStringArray(R.array.galaxyTwoSystemTwoPlanetFive);
                        planetName.setText(temp[0]);
                        planetLevelRange.setText(temp[1]);
                        galaxyName.setText(temp[2]);
                        solarName.setText(temp[3]);
                    }

                }else{

                    if(planetOne){
                        temp = getResources().getStringArray(R.array.galaxyTwoSystemThreePlanetOne);
                        planetName.setText(temp[0]);
                        planetLevelRange.setText(temp[1]);
                        galaxyName.setText(temp[2]);
                        solarName.setText(temp[3]);
                    }else if(planetTwo){
                        temp = getResources().getStringArray(R.array.galaxyTwoSystemThreePlanetTwo);
                        planetName.setText(temp[0]);
                        planetLevelRange.setText(temp[1]);
                        galaxyName.setText(temp[2]);
                        solarName.setText(temp[3]);
                    }else if(planetThree){
                        temp = getResources().getStringArray(R.array.galaxyTwoSystemThreePlanetThree);
                        planetName.setText(temp[0]);
                        planetLevelRange.setText(temp[1]);
                        galaxyName.setText(temp[2]);
                        solarName.setText(temp[3]);
                    }else if(planetFour){
                        temp = getResources().getStringArray(R.array.galaxyTwoSystemThreePlanetFour);
                        planetName.setText(temp[0]);
                        planetLevelRange.setText(temp[1]);
                        galaxyName.setText(temp[2]);
                        solarName.setText(temp[3]);
                    }else{
                        temp = getResources().getStringArray(R.array.galaxyTwoSystemThreePlanetFive);
                        planetName.setText(temp[0]);
                        planetLevelRange.setText(temp[1]);
                        galaxyName.setText(temp[2]);
                        solarName.setText(temp[3]);
                    }

                }

            }else{

                if(solarOne){

                    if(planetOne){
                        temp = getResources().getStringArray(R.array.galaxyThreeSystemOnePlanetOne);
                        planetName.setText(temp[0]);
                        planetLevelRange.setText(temp[1]);
                        galaxyName.setText(temp[2]);
                        solarName.setText(temp[3]);
                    }else if(planetTwo){
                        temp = getResources().getStringArray(R.array.galaxyThreeSystemOnePlanetTwo);
                        planetName.setText(temp[0]);
                        planetLevelRange.setText(temp[1]);
                        galaxyName.setText(temp[2]);
                        solarName.setText(temp[3]);
                    }else if(planetThree){
                        temp = getResources().getStringArray(R.array.galaxyThreeSystemOnePlanetThree);
                        planetName.setText(temp[0]);
                        planetLevelRange.setText(temp[1]);
                        galaxyName.setText(temp[2]);
                        solarName.setText(temp[3]);
                    }else if(planetFour){
                        temp = getResources().getStringArray(R.array.galaxyThreeSystemOnePlanetFour);
                        planetName.setText(temp[0]);
                        planetLevelRange.setText(temp[1]);
                        galaxyName.setText(temp[2]);
                        solarName.setText(temp[3]);
                    }else{
                        temp = getResources().getStringArray(R.array.galaxyThreeSystemOnePlanetFive);
                        planetName.setText(temp[0]);
                        planetLevelRange.setText(temp[1]);
                        galaxyName.setText(temp[2]);
                        solarName.setText(temp[3]);
                    }

                }else if(solarTwo){

                    if(planetOne){
                        temp = getResources().getStringArray(R.array.galaxyThreeSystemTwoPlanetOne);
                        planetName.setText(temp[0]);
                        planetLevelRange.setText(temp[1]);
                        galaxyName.setText(temp[2]);
                        solarName.setText(temp[3]);
                    }else if(planetTwo){
                        temp = getResources().getStringArray(R.array.galaxyThreeSystemTwoPlanetTwo);
                        planetName.setText(temp[0]);
                        planetLevelRange.setText(temp[1]);
                        galaxyName.setText(temp[2]);
                        solarName.setText(temp[3]);
                    }else if(planetThree){
                        temp = getResources().getStringArray(R.array.galaxyThreeSystemTwoPlanetThree);
                        planetName.setText(temp[0]);
                        planetLevelRange.setText(temp[1]);
                        galaxyName.setText(temp[2]);
                        solarName.setText(temp[3]);
                    }else if(planetFour){
                        temp = getResources().getStringArray(R.array.galaxyThreeSystemTwoPlanetFour);
                        planetName.setText(temp[0]);
                        planetLevelRange.setText(temp[1]);
                        galaxyName.setText(temp[2]);
                        solarName.setText(temp[3]);
                    }else{
                        temp = getResources().getStringArray(R.array.galaxyThreeSystemTwoPlanetFive);
                        planetName.setText(temp[0]);
                        planetLevelRange.setText(temp[1]);
                        galaxyName.setText(temp[2]);
                        solarName.setText(temp[3]);
                    }

                }else{

                    if(planetOne){
                        temp = getResources().getStringArray(R.array.galaxyThreeSystemThreePlanetOne);
                        planetName.setText(temp[0]);
                        planetLevelRange.setText(temp[1]);
                        galaxyName.setText(temp[2]);
                        solarName.setText(temp[3]);
                    }else if(planetTwo){
                        temp = getResources().getStringArray(R.array.galaxyThreeSystemThreePlanetTwo);
                        planetName.setText(temp[0]);
                        planetLevelRange.setText(temp[1]);
                        galaxyName.setText(temp[2]);
                        solarName.setText(temp[3]);
                    }else if(planetThree){
                        temp = getResources().getStringArray(R.array.galaxyThreeSystemThreePlanetThree);
                        planetName.setText(temp[0]);
                        planetLevelRange.setText(temp[1]);
                        galaxyName.setText(temp[2]);
                        solarName.setText(temp[3]);
                    }else if(planetFour){
                        temp = getResources().getStringArray(R.array.galaxyThreeSystemThreePlanetFour);
                        planetName.setText(temp[0]);
                        planetLevelRange.setText(temp[1]);
                        galaxyName.setText(temp[2]);
                        solarName.setText(temp[3]);
                    }else{
                        temp = getResources().getStringArray(R.array.galaxyThreeSystemThreePlanetFive);
                        planetName.setText(temp[0]);
                        planetLevelRange.setText(temp[1]);
                        galaxyName.setText(temp[2]);
                        solarName.setText(temp[3]);
                    }
                }

            }

            ImageButton planetOne = (ImageButton)findViewById(R.id.planetOne);
            ImageButton planetTwo = (ImageButton)findViewById(R.id.planetTwo);
            ImageButton planetThree = (ImageButton)findViewById(R.id.planetThree);
            ImageButton planetFour = (ImageButton)findViewById(R.id.planetFour);
            ImageButton planetFive = (ImageButton)findViewById(R.id.planetFive);

            TextView planetOneName = (TextView)findViewById(R.id.planetOneName);
            TextView planetTwoName = (TextView)findViewById(R.id.planetTwoName);
            TextView planetThreeName = (TextView)findViewById(R.id.planetThreeName);
            TextView planetFourName = (TextView)findViewById(R.id.planetFourName);
            TextView planetFiveName = (TextView)findViewById(R.id.planetFiveName);

            planetOne.setVisibility(View.INVISIBLE);
            planetTwo.setVisibility(View.INVISIBLE);
            planetThree.setVisibility(View.INVISIBLE);
            planetFour.setVisibility(View.INVISIBLE);
            planetFive.setVisibility(View.INVISIBLE);

            planetOneName.setVisibility(View.INVISIBLE);
            planetTwoName.setVisibility(View.INVISIBLE);
            planetThreeName.setVisibility(View.INVISIBLE);
            planetFourName.setVisibility(View.INVISIBLE);
            planetFiveName.setVisibility(View.INVISIBLE);

            Button selectPlanet = (Button)findViewById(R.id.selectPlanet);
            selectPlanet.setVisibility(View.VISIBLE);

        }

    }
}
