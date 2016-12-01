package com.example.isanroman.threeinone.RPG;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import com.example.isanroman.threeinone.R;

/**
 * Created by isanroman on 11/29/2016.
 */

public class RPG extends AppCompatActivity {

    ImageView gameView;
    public static boolean running = false;
    public Player player;
    public Canvas canvas;
    public Paint paint;
    public int width, height;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        draw();
        init();

        setContentView(gameView);

        player.draw(canvas,paint,this.getResources());

        View.OnTouchListener onTouchListener = new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN)
                    return true;
                return false;
            }
        };
    }

    public void draw(){

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        width = dm.widthPixels;
        height = dm.heightPixels;

        Bitmap blankBitmap = Bitmap.createBitmap(width,height,Bitmap.Config.ARGB_8888);
        canvas = new Canvas(blankBitmap);

        gameView = new ImageView(this);
        gameView.setImageBitmap(blankBitmap);

        paint = new Paint();

        Bitmap backGround = BitmapFactory.decodeResource(this.getResources(), R.drawable.stars_background);
        canvas.drawBitmap(backGround,0,0,paint);
    }

    public void init(){
        player = new Player();
    }
}
