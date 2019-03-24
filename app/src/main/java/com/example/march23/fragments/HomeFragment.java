package com.example.march23.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.march23.R;
import com.example.march23.storage.SharedPrefManager;

public class HomeFragment extends Fragment {
    private TextView textViewEmail,textViewName;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.home_fragment,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        textViewEmail=view.findViewById(R.id.textViewwEmail);
        textViewName=view.findViewById(R.id.textViewName);

        textViewEmail.setText(SharedPrefManager.getInstance(getActivity()).getUserss().getEmail());
        textViewName.setText(SharedPrefManager.getInstance(getActivity()).getUserss().getName());
    }
}
