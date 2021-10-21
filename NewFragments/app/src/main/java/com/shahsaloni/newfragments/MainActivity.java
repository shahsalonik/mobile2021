package com.shahsaloni.newfragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private MainFragment MainFragment = new MainFragment();
    Button correct, wrong1, wrong2, wrong3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        correct = findViewById(R.id.correct);
        wrong1 = findViewById(R.id.wrong1);
        wrong2 = findViewById(R.id.wrong2);
        wrong3 = findViewById(R.id.wrong3);

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.fragment_container, MainFragment, "MyFragment");
        ft.commit();

        correct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.correct_ans);
            }
        });

        wrong1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.wrong_ans);
            }
        });

        wrong2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.wrong_ans);
            }
        });

        wrong3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.wrong_ans);
            }
        });

    }

    public void correct_update_text(View view) {
        MainFragment myFragment = (MainFragment) getSupportFragmentManager().findFragmentByTag("MyFragment");
        ((TextView)myFragment.view.findViewById(R.id.correct_screen_text)).setText(R.string.thanks);
    }

    public void wrong_update_text(View view) {
        MainFragment myFragment = (MainFragment) getSupportFragmentManager().findFragmentByTag("MyFragment");
        ((TextView)myFragment.view.findViewById(R.id.wrong_screen_text)).setText(R.string.thanks);
    }
}