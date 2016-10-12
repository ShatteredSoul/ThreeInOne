package com.example.isanroman.threeinone;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by Gamer-Isaiah on 10/9/2016.
 */

public class CustomAdapter extends BaseAdapter{

    private Context context;
    private List<Data> rowItem;

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

        return convertView;
    }
}
