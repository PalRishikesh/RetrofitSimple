package com.example.march23.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.march23.R;
import com.example.march23.adapter.UsersApdapter;
import com.example.march23.api.RetrofitClient;
import com.example.march23.models.Users;
import com.example.march23.models.UsersAllResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserFragment extends Fragment {
    private RecyclerView recyclerView;
    private List<Users> usersList;
    private UsersApdapter adpater;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.user_fragment,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView=view.findViewById(R.id.recyleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        Call<UsersAllResponse> call= RetrofitClient.getInstance().getApi().getUsersinfo();

        call.enqueue(new Callback<UsersAllResponse>() {
            @Override
            public void onResponse(Call<UsersAllResponse> call, Response<UsersAllResponse> response) {
                usersList=response.body().getUsers();
                adpater=new UsersApdapter(getActivity(),usersList);
                recyclerView.setAdapter(adpater);
            }

            @Override
            public void onFailure(Call<UsersAllResponse> call, Throwable t) {

            }
        });
    }
}
