package com.shahsaloni.layouts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;

public class MainActivity extends AppCompatActivity {
    int ids[];
    int count = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ids = new int[] {R.layout.layout1, R.layout.layout2, R.layout.layout3, R.layout.layout4, R.layout.layout5, R.layout.layout6, R.layout.layout7};
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Intent intent = new Intent(getApplicationContext(), Layout1Activity.class);
        startActivity(intent);
        return true;
    }
}

//TODO 8 (bonus)