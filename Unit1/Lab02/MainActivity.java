package com.shahsaloni.guielements;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button incrementButton;
    TextView greetingDisplay;
    int count = 0;
    String[] animals;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        incrementButton = findViewById(R.id.increment_button);
        greetingDisplay = findViewById(R.id.greeting_textview);
        animals = getResources().getStringArray(R.array.animal_array);
        incrementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                System.out.println("incrementing: "+ ++count);
//                Log.i("incrementing", ""+count);
                greetingDisplay.setText(getString(R.string.Beginning) + animals[count++] + getString(R.string.End));
                count %= animals.length;
            }
        });
    }

    public void decrement(View view) {
        if(--count < 0) {
            count = animals.length - 1;
            greetingDisplay.setText(getString(R.string.Beginning) + animals[count] + getString(R.string.End));
        }
        greetingDisplay.setText(getString(R.string.Beginning) + animals[count] + getString(R.string.End));
        count %= animals.length;
    }
}