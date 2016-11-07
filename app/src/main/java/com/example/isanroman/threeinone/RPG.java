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

        Button inventory = (Button)findViewById(R.id.inventoryButton);
        inventory.setOnClickListener(onClickListener);

        
    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.inventoryButton:
                    Intent ib = new Intent(RPG.this, RPG_Inventory.class);
                    startActivity(ib);
                    break;
            }
        }
    };
}