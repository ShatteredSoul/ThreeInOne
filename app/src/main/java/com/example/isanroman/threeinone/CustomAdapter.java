package com.example.isanroman.threeinone;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Gamer-Isaiah on 10/9/2016.
 */

public class CustomAdapter extends BaseAdapter{

    private Context context;
    private static List<Data> rowItem;
    private static String[] rowColors = {"#C87533", "#ADB2BD", "#E6E7E8", "#C0C0C0", "#787C85", "#9090A3", "#E5E4E2", "#FFD700", "#26DCF5", "#5B8a5F"};

    CustomAdapter(Context context, List<Data> rowItem){
        this.context = context;
        this.rowItem = rowItem;
    }

    @Override
    public int getCount(){
        return rowItem.size();
    }

    @Override
    public Object getItem(int position){
        return rowItem.get(position);
    }

    @Override
    public long getItemId(int position){
        return rowItem.indexOf(getItem(position));
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.custom_list, null);
        }

        TextView name = (TextView)convertView.findViewById(R.id.list_item_string);
        TextView descr = (TextView)convertView.findViewById(R.id.list_item_description);
        Button deleteButton = (Button)convertView.findViewById(R.id.deleteButton);

        final Data row_pos = rowItem.get(position);
        name.setText(row_pos.getName());
        descr.setText(row_pos.getId());
        deleteButton.setText(R.string.buy_sell);

        if(ListFragmentView.getContent() == R.string.economicsTab) {
            if (!(Double.parseDouble(row_pos.getId()) == Prices.getMarketPrices(row_pos.getName()))) {
                descr.setText(Double.toString(Prices.getMarketPrices(row_pos.getName())));
            } else {
                descr.setText(row_pos.getId());
            }
            convertView.setBackgroundColor(Color.parseColor(rowColors[position]));
        }

        if(ListFragmentView.getContent() == R.string.mineTab) {
            deleteButton.setText(Double.toString(Mines.getCost(row_pos.getName())));
            convertView.setBackgroundColor(Color.parseColor(rowColors[position]));
            descr.setText(Double.toString(Mines.getProduction(row_pos.getName())));
        }

        return convertView;
    }
}
