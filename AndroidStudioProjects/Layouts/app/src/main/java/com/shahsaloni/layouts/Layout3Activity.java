package com.shahsaloni.layouts;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

public class Layout3Activity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout3);
    }

    public void nextPage(View view) {
        Intent intent = new Intent(getApplicationContext(), Layout4Activity.class);
        startActivity(intent);
    }
}
