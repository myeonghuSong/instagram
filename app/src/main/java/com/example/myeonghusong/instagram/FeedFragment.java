package com.example.myeonghusong.instagram;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * Created by myeonghusong on 2018. 9. 30..
 */

public class FeedFragment extends Fragment {

    //TextView textView;

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;


    @Override
    public void onCreate(Bundle savedInstanceState )
    {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        ViewGroup view = (ViewGroup)inflater.inflate(R.layout.feedfragment, container, false);
        //textView = (TextView)view.findViewById(R.id.textView2);


        Log.v("tt", "what?");
       // if(view instanceof RecyclerView)
       // {
            Log.v("aa", "seolma");
            Context context = view.getContext();
           // mRecyclerView  = (RecyclerView)view;

            mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);

            mRecyclerView.setHasFixedSize(true);

            mLayoutManager = new LinearLayoutManager(context);
            mRecyclerView.setLayoutManager(mLayoutManager);

            ArrayList<FoodInfo> foodInfoArrayList = new ArrayList<>();
            foodInfoArrayList.add(new FoodInfo(R.drawable.strawberry, "5,000원"));
            foodInfoArrayList.add(new FoodInfo(R.drawable.bread, "4600원"));
            foodInfoArrayList.add(new FoodInfo(R.drawable.noodle, "4000원"));
        foodInfoArrayList.add(new FoodInfo(R.drawable.strawberry, "5,000원"));
        foodInfoArrayList.add(new FoodInfo(R.drawable.bread, "4600원"));
        foodInfoArrayList.add(new FoodInfo(R.drawable.noodle, "4000원"));
        foodInfoArrayList.add(new FoodInfo(R.drawable.strawberry, "5,000원"));
        foodInfoArrayList.add(new FoodInfo(R.drawable.bread, "4600원"));
        foodInfoArrayList.add(new FoodInfo(R.drawable.noodle, "4000원"));


            mAdapter = new MyAdapter(foodInfoArrayList);

            mRecyclerView.setAdapter(mAdapter);
     //   }



        return view;
    }
}
