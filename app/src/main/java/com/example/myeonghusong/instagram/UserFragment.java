package com.example.myeonghusong.instagram;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by myeonghusong on 2018. 10. 29..
 */

public class UserFragment extends Fragment {

    private ImageView imageView;
    private String url;

    @Override
    public void onCreate(Bundle savedInstanceState )
    {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        ViewGroup view = (ViewGroup)inflater.inflate(R.layout.userfragment, container, false);

        imageView = view.findViewById(R.id.imageUrl);
        url = getResources().getString(R.string.url);
        Glide.with(this).load(url).into(imageView);

        return view;
    }
}
