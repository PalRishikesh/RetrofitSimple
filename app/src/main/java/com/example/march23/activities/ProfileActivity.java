package com.example.march23.activities;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.example.march23.R;
import com.example.march23.fragments.HomeFragment;
import com.example.march23.fragments.SettingFragment;
import com.example.march23.fragments.UserFragment;
import com.example.march23.models.Users;
import com.example.march23.storage.SharedPrefManager;

public class ProfileActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
//
//    private TextView textViewU;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
//        textViewU=findViewById(R.id.textViewUsers);
//        Users users=SharedPrefManager.getInstance(this).getUserss();
//        textViewU.setText("Welcome Back "+users.getName());
        BottomNavigationView navigationView=findViewById(R.id.bottom_nav);


        navigationView.setOnNavigationItemSelectedListener(this);
        dispalyFragment(new HomeFragment());
    }

    private void dispalyFragment(Fragment fragment){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.relativeLayouts,fragment)
                .commit();

    }
    @Override
    protected void onStart() {
        super.onStart();
        if(!SharedPrefManager.getInstance(this).isLoggedIn()){
            Intent intent=new Intent(this, MainActivity.class);

            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

            startActivity(intent);
            Toast.makeText(this,"Login Please",Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Fragment fragment = null;
        switch (menuItem.getItemId()){

            case R.id.menu_home:
                fragment=new HomeFragment();
                break;
            case R.id.menu_users:
                fragment=new UserFragment();
                break;
            case R.id.menu_setting:
                fragment=new SettingFragment();
                break;
        }
        if(fragment!=null){
            dispalyFragment(fragment);
        }
        return false;
    }
}
