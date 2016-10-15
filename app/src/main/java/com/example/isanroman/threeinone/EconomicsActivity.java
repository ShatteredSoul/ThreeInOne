package com.example.isanroman.threeinone;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by isanroman on 10/10/2016.
 */

public class EconomicsActivity extends FragmentActivity{

    @Override
    protected void onCreate(Bundle savedInstanceBundle){
        super.onCreate(savedInstanceBundle);
        setContentView(R.layout.activity_economics);

        TextView textView = (TextView)findViewById(R.id.economicsTitle);
        textView.setText(ListFragmentView.getContent());

        Button bButton = (Button)findViewById(R.id.ebackbutton);
        bButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
    @Override
    protected void onResume(){
        super.onResume();
        List<Data> data = new ArrayList<Data>();
        String title[] = getTitles();
        String desc[] = getDescr();
        for(int i = 0; i < title.length; i++){
            Data temp = new Data(title[i], desc[i]);
            data.add(temp);
        }

        ListFragmentView.refreshedData(data);
    }

    private String[] getTitles(){
        String titles[] = getResources().getStringArray(R.array.economicsItems);
        return titles;
    }

    private String[] getDescr(){
        String titles[] = getResources().getStringArray(R.array.economicsItems);
        String desc[] = new String[10];
        for(int i = 0; i < 10; i++){
            desc[i] = Double.toString(Prices.getMarketPrices(titles[i]));
        }

        return desc;
    }
}
