package com.shahsaloni.lab11;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class Layout1Activity extends Activity {
    ListView listView;
    ArrayAdapter arrayAdapter;

    //List<String> sharedPrefList = (ArrayList) MainActivity.sharedPreferences.getAll();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
        listView = findViewById(R.id.listview);
        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, MainActivity.likeList);
        listView.setAdapter(arrayAdapter);
    }

    /*@Override
    protected void onResume() {
        super.onResume();
        for(int x = 0; x < MainActivity.sharedPreferences.getAll().size(); x++) {
            MainActivity.likeList.add(x, MainActivity.sharedPreferences.getString(String.valueOf(x), ""));
        }

    }*/



}
