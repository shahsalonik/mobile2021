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
    Button correctBtn, wrongBtn1, wrongBtn2, wrongBtn3;
    int layoutID;
    public static MainFragment newInstance(int main_fragment) {
        MainFragment mainFragment = new MainFragment();
        mainFragment.layoutID = main_fragment;
        return mainFragment;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(layoutID, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.view = view;
        correctBtn = view.findViewById(R.id.correct);
        wrongBtn1 = view.findViewById(R.id.wrong1);
        wrongBtn2 = view.findViewById(R.id.wrong2);
        wrongBtn3 = view.findViewById(R.id.wrong3);
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
