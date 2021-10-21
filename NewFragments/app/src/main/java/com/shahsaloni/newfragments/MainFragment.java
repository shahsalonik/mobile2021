package com.shahsaloni.newfragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MainFragment extends Fragment {

    View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.main_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.view = view;
        Button correctBtn = view.findViewById(R.id.correct);
        Button wrongBtn1 = view.findViewById(R.id.wrong1);
        Button wrongBtn2 = view.findViewById(R.id.wrong2);
        Button wrongBtn3 = view.findViewById(R.id.wrong3);
    }

    public static MainFragment newInstance(int i, String str) {
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
        args.putInt("Correct", 1);
        args.putString("GoodJob", str);
        fragment.setArguments(args);
        return fragment;
    }
}
