package com.example.isanroman.threeinone.RPG;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RelativeLayout;

import com.example.isanroman.threeinone.R;

/**
 * Created by isanroman on 11/29/2016.
 */

public class RPG extends AppCompatActivity {

    RelativeLayout mRelativeLayout;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        mRelativeLayout = new RelativeLayout(this);

        Drawable backGround = getResources().getDrawable(R.drawable.stars_background);
        mRelativeLayout.setBackground(backGround);

        setContentView(mRelativeLayout);
    }
}
