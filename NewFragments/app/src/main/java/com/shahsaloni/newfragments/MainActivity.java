package com.shahsaloni.newfragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private MainFragment mainFragment = MainFragment.newInstance(R.layout.main_fragment);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.fragment_container, mainFragment, "MyFragment");
        ft.commit();

    }

    public void correct_update_text(View view) {
        MainFragment myFragment = (MainFragment) getSupportFragmentManager().findFragmentByTag("MyFragment");
        ((TextView)myFragment.view.findViewById(R.id.correct_screen_text)).setText(R.string.thanks);
    }

    public void wrong_update_text(View view) {
        MainFragment myFragment = (MainFragment) getSupportFragmentManager().findFragmentByTag("MyFragment");
        ((TextView)myFragment.view.findViewById(R.id.wrong_screen_text)).setText(R.string.thanks);
    }

    public void correctclick(View view) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fragment_container, MainFragment.newInstance(R.layout.correct_ans), "MyFragment");
        ft.commit();
    }

    public void wrongclick(View view) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fragment_container, MainFragment.newInstance(R.layout.wrong_ans), "MyFragment");
        ft.commit();
    }
}