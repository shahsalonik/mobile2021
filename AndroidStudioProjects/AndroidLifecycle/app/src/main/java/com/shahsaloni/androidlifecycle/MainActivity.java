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

    int lifecountonCreate = 0;
    int lifecountonStart = 0;
    int lifecountonResume = 0;
    int lifecountonPause = 0;
    int lifecountonStop = 0;
    int lifecountonRestart = 0;
    int lifecountonDestroy = 0;

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
        setInitialValues();
        editor = sharedPreferences.edit();
        lifecountonCreate++;
        countonCreate++;
        storeValues();
        setCurrentViewText();
        setLifetimeViewText();

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

        lifetime.setText(
                "Lifetime\n\n" +
                        "onCreate: " + lifecountonCreate + "\n" +
                        "onStart: " + lifecountonStart + "\n" +
                        "onResume: " + lifecountonResume + "\n" +
                        "onPause: " + lifecountonPause + "\n" +
                        "onStop: " + lifecountonStop + "\n" +
                        "onRestart: " + lifecountonRestart + "\n" +
                        "onDestroy: " + lifecountonDestroy + "\n"
        );

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

        lifecountonCreate = 0;
        lifecountonStart = 0;
        lifecountonResume = 0;
        lifecountonPause = 0;
        lifecountonStop = 0;
        lifecountonRestart = 0;
        lifecountonDestroy = 0;
        editor.clear();
        editor.apply();
        setLifetimeViewText();

    }

    private void setInitialValues() {
        lifecountonCreate = sharedPreferences.getInt("onCreate", 0);
        lifecountonStart = sharedPreferences.getInt("onStart", 0);
        lifecountonResume = sharedPreferences.getInt("onResume", 0);
        lifecountonPause = sharedPreferences.getInt("onPause", 0);
        lifecountonStop = sharedPreferences.getInt("onStop", 0);
        lifecountonRestart = sharedPreferences.getInt("onRestart", 0);
        lifecountonDestroy = sharedPreferences.getInt("onDestroy", 0);
        setLifetimeViewText();
    }

    private void storeValues() {
        editor.putInt("onCreate", lifecountonCreate);
        editor.putInt("onStart", lifecountonStart);
        editor.putInt("onResume", lifecountonResume);
        editor.putInt("onPause", lifecountonPause);
        editor.putInt("onStop", lifecountonStop);
        editor.putInt("onRestart", lifecountonRestart);
        editor.putInt("onDestroy", lifecountonDestroy);
        editor.apply();
        setLifetimeViewText();
        setCurrentViewText();
    }

    @Override
    protected void onStart() {
        super.onStart();
        countonStart++;
        lifecountonStart++;
        storeValues();
    }

    @Override
    protected void onResume() {
        super.onResume();
        countonResume++;
        lifecountonResume++;
        storeValues();
    }

    @Override
    protected void onPause() {
        super.onPause();
        countonPause++;
        lifecountonPause++;
        storeValues();
    }

    @Override
    protected void onStop() {
        super.onStop();
        countonStop++;
        lifecountonStop++;
        storeValues();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        countonRestart++;
        lifecountonRestart++;
        storeValues();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        countonDestroy++;
        lifecountonDestroy++;
        storeValues();
    }
}

