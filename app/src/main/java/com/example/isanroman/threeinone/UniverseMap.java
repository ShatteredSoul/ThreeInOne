package com.example.isanroman.threeinone;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.content.Intent;
import android.graphics.Path;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageButton;

/**
 * Created by Gamer-Isaiah on 10/17/2016.
 */

public class UniverseMap extends AppCompatActivity {

    public static int galaxySelected;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_universe_galaxy);

        ImageButton galaxyOneButton = (ImageButton)findViewById(R.id.galaxyOne);
        galaxyOneButton.setOnClickListener(onClickListener);
        Animator rotationSetOne = (Animator) AnimatorInflater.loadAnimator(this, R.animator.circular_path);
        rotationSetOne.setTarget(galaxyOneButton);
        rotationSetOne.start();

        ImageButton galaxyTwoButton = (ImageButton)findViewById(R.id.galaxyTwo);
        galaxyTwoButton.setOnClickListener(onClickListener);
        Animator rotationSetTwo = (Animator)AnimatorInflater.loadAnimator(this, R.animator.circular_path);
        rotationSetTwo.setTarget(galaxyTwoButton);
        rotationSetTwo.start();

        ImageButton galaxyThreeButton = (ImageButton)findViewById(R.id.galaxyThree);
        galaxyThreeButton.setOnClickListener(onClickListener);
        Animator rotationSetThree = (Animator)AnimatorInflater.loadAnimator(this, R.animator.circular_path);
        rotationSetThree.setTarget(galaxyThreeButton);
        rotationSetThree.start();

        Button backButton = (Button)findViewById(R.id.umBackButton);
        backButton.setOnClickListener(onClickListener);
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
