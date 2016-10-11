package com.example.isanroman.threeinone;

import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gamer-Isaiah on 10/8/2016.
 */

public class ListFragmentView extends ListFragment implements AdapterView.OnItemClickListener {

    private static int contextTitle;
    private static String[] title, desc;

    CustomAdapter adapter;
    private List<Data> rowItems;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       return inflater.inflate(R.layout.list_view_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setArrays();
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
        ImageView imageView = (ImageView)getActivity().findViewById(R.id.eImage); // this is returning null
        imageView.setImageResource(R.drawable.image_lens);

        Button button = (Button) view.findViewById(R.id.deleteButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Button Clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public static void setContent(int tab){
        contextTitle = tab;
    }

    public static int getContent(){
        return contextTitle;
    }

    public void setArrays(){
        if(contextTitle == R.string.shipTab){
            title = getResources().getStringArray(R.array.shipItems);
            desc = getResources().getStringArray(R.array.shipDesc);
        }else if(contextTitle == R.string.playerTab){
            title = getResources().getStringArray(R.array.playerItems);
            desc = getResources().getStringArray(R.array.playerDesc);
        }else if(contextTitle == R.string.mineTab){
            title = getResources().getStringArray(R.array.mineItems);
            desc = getResources().getStringArray(R.array.mineDesc);
        }else if(contextTitle == R.string.economicsTab){
            title = getResources().getStringArray(R.array.economicsItems);
            desc = getResources().getStringArray(R.array.economicsPrice);
        }
    }
}