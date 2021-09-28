package com.shahsaloni.androidlifecycle;

import static android.provider.Settings.System.getInt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView lifetime, current;
    Button lifetimeBtn, currentBtn;
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
        lifetime = findViewById(R.id.lifetime);
        current = findViewById(R.id.current);
        lifetimeBtn = findViewById(R.id.lifetime_btn);
        currentBtn = findViewById(R.id.current_btn);
        sharedPreferences = getSharedPreferences(TAG, MODE_PRIVATE);
        editor = sharedPreferences.edit();
        countonCreate++;
        storeValues();
        setInitialValues();
        setCurrentViewText();

        lifetimeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eraseLifetimeValues();
            }
        });

        currentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eraseCurrentValues();
            }
        });

    }

    private void setCurrentViewText() {

        current.setText(
                "This Run\n\n" +
                "onCreate: " + countonCreate + "\n" +
                "onStart: " + countonStart + "\n" +
                "onResume: " + countonResume + "\n" +
                "onPause: " + countonPause + "\n" +
                "onStop: " + countonStop + "\n" +
                "onRestart: " + countonRestart + "\n" +
                "onDestroy: " + countonDestroy + "\n"

        );


    }

    private void setLifetimeViewText() {


    }

    private void eraseCurrentValues() {
        countonCreate = 0;
        countonStart = 0;
        countonResume = 0;
        countonPause = 0;
        countonStop = 0;
        countonRestart = 0;
        countonDestroy = 0;

        setCurrentViewText();

    }

    private void eraseLifetimeValues() {

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
        setCurrentViewText();

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

