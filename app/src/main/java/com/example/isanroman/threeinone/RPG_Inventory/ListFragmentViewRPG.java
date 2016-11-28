package com.example.isanroman.threeinone.RPG_Inventory;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.isanroman.threeinone.Main.Data;
import com.example.isanroman.threeinone.Economics.Inventory;
import com.example.isanroman.threeinone.Items;
import com.example.isanroman.threeinone.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gamer-Isaiah on 10/8/2016.
 */

public class ListFragmentViewRPG extends ListFragment implements AdapterView.OnItemClickListener {

    private static String[] title = Inventory.getUsersItemsNames(), desc = Inventory.getUsersItemsDesc();

    CustomAdapterRPG adapter;
    private static List<Data> rowItems;
    private static String colors[] = {"#68E52A", "#000000"};
    private static int previousPosition;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.list_view_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        rowItems = new ArrayList<Data>();

        for(int i = 0; i < title.length; i++){
            Data items = new Data(title[i], desc[i]);
            rowItems.add(items);
        }

        adapter = new CustomAdapterRPG(getActivity(), rowItems);
        setListAdapter(adapter);
        getListView().setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if(!(previousPosition == position))
            parent.getChildAt(previousPosition).setBackgroundColor(Color.parseColor(colors[1]));
        parent.getChildAt(position).setBackgroundColor(Color.parseColor(colors[0]));
        setPreviousPosition(position);

        ImageView itemImage = (ImageView)getActivity().findViewById(R.id.itemImage);
        TextView itemDesc = (TextView)getActivity().findViewById(R.id.itemDescription);
        Button itemAction = (Button)getActivity().findViewById(R.id.itemAction);

        Data row_pos = rowItems.get(position);
        int itemId = Items.getItemId(row_pos.getName());

        itemImage.setImageResource(Items.getItemImage(itemId));
        itemDesc.setText(Items.getItemDesc(itemId));
        itemAction.setText("Sell/Equip");
    }

    private static void setPreviousPosition(int position){
        previousPosition = position;
    }

    public  static int getPreviousPosition(){
        return previousPosition;
    }

    public static List<Data> getRowItems(){
        return rowItems;
    }
}
