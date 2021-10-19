package com.shahsaloni.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MyFragment extends Fragment {
    View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.my_fragment, container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.view = view;
        String name = getArguments().getString("MyName", "Jeff");
        int age = getArguments().getInt("MyAge", 18000);
        TextView textView = view.findViewById(R.id.frag_view);
        String nameGreeting = "" + (getString(R.string.hello)) + name;
        textView.setText(nameGreeting);
        Button btn = view.findViewById(R.id.frag_button);
        String btnStr = (getString(R.string.btn_message)) + age;
        btn.setText(btnStr);
    }

    public static MyFragment newInstance(int i, String str) {
        MyFragment myFragment = new MyFragment();
        Bundle args = new Bundle();
        args.putInt("MyAge", i);
        args.putString("MyName", str);
        myFragment.setArguments(args);
        return myFragment;
    }
}
