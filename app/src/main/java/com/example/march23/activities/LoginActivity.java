package com.example.march23.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.march23.R;
import com.example.march23.api.RetrofitClient;
import com.example.march23.models.LoginResponse;
import com.example.march23.storage.SharedPrefManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editEmails, editPasswords;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        editEmails = findViewById(R.id.loginEmail);
        editPasswords = findViewById(R.id.loginPassword);
        findViewById(R.id.loginBtn).setOnClickListener(this);
        findViewById(R.id.registerScreen).setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        if(SharedPrefManager.getInstance(this).isLoggedIn()){
            Intent intent=new Intent(this, ProfileActivity.class);

            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

            startActivity(intent);
            Toast.makeText(this,"Login success",Toast.LENGTH_LONG).show();
        }
    }

    public void userLogin() {
        String email = editEmails.getText().toString().trim();
        String pass = editPasswords.getText().toString().trim();


        Call<LoginResponse> calllogin = RetrofitClient.
                getInstance()
                .getApi()
                .userLoginPage(email, pass);

        calllogin.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {

                LoginResponse loginResponse=response.body();
                if(loginResponse.getResponse().toString().equals("ok")){
                    SharedPrefManager.getInstance(LoginActivity.this).saveUser(loginResponse.getUsers());
                    Intent intent=new Intent(LoginActivity.this, ProfileActivity.class);

                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

                    startActivity(intent);
                    Toast.makeText(LoginActivity.this,"Login success",Toast.LENGTH_LONG).show();
                }
                Toast.makeText(LoginActivity.this,loginResponse.getUsers().getName(),Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {

            }
        });
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.loginBtn:
                userLogin();
                break;
            case R.id.registerScreen:
                startActivity(new Intent(this,MainActivity.class));
                break;
        }
    }
}
