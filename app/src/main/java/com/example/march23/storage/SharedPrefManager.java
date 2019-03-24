package com.example.march23.storage;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.march23.models.Users;

public class SharedPrefManager {
    private static final String SHARE_PREF_NAME = "my_shared_preff";

    private static SharedPrefManager mInstance;

    //To handle Share Prefernce
    private Context mCtx;

    private SharedPrefManager(Context mCtx) {
        this.mCtx = mCtx;
    }


    public static synchronized SharedPrefManager getInstance(Context mCtx) {
        if (mInstance == null) {
            mInstance = new SharedPrefManager(mCtx);

        }
        return mInstance;
    }

    public void saveUser(Users users) {

        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARE_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putInt("id", users.getId());
        editor.putString("email", users.getEmail());
        editor.putString("name", users.getName());
        editor.apply();
    }

    public boolean isLoggedIn() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARE_PREF_NAME, Context.MODE_PRIVATE);
//        if(sharedPreferences.getInt("id",-1) !=-1){
//            return true;
//        }
//        return false;

        return sharedPreferences.getInt("id", -1) != -1;

    }

    public Users getUserss() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARE_PREF_NAME, Context.MODE_PRIVATE);
        Users users = new Users(
                sharedPreferences.getInt("id", -1),
                sharedPreferences.getString("email", null),
                sharedPreferences.getString("name", null)
        );
        return users;

    }
    public void clar(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARE_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }
}

