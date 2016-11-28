package com.example.isanroman.threeinone.Main_Fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.isanroman.threeinone.Main.Data;
import com.example.isanroman.threeinone.Economics.EconomicsPurchase;
import com.example.isanroman.threeinone.Economics.Inventory;
import com.example.isanroman.threeinone.Economics.Mines;
import com.example.isanroman.threeinone.Economics.Prices;
import com.example.isanroman.threeinone.R;
import com.example.isanroman.threeinone.Main.SaveData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gamer-Isaiah on 10/8/2016.
 */

public class ListFragmentView extends ListFragment implements AdapterView.OnItemClickListener {

    private static int contextTitle;
    private static String[] title, desc;

    CustomAdapter adapter;
    private static List<Data> rowItems;
    private static int position, previousPosition;
    private static String colors[] = {"#68E52A"};
    private static String[] rowColors = {"#C87533", "#ADB2BD", "#E6E7E8", "#C0C0C0", "#787C85", "#9090A3", "#E5E4E2", "#FFD700", "#26DCF5", "#5B8a5F"};

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

        if(!(previousPosition == position)){
            parent.getChildAt(previousPosition).setBackgroundColor(Color.parseColor(rowColors[previousPosition]));
        }
        parent.getChildAt(position).setBackgroundColor(Color.parseColor(colors[0]));
        setPreviousPosition(position);

        if(contextTitle == R.string.mineTab){
            Button button = (Button)getListView().getChildAt(getPreviousPosition()).findViewById(R.id.deleteButton);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Data row_pos = rowItems.get(getPreviousPosition());
                    if(!(Mines.getCost(row_pos.getName()) > Inventory.getMoney())){
                        Inventory.subtractMoney(Mines.getCost(row_pos.getName()));
                        Toast.makeText(getActivity(), R.string.buy_successful, Toast.LENGTH_SHORT).show();
                        if(Mines.getProductionLevel(row_pos.getName()) < 1){
                            Mines.setProduction(row_pos.getName(), Prices.getMarketPrices(row_pos.getName()) * 25);
                            Mines.increaseCost(row_pos.getName());
                            Mines.increaseProductionLevel(row_pos.getName());
                            SaveData.productionChange = true;
                            SaveData.costChange = true;
                            SaveData.productionLevelChange = true;
                            TextView textView = (TextView)getListView().getChildAt(getPreviousPosition()).findViewById(R.id.list_item_description);
                            textView.setText(Double.toString(Mines.getProduction(row_pos.getName())));
                            TextView textCost = (TextView)getListView().getChildAt(getPreviousPosition()).findViewById(R.id.deleteButton);
                            textCost.setText(Double.toString(Mines.getCost(row_pos.getName())));

                        }else if(Mines.getProductionLevel(row_pos.getName()) >= 1){
                            Mines.increaseProduction(row_pos.getName());
                            Mines.increaseCost(row_pos.getName());
                            Mines.increaseProductionLevel(row_pos.getName());
                            SaveData.productionChange = true;
                            SaveData.costChange = true;
                            SaveData.productionLevelChange = true;
                            TextView textView = (TextView)getListView().getChildAt(getPreviousPosition()).findViewById(R.id.list_item_description);
                            textView.setText(Double.toString(Mines.getProduction(row_pos.getName())));
                            TextView textCost = (TextView)getListView().getChildAt(getPreviousPosition()).findViewById(R.id.deleteButton);
                            textCost.setText(Double.toString(Mines.getCost(row_pos.getName())));
                        }
                    }else{
                        Toast.makeText(getActivity(), R.string.buy_unsuccessful, Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }else {

            Button button = (Button) view.findViewById(R.id.deleteButton);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    setPosition(getPreviousPosition());
                    Intent intent = new Intent(getActivity(), EconomicsPurchase.class);
                    startActivity(intent);
                }
            });
        }
    }

    public static void refreshedData(List<Data> data){
        rowItems.clear();
        rowItems.addAll(data);
    }

    public static void setContent(int tab){
        contextTitle = tab;
    }

    public static int getContent(){
        return contextTitle;
    }

    public static List<Data> getListData(){
        return rowItems;
    }

    private static void setPreviousPosition(int position){
        previousPosition = position;
    }

    private static int getPreviousPosition(){
        return previousPosition;
    }

    public static void setPosition(int i){
        position = i;
    }

    public static int getPosition(){
        return position;
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
            desc = getResources().getStringArray(R.array.mineProd);
        }else if(contextTitle == R.string.economicsTab){
            title = getResources().getStringArray(R.array.economicsItems);
            desc = getResources().getStringArray(R.array.economicsPrice);
        }
    }
}
