package com.e.editablelistview;
import android.app.Application;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ViewListContents AppCompatActivity {
    DatabaseHelper myDB;

    @Override
    protected void onCreate(@Nullable Bundle savedIstanceState) {
        super.onCreate(savedIstanceState);
        setContentView(R.layout.viewcontent_layout);
        ListView listView = (ListView) findViewById(R.id.ListView);
        myDB = new DatabaseHelper(this);

        ArrayList<String> thelist = new ArrayList<>();
        Cursor data = myDB.getListContents();

        if (data.getCount() == 0) {
            Toast.makeText(MainActivity.this,"The Database was empty",Toast.LENGTH_LONG).show();
        }else {
          while (data.moveToNext()) {
               thelist.add(data.getString(1));
              ListAdapter listAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,thelist);
              listView.setAdapter(listAdapter);
          }
        }

    }

}
