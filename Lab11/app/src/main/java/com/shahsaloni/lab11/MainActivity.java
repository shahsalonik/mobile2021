package com.shahsaloni.lab11;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView textView, menuView;
    View popupView;
    RequestQueue requestQueue;
    AppCompatButton nextButton, likeButton;
    PopupWindow popupWindow;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    String url = "https://api.quotable.io/random";
    String content, author;
    static List<String> likeList = new ArrayList<>();

    int count = 0;

    String TAG = "com.shahsaloni.lab11";

    @RequiresApi(api = Build.VERSION_CODES.N)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text);
        menuView = new TextView(this);
        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        popupView = inflater.inflate(R.layout.popup_window, null);
        popupWindow = new PopupWindow(popupView, 100, 100, true);

        nextButton = findViewById(R.id.nextButton);
        likeButton = findViewById(R.id.likeButton);

        requestQueue = Volley.newRequestQueue(this);

        sharedPreferences = getSharedPreferences(TAG, MODE_PRIVATE);
        editor = sharedPreferences.edit();

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        int contentIndex = response.indexOf("content");
                        int authorIndex = response.indexOf("\"author\"");
                        content = response.substring(contentIndex + 10, authorIndex - 2);
                        author = response.substring(authorIndex + 10, response.indexOf(",", authorIndex) - 1);
                        String finalQuote = content + "\n- " + author;
                        textView.setText(finalQuote);
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("error", error.toString());
                    }
                });
                requestQueue.add(request);
            }
        });

        likeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addQuote(v);

            }
        });

    }

    public boolean isNew(String quote, String author) {
        if(likeList.contains(quote + " \n- " + author)) {
            return false;
        }
        else {
            return true;
        }
    }

    public void addQuote(View view) {
        if(isNew(content, author)) {
            likeList.add(content + " \n- " + author);
            editor.putString(author, content);
            Log.i("added:", ""+likeList.get(count));
            count++;
        }
        else {
            popupWindow.showAtLocation(textView, Gravity.CENTER, 10, 10);
            popupView.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    popupWindow.dismiss();
                    return true;
                }
            });
            return;
        }
        editor.apply();
    }

    public void nextPage(View view) {
        Intent intent = new Intent(getApplicationContext(), Layout1Activity.class);
        startActivity(intent);
    }

}

