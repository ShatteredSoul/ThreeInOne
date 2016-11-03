package com.example.isanroman.threeinone;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

/**
 * Created by isanroman on 11/1/2016.
 */

public class RPG_Inventory extends AppCompatActivity {

    View vv;
    boolean start, sell, equip;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rpg_inventory);

        Button itemAction = (Button)findViewById(R.id.itemAction);
        itemAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerForContextMenu(v);
                openContextMenu(v);
                start = true;
                vv = v;
            }
        });
    }

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){
        super.onCreateContextMenu(menu, v, menuInfo);
        if(start)
            getMenuInflater().inflate(R.menu.sell_equip, menu);
        else
            getMenuInflater().inflate(R.menu.verify, menu);
    }

    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        if(start) {
            switch (item.getItemId()) {
                case R.id.sellItem:
                    registerForContextMenu(vv);
                    openContextMenu(vv);
                    start = false;
                    sell = true;
                    break;
                case R.id.equipItem:
                    registerForContextMenu(vv);
                    openContextMenu(vv);
                    start = false;
                    equip = true;
                    break;
            }
        }else{
            switch(item.getItemId()){
                case R.id.agree:
                    if(sell){
                        Toast.makeText(RPG_Inventory.this, R.string.sell_successful, Toast.LENGTH_SHORT);
                        List<Data> temp = ListFragmentViewRPG.getRowItems();
                        Data tem = temp.get(ListFragmentViewRPG.getPreviousPosition());
                        Inventory.addMoney(Items.getItemPrice(Items.getItemId(tem.getName())));
                    }else{

                    }
                    break;
                case R.id.deny:
                    if(sell){

                    }else{

                    }
                    break;
            }
        }
        return true;
    }
}
