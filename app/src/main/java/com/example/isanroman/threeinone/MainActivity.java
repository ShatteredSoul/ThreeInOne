package com.example.isanroman.threeinone;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Inventory userInventory = new Inventory();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CharSequence start = "Money: " + Currency.getTotalCurrency();
        TextView name = (TextView)findViewById(R.id.totalMoney);
        name.setText(start);

        Button sButton = (Button)findViewById(R.id.shipButton);
        sButton.setOnClickListener(onClickListener);

        Button pButton = (Button)findViewById(R.id.playerButton);
        pButton.setOnClickListener(onClickListener);

        Button mButton = (Button)findViewById(R.id.mineButton);
        mButton.setOnClickListener(onClickListener);

        Button shButton = (Button)findViewById(R.id.shopButton);
        shButton.setOnClickListener(onClickListener);

        ImageButton eButton = (ImageButton)findViewById(R.id.economicsButton);
        eButton.setOnClickListener(onClickListener);

        ImageButton uButton = (ImageButton)findViewById(R.id.universeButton);
        uButton.setOnClickListener(onClickListener);

        ImageButton seButton = (ImageButton)findViewById(R.id.settingsButton);
        seButton.setOnClickListener(onClickListener);
    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch(v.getId()){
                case R.id.shipButton:
                    ListFragmentView.setContent(R.string.shipTab);
                    Intent si = new Intent(MainActivity.this,FragmentView.class);
                    startActivity(si);
                    break;
                case R.id.playerButton:
                    ListFragmentView.setContent(R.string.playerTab);
                    Intent pi = new Intent(MainActivity.this, FragmentView.class);
                    startActivity(pi);
                    break;
                case R.id.mineButton:
                    ListFragmentView.setContent(R.string.mineTab);
                    Intent mi = new Intent(MainActivity.this, FragmentView.class);
                    startActivity(mi);
                    break;
                case R.id.shopButton:
                    break;
                case R.id.economicsButton:
                    ListFragmentView.setContent(R.string.economicsTab);
                    Intent ei = new Intent(MainActivity.this, EconomicsActivity.class);
                    startActivity(ei);
                    break;
                case R.id.universeButton:
                    break;
                case R.id.settingsButton:
                    break;
            }
        }
    };

    private void updateUI(){

    }
}
