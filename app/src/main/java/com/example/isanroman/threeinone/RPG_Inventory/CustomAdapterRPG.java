package com.example.isanroman.threeinone.RPG_Inventory;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.isanroman.threeinone.Main.Data;
import com.example.isanroman.threeinone.Economics.Inventory;
import com.example.isanroman.threeinone.RPG.Items;
import com.example.isanroman.threeinone.R;

import java.util.List;

/**
 * Created by Gamer-Isaiah on 10/9/2016.
 */

public class CustomAdapterRPG extends BaseAdapter{

    private Context context;
    private static List<Data> rowItem;

    CustomAdapterRPG(Context context, List<Data> rowItem){
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
            convertView = inflater.inflate(R.layout.custom_list_rpg, null);
        }
        final Data row_pos = rowItem.get(position);

        ImageView itemImage = (ImageView)convertView.findViewById(R.id.itemListImage);
        TextView itemName = (TextView)convertView.findViewById(R.id.itemListName);
        TextView itemDesc = (TextView)convertView.findViewById(R.id.itemListDesc);
        TextView itemLevel = (TextView)convertView.findViewById(R.id.itemListLevel);

        int id = Inventory.getItem(position);

        itemImage.setImageResource(Items.getItemImage(id));
        itemName.setText(Items.getItemName(id));
        itemDesc.setText(Items.getItemDesc(id));
        itemLevel.setText(Integer.toString(Items.getItemLevel(id)));

        return convertView;
    }
}
