package com.example.isanroman.threeinone;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

/**
 * Created by Gamer-Isaiah on 10/17/2016.
 */

public class UniverseMap extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_universe_galaxy);

        ImageButton galaxyOneButton = (ImageButton)findViewById(R.id.galaxyOne);
        galaxyOneButton.setOnClickListener(onClickListener);

        ImageButton galaxyTwoButton = (ImageButton)findViewById(R.id.galaxyTwo);
        galaxyTwoButton.setOnClickListener(onClickListener);

        ImageButton galaxyThreeButton = (ImageButton)findViewById(R.id.galaxyThree);
        galaxyThreeButton.setOnClickListener(onClickListener);

        Button backButton = (Button)findViewById(R.id.umBackButton);
        backButton.setOnClickListener(onClickListener);
    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch(v.getId()){
                case R.id.galaxyOne:
                    break;
                case R.id.galaxyTwo:
                    break;
                case R.id.galaxyThree:
                    break;
                case R.id.umBackButton:
                    onBackPressed();
                    break;
            }
        }
    };
}
