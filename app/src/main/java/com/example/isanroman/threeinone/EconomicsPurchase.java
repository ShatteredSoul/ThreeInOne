package com.example.isanroman.threeinone;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Gamer-Isaiah on 10/11/2016.
 */

public class EconomicsPurchase extends AppCompatActivity{

    private List<Data> row_items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_economics_purchace);

        row_items = ListFragmentView.getListData();
        final Data row_pos = row_items.get(ListFragmentView.getPosition());

        TextView textName = (TextView)findViewById(R.id.resourceName);
        TextView textPrice = (TextView)findViewById(R.id.resourcePrice);
        TextView textQuantity = (TextView)findViewById(R.id.resourceQuantity);
        final TextView buyTotal = (TextView)findViewById(R.id.resourceTotalPrice);
        final TextView sellTotal = (TextView)findViewById(R.id.resourceTotalSellPrice);

        final EditText editText = (EditText)findViewById(R.id.resourceSetQuantity);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                try {
                    String text = editText.getText().toString();
                    String multiplier = row_pos.getId();
                    double times = Double.parseDouble(multiplier);
                    int value = Integer.parseInt(text);
                    text = Double.toString(value * times);
                    buyTotal.setText(text);
                }catch(NumberFormatException e){e.printStackTrace();}
            }
        });

        EditText editText1 = (EditText)findViewById(R.id.resourceSetSellQuantity);
        editText1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                try {
                    String text = editText.getText().toString();
                    String multiplier = row_pos.getId();
                    double times = Double.parseDouble(multiplier);
                    int value = Integer.parseInt(text);
                    text = Double.toString((value * times) - ((value * times) * .2));
                    sellTotal.setText(text);
                }catch(NumberFormatException e){e.printStackTrace();}
            }
        });

        textName.setText(row_pos.getName());
        textPrice.setText(row_pos.getId());
        textQuantity.setText("Something");
    }
}
