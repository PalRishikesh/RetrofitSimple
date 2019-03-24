package com.example.march23.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.march23.R;
import com.example.march23.models.Users;

import java.util.List;

public class UsersApdapter extends RecyclerView.Adapter<UsersApdapter.UserViewHolder> {

    private Context mCts;
    private List<Users> usersList;

    public UsersApdapter(Context mCts, List<Users> usersList) {
        this.mCts = mCts;
        this.usersList = usersList;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
       View view= LayoutInflater.from(mCts).inflate(R.layout.recyclerview_users,viewGroup,false);
       return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder userViewHolder, int i) {
        Users users=usersList.get(i);
        userViewHolder.textViewnName.setText(users.getName());
        userViewHolder.textViewEmail.setText(users.getEmail());

    }

    @Override
    public int getItemCount() {
        return usersList.size();
    }

    class UserViewHolder extends RecyclerView.ViewHolder{
        TextView textViewnName,textViewEmail;


        public UserViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewnName=itemView.findViewById(R.id.textRName);
            textViewEmail=itemView.findViewById(R.id.textREmail);
        }
    }
}
