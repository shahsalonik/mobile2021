package com.shahsaloni.androidlifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    int countonCreate = 0;
    int countonStart = 0;
    int countonResume = 0;
    int countonPause = 0;
    int countonStop = 0;
    int countonRestart = 0;
    int countonDestroy = 0;

    String TAG = "com.shahsaloni.demo.androidlifecycle";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPreferences = getSharedPreferences(TAG, MODE_PRIVATE);
        editor = sharedPreferences.edit();
        countonCreate++;
        storeValues();

    }

    private void setInitialValues() {

        countonCreate = sharedPreferences.getInt("onCreate", 0);
        countonStart = sharedPreferences.getInt("onStart", 0);
        countonResume = sharedPreferences.getInt("onResume", 0);
        countonPause = sharedPreferences.getInt("onPause", 0);
        countonStop = sharedPreferences.getInt("onStop", 0);
        countonRestart = sharedPreferences.getInt("onRestart", 0);
        countonDestroy = sharedPreferences.getInt("onDestroy", 0);
    }

    private void storeValues() {
        editor.putInt("onCreate", countonCreate);
        editor.putInt("onStart", countonStart);
        editor.putInt("onResume", countonResume);
        editor.putInt("onPause", countonPause);
        editor.putInt("onStop", countonStop);
        editor.putInt("onRestart", countonRestart);
        editor.putInt("onDestroy", countonDestroy);
        editor.apply();
        System.out.println("Values onCreate: " + countonCreate);
        System.out.println("Values onStart: " + countonStart);
        System.out.println("Values onResume: " + countonResume);
        System.out.println("Values onPause: " + countonPause);
        System.out.println("Values onStop: " + countonStop);
        System.out.println("Values onRestart: " + countonRestart);
        System.out.println("Values onDestroy: " + countonDestroy);
        System.out.println("Values ==============================");
    }
    private void erase() {
        editor.remove("Values").commit();
    }

    @Override
    protected void onStart() {
        super.onStart();
        countonStart++;
        storeValues();
    }

    @Override
    protected void onResume() {
        super.onResume();
        countonResume++;
        storeValues();
    }

    @Override
    protected void onPause() {
        super.onPause();
        countonPause++;
        storeValues();
    }

    @Override
    protected void onStop() {
        super.onStop();
        countonStop++;
        storeValues();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        countonRestart++;
        storeValues();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        countonDestroy++;
        storeValues();
    }
}

