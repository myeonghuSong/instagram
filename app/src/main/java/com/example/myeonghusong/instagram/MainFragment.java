package com.example.myeonghusong.instagram;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by myeonghusong on 2018. 9. 29..
 */

public class MainFragment extends Fragment {

    private TextView textView;
    private Retrofit retrofit;
    private GitHubService gitHubService;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.mainfragment, null);
        textView = (TextView)view.findViewById(R.id.textView);


        retrofit = new Retrofit.Builder().baseUrl("https://api.github.com").addConverterFactory(GsonConverterFactory.create()).build();

        gitHubService = retrofit.create(GitHubService.class);

        getDatas();

        return view;
    }

    public void getDatas()
    {
        Call<User> call = gitHubService.getRepos("meansoup");

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if(response.isSuccessful() && response.body() != null) {
                    String str = "response code: " + response.code() + "\n ID: " + response.body().login + "\n URL: " + response.body().html_url;
                    textView.setText(str);
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.e("Not Response", t.getLocalizedMessage());
            }
        });
    }
}
