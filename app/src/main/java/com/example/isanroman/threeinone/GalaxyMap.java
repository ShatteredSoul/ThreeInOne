package com.example.isanroman.threeinone;

import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Created by Gamer-Isaiah on 10/18/2016.
 */

public class GalaxyMap extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_universe_system);

        int id = UniverseMap.getGalaxy();
        String names[];

        if(id == R.id.galaxyOne)
            names = getResources().getStringArray(R.array.galaxyOneSolarSystems);
        else if(id == R.id.galaxyTwo)
            names = getResources().getStringArray(R.array.galaxyTwoSolarSystems);
        else
            names = getResources().getStringArray(R.array.galaxyThreeSolarSystems);



        TextView solarSystemOne = (TextView)findViewById(R.id.solarSystemOneName);
        TextView solarSystemTwo = (TextView)findViewById(R.id.solarSystemTwoName);
        TextView solarSystemThree = (TextView)findViewById(R.id.solarSystemThreeName);
        Button backButton = (Button)findViewById(R.id.gmBackButton);
        backButton.setOnClickListener(onClickListener);
        ImageButton systemOne = (ImageButton)findViewById(R.id.solarSystemOne);
        systemOne.setOnClickListener(onClickListener);
        ImageButton systemTwo = (ImageButton)findViewById(R.id.solarSystemTwo);
        systemTwo.setOnClickListener(onClickListener);
        ImageButton systemThree = (ImageButton)findViewById(R.id.solarSystemThree);
        systemThree.setOnClickListener(onClickListener);

        solarSystemOne.setText(names[0]);
        solarSystemTwo.setText(names[1]);
        solarSystemThree.setText(names[2]);
    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch(v.getId()){
                case R.id.gmBackButton:
                    break;
                case R.id.solarSystemOne:
                    break;
                case R.id.solarSystemTwo:
                    break;
                case R.id.solarSystemThree:
                    break;
            }
        }
    };
}
