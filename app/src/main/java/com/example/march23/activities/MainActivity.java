package com.example.march23.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.march23.models.DefaultResponse;
import com.example.march23.R;
import com.example.march23.api.RetrofitClient;
import com.example.march23.storage.SharedPrefManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText editEmail,editPassowrd,editName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editName=findViewById(R.id.editText1);
        editEmail=findViewById(R.id.editText2);
        editPassowrd=findViewById(R.id.editText3);
        findViewById(R.id.button).setOnClickListener(this);

        findViewById(R.id.login).setOnClickListener(this);
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

    private void userSignUp(){
        String u_name=editName.getText().toString().trim();
        String u_email=editEmail.getText().toString().trim();
        String u_password=editPassowrd.getText().toString().trim();

        Call<DefaultResponse> calls= RetrofitClient
                .getInstance()
                .getApi()
                .createUserPage(u_name,u_email,u_password);

   calls.enqueue(new Callback<DefaultResponse>() {
       @Override
       public void onResponse(Call<DefaultResponse> call, Response<DefaultResponse> response) {
          DefaultResponse rs= response.body();
          Toast.makeText(MainActivity.this,rs.getResp(), Toast.LENGTH_LONG).show();
       }

       @Override
       public void onFailure(Call<DefaultResponse> call, Throwable t) {

       }
   });
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button:
                userSignUp();
                break;
            case R.id.login:
                startActivity(new Intent(this,LoginActivity.class));
                break;
        }

    }
}
