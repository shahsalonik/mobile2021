package com.shahsaloni.fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.fragment_container, MyFragment.newInstance(16, "Saloni"), "MyFragment");
        ft.commit();
    }

    public void update_text(View view) {
        MyFragment myFragment = (MyFragment) getSupportFragmentManager().findFragmentByTag("MyFragment");
        ((TextView)myFragment.view.findViewById(R.id.frag_view)).setText(R.string.hola);
    }
}