package com.example.isanroman.threeinone;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

/**
 * Created by Gamer-Isaiah on 10/17/2016.
 */

public class UniverseMap extends AppCompatActivity {

    public static int galaxySelected;
    private static int width, height;
    private static DisplayMetrics dm = new DisplayMetrics();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_universe_galaxy);

        final ImageButton galaxyOneButton = (ImageButton) findViewById(R.id.galaxyOne);
        galaxyOneButton.setOnClickListener(onClickListener);
        Animator rotationSetOne = (Animator) AnimatorInflater.loadAnimator(this, R.animator.circular_path);
        rotationSetOne.setTarget(galaxyOneButton);
        rotationSetOne.start();

        final ImageButton galaxyTwoButton = (ImageButton) findViewById(R.id.galaxyTwo);
        galaxyTwoButton.setOnClickListener(onClickListener);
        Animator rotationSetTwo = (Animator) AnimatorInflater.loadAnimator(this, R.animator.circular_path);
        rotationSetTwo.setTarget(galaxyTwoButton);
        rotationSetTwo.start();

        ImageButton galaxyThreeButton = (ImageButton) findViewById(R.id.galaxyThree);
        galaxyThreeButton.setOnClickListener(onClickListener);
        Animator rotationSetThree = (Animator) AnimatorInflater.loadAnimator(this, R.animator.circular_path);
        rotationSetThree.setTarget(galaxyThreeButton);
        rotationSetThree.start();

        Button backButton = (Button) findViewById(R.id.umBackButton);
        backButton.setOnClickListener(onClickListener);

        getWindowManager().getDefaultDisplay().getMetrics(dm);
        width = dm.widthPixels;
        height = dm.heightPixels;

        if (galaxyOneButton.getX() != (width - 50)) {
            double y = (-(50 - galaxyTwoButton.getY()) * Math.sqrt(1 - (Math.pow((galaxyOneButton.getX() + 1) - galaxyTwoButton.getX(), 2) / Math.pow(50 - galaxyTwoButton.getY(), 2)))) + galaxyTwoButton.getY();
            double x = galaxyOneButton.getX();
            galaxyOneButton.setX((float) x);
            galaxyOneButton.setY((float) y);
        }

       /* if(true) {
            this.findViewById(android.R.id.content).invalidate();
        }*/
       // getWindow().getDecorView().findViewById(android.R.id.content).invalidate();
    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch(v.getId()){
                case R.id.galaxyOne:
                    setGalaxySelected(R.id.galaxyOne);
                    Intent i = new Intent(UniverseMap.this, GalaxyMap.class);
                    i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(i);
                    break;
                case R.id.galaxyTwo:
                    setGalaxySelected(R.id.galaxyTwo);
                    Intent ii = new Intent(UniverseMap.this, GalaxyMap.class);
                    ii.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(ii);
                    break;
                case R.id.galaxyThree:
                    setGalaxySelected(R.id.galaxyThree);
                    Intent iii = new Intent(UniverseMap.this, GalaxyMap.class);
                    iii.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(iii);
                    break;
                case R.id.umBackButton:
                    onBackPressed();
                    break;
            }
        }
    };

    public static int getGalaxy(){
        return galaxySelected;
    }

    private void setGalaxySelected(int id){
        galaxySelected = id;
    }
}
