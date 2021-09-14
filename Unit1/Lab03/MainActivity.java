package com.shahsaloni.sharedpreflab;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.slice.SliceItem;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView txtLeft, txtRight;
    Button btnLeft, btnRight;
    SeekBar seekbar;
    TextView[] views;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    ConstraintLayout layout;
    int prevSize;
    Snackbar snackbar;
    int clicks;

    String TAG = "com.shahsaloni.demo.sharedprefs";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtLeft = findViewById(R.id.top_left);
        txtRight = findViewById(R.id.top_right);
        btnLeft = findViewById(R.id.bottom_left);
        btnRight = findViewById(R.id.bottom_right);
        seekbar = findViewById(R.id.seekbar);
        layout = findViewById(R.id.main_layout);
        sharedPreferences = getSharedPreferences(TAG, MODE_PRIVATE);
        editor = sharedPreferences.edit();
        clicks = 0;

        views = new TextView[]{txtLeft, txtRight, btnLeft, btnRight};


        txtLeft.setOnClickListener(this);
        txtRight.setOnClickListener(this);
        btnLeft.setOnClickListener(this);
        btnRight.setOnClickListener(this);

        setInitValues();

        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                for (TextView t : views) {
                    t.setTextSize(i);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                prevSize = seekBar.getProgress();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                snackbar = Snackbar.make(layout, "Font size changed to " + seekBar.getProgress() + "SP", Snackbar.LENGTH_SHORT);
                snackbar.setAction("UNDO", new UndoListener());
                snackbar.show();
            }
        });

        layout.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                editor.clear().apply();
                setInitValues();
                clicks = 0;
                return true;
            }
        });


    }

    public class UndoListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            seekbar.setProgress(prevSize);
            for(TextView t : views) {
                t.setTextSize(prevSize);
                Snackbar.make(layout, "Font size reverted to " + seekbar.getProgress() + "SP", Snackbar.LENGTH_LONG).show();
            }
        }
    }

    private void setInitValues() {
        seekbar.setProgress(40);
        for (TextView v : views) {
            v.setText(sharedPreferences.getString(v.getTag().toString(), "0"));
            v.setTextSize(seekbar.getProgress());
        }
    }

    @Override
    public void onClick(View view) {
        TextView tView = (TextView) view;
        tView.setText(""+(Integer.parseInt(tView.getText().toString())+1));
        editor.putString(tView.getTag().toString(), tView.getText().toString());
        editor.apply();
    }

    @Override
    public void onResume() {
        super.onResume();
        setInitValues();
    }


}