package com.example.myeonghusong.instagram;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class ShowActivity extends AppCompatActivity {

    Intent intent;
    String name;
    TextView tv;

    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        tv = findViewById(R.id.name_TextView);

        intent = getIntent();
        name = intent.getStringExtra("ID");
        Log.v("test", "why not : " + name);
        tv.setText(name);


        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.contents, new MainFragment());
        fragmentTransaction.commit();



    }


    public void ChangeFragment( View v )
    {
        Fragment fragment;
        Log.v("aaaa", "wwwwwwwwwwwwwwwww"+ v.getId());
        switch( v.getId())
        {
            default:
            case R.id.home:{
                fragment = new MainFragment();
                break;
            }
            case R.id.feed:{
                fragment = new FeedFragment();
                break;
            }
        }

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.contents, fragment);
        fragmentTransaction.commit();

    }


}
