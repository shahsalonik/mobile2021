package com.shahsaloni.lab11;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Request.Method;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    RequestQueue requestQueue;
    AppCompatButton button;
    String url = "https://api.quotable.io/random";

    @RequiresApi(api = Build.VERSION_CODES.N)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text);
        button = findViewById(R.id.nextButton);
        List<Quotes> quotes = new ArrayList<>();
        requestQueue = Volley.newRequestQueue(this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        int contentIndex = response.indexOf("content");
                        int authorIndex = response.indexOf("\"author\"");
                        String content = response.substring(contentIndex + 10, authorIndex - 2);
                        String author = response.substring(authorIndex + 10, response.indexOf(",", authorIndex) - 1);
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
    }


}