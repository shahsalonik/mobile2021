package com.shahsaloni.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button incrementButton, nameButton;
    EditText nameEntry;
    TextView greetingDisplay;
    Editable nameEntered;
    int count = 0;
    String[] animals;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        incrementButton = findViewById(R.id.increment_button);
        greetingDisplay = findViewById(R.id.greeting_textview);
        nameButton = findViewById(R.id.name_button);
        nameEntry = findViewById(R.id.edit_text);
        animals = getResources().getStringArray(R.array.animal_array);

        nameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nameEntered = nameEntry.getText();
                greetingDisplay.setText("Hi "+nameEntered+"!");
            }
        });

        incrementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                System.out.println("incrementing: "+ ++count);
//                Log.i("incrementing", ""+count);
                count = ++count % animals.length;
                greetingDisplay.setText(nameEntered+" should get a "+animals[count]+"!");
            }
        });



    }

    public void decrement(View view) {
        //System.out.println("prev animal: "+ --count);
        if(--count < 0) {
            count = animals.length - 1;
        }
        greetingDisplay.setText(nameEntered+" should get a "+animals[count]+"!");
    }
}