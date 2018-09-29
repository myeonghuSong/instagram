package com.example.myeonghusong.instagram;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * Created by myeonghusong on 2018. 9. 30..
 */

public class FeedFragment extends Fragment {

    TextView textView;

    @Override
    public void onCreate(Bundle savedInstanceState )
    {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.feedfragment, null);
        textView = (TextView)view.findViewById(R.id.textView2);
        return view;
    }
}
