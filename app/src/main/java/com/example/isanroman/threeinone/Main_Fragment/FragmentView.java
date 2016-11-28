package com.example.isanroman.threeinone.Main_Fragment;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.isanroman.threeinone.Main_Fragment.CustomAdapter;
import com.example.isanroman.threeinone.Main_Fragment.ListFragmentView;
import com.example.isanroman.threeinone.R;

/**
 * Created by Gamer-Isaiah on 10/8/2016.
 */

public class FragmentView extends FragmentActivity{

    private CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);

        TextView title = (TextView)findViewById(R.id.list_title);
        title.setText(ListFragmentView.getContent());

        Button bButton = (Button)findViewById(R.id.backButton);
        bButton.setOnClickListener(new View.OnClickListener() {
           @Override
            public void onClick(View v) {
              onBackPressed();
            }
        });
    }
}
