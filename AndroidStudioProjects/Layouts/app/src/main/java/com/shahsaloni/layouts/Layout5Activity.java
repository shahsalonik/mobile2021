package com.shahsaloni.layouts;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

public class Layout5Activity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout5);
    }

    public void nextPage(View view) {
        Intent intent = new Intent(getApplicationContext(), Layout6Activity.class);
        startActivity(intent);
    }

}
