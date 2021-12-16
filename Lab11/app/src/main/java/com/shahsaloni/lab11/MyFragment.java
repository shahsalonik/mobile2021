package com.shahsaloni.lab11;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MyFragment extends Fragment {

    View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.menu, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.view = view;
        String quote = getArguments().getString("Quote", "");
        String author = getArguments().getString("Author", "");
    }

    public static MyFragment newInstance(String content, String author) {
        Bundle args = new Bundle();
        MyFragment fragment = new MyFragment();
        args.putString("Quote", content);
        args.putString("Author", author);
        fragment.setArguments(args);
        return fragment;
    }

}
