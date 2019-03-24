package com.example.march23.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.march23.R;
import com.example.march23.activities.LoginActivity;
import com.example.march23.activities.ProfileActivity;
import com.example.march23.storage.SharedPrefManager;

public class SettingFragment extends Fragment implements View.OnClickListener{
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.setting_fragment,container,false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.findViewById(R.id.logoutText).setOnClickListener(this);
    }

    public void logout(){
        SharedPrefManager.getInstance(getActivity()).clar();
        Intent intent=new Intent(getActivity(), LoginActivity.class);

        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

        startActivity(intent);
        Toast.makeText(getActivity() ,"Login success",Toast.LENGTH_LONG).show();
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.logoutText:
                logout();
                break;
        }

    }
}
