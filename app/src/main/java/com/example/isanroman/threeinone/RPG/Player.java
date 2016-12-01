package com.example.isanroman.threeinone.RPG;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

import com.example.isanroman.threeinone.R;

/**
 * Created by isanroman on 12/1/2016.
 */

public class Player {

    private int width = 50, height = 50;
    Bitmap player;

    public void draw(Canvas canvas, Paint paint, Resources resources){
        player = BitmapFactory.decodeResource(resources, R.drawable.economics_image);
        canvas.drawBitmap(player, width,height, paint);
    }

    public void movePlayer(Canvas canvas, Paint paint, Resources resources, float width, float height){

    }
}
