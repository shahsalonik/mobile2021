package com.shahsaloni.guielements;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button incrementButton, nameSubmit;
    TextView greetingDisplay;
    EditText nameEntered;
    int count = 0;
    String[] animals;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        incrementButton = findViewById(R.id.increment_button);
        greetingDisplay = findViewById(R.id.greeting_textview);
        animals = getResources().getStringArray(R.array.animal_array);
        incrementButton.setOnClickListener(view -> {
            greetingDisplay.setText(getString(R.string.Beginning) + animals[count++] + getString(R.string.End));
            count %= animals.length;

        });

        nameSubmit = findViewById(R.id.name_button);
        nameSubmit.setOnClickListener(view -> {
            nameEntered   = (EditText)findViewById(R.id.plain_text_input);
            greetingDisplay = (TextView)findViewById(R.id.greeting_textview);
            greetingDisplay.setText(getString(R.string.hi)+nameEntered.getText().toString()+"!");
        });

    }

    @SuppressLint("SetTextI18n")
    public void decrement(View view) {
        if(--count < 0) {
            count = animals.length - 1;
            greetingDisplay.setText(getString(R.string.Beginning) + animals[count] + getString(R.string.End));
        }
        greetingDisplay.setText(getString(R.string.Beginning) + animals[count] + getString(R.string.End));
        count %= animals.length;
    }
}