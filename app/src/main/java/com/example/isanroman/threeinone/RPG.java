package com.example.isanroman.threeinone;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class RPG extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rpg);

        Button fire = (Button)findViewById(R.id.fireButton);
        Button inventory = (Button)findViewById(R.id.inventoryButton);
        Button moveRight = (Button)findViewById(R.id.rightButton);
        Button moveLeft = (Button)findViewById(R.id.leftButton);
        Button moveUp = (Button)findViewById(R.id.topButton);
        Button moveDown = (Button)findViewById(R.id.downButton);

        fire.setOnClickListener(onClickListener);
        inventory.setOnClickListener(onClickListener);
        moveRight.setOnClickListener(onClickListener);
        moveLeft.setOnClickListener(onClickListener);
        moveUp.setOnClickListener(onClickListener);
        moveDown.setOnClickListener(onClickListener);
    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.fireButton:
                    break;
                case R.id.inventoryButton:
                    Intent ib = new Intent(RPG.this, RPG_Inventory.class);
                    startActivity(ib);
                    break;
                case R.id.rightButton:
                    break;
                case R.id.leftButton:
                    break;
                case R.id.topButton:
                    break;
                case R.id.downButton:
                    break;
            }
        }
    };
}