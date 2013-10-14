package com.uuarner.thenewboston;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by pwarner on 10/5/13.
 */
public class Menu extends ListActivity{

    String classes[] = {"MainActivity", "TextPlay", "Email", "Camera", "Data",
            "example5", "example6", "example7", "example18", "example9", "example10"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(new ArrayAdapter<String>(Menu.this, android.R.layout.simple_list_item_1, classes));
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Class ourClass = null;
        try {
            ourClass = Class.class.forName("com.uuarner.thenewboston." + classes[position]);
            Intent ourIntent = new Intent(Menu.this, ourClass);
            startActivity(ourIntent);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
