package com.example.isanroman.threeinone;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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
}
