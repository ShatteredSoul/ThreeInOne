package com.example.isanroman.threeinone;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gamer-Isaiah on 10/8/2016.
 */

public class ListFragmentViewRPG extends ListFragment implements AdapterView.OnItemClickListener {

    private static String[] title = Inventory.getUsersItemsNames(), desc = Inventory.getUsersItemsDesc();

    CustomAdapter adapter;
    private static List<Data> rowItems;
    private static String colors[] = {"#68E52A"};
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

        adapter = new CustomAdapter(getActivity(), rowItems);
        setListAdapter(adapter);
        getListView().setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if(!(previousPosition == position))
            parent.getChildAt(previousPosition).setBackgroundColor(Color.parseColor(colors[0]));
        parent.getChildAt(position).setBackgroundColor(Color.parseColor(colors[0]));
        previousPosition = position;

        ImageView itemImage = (ImageView)view.findViewById(R.id.itemImage);
        TextView itemDesc = (TextView)view.findViewById(R.id.itemDescription);
        Button itemAction = (Button)view.findViewById(R.id.itemAction);

        Data row_pos = rowItems.get(position);
        int itemId = Items.getItemId(row_pos.getName());

        itemImage.setImageResource(Items.getItemImage(itemId));
        itemDesc.setText(Items.getItemDesc(itemId));
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
