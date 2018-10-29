package com.example.myeonghusong.instagram;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;


public class ShowActivity extends AppCompatActivity {

    Intent intent;
    String name;
    TextView tv;
    Toolbar myToolbar;

    private Fragment feedFragment;
    private Fragment mainFragment;
    private Fragment userFragmennt;
    private Fragment activeFragment;

    private final FragmentManager fm = getSupportFragmentManager();

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        myToolbar = (Toolbar)findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_launcher_foreground);


        tv = findViewById(R.id.name_TextView);


        intent = getIntent();
        name = intent.getStringExtra("ID");
        Log.v("test", "why not : " + name);
        tv.setText(name);


        getSupportActionBar().setTitle(name+"님의 Instagram");


        setArguments();
        initializeFragments();

        findView();
        setBottomNavigationView();

        bottomNavigationView.setSelectedItemId(R.id.nav_bottom_home);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.back_button:
                Toast.makeText(getApplicationContext(), "뒤로가기 클릭 됨", Toast.LENGTH_LONG).show();
                Intent intent2 = new Intent(ShowActivity.this, MainActivity.class);
                startActivity(intent2);

                return true;

            case R.id.settings:
                Toast.makeText(getApplicationContext(), "환경설정 버튼 클릭 됨", Toast.LENGTH_LONG).show();
                return true;

            case R.id.settings2:
                Intent intent3 = new Intent(ShowActivity.this, MainActivity.class);
                startActivity(intent3);

            default:
                Toast.makeText(getApplicationContext(), "나머지 버튼 클릭 됨", Toast.LENGTH_LONG).show();
                return super.onOptionsItemSelected(item);
        }
    }

    private void setArguments() { Log.v("test", "why not 2: " + name); }

    private void initializeFragments() {
        mainFragment = new MainFragment();
        feedFragment = new FeedFragment();
        userFragmennt = new UserFragment();

        fm.beginTransaction().add(R.id.contents, mainFragment).hide(mainFragment)
                .add(R.id.contents, feedFragment).hide(feedFragment).add(R.id.contents, userFragmennt).hide(userFragmennt).commit();
    }

    private void findView() { bottomNavigationView = findViewById(R.id.nav_bottom);}

    private void setBottomNavigationView() {
        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener()
                {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem menuitem) {
                        switch (menuitem.getItemId()) {
                            case R.id.nav_bottom_home:
                                setFragment(mainFragment);
                                return true;
                            case R.id.nav_bottom_feed:
                                setFragment(feedFragment);
                                return true;
                            case R.id.nav_bottom_upload:
                                onButtonClicked_Upload();
                                return true;
                            case R.id.nav_bottom_user:
                                setFragment(userFragmennt);
                                return true;
                        }
                        return false;
                    }
                });
    }

    private void setFragment(Fragment fragment)
    {
        FragmentTransaction transaction = fm.beginTransaction();
        if ( activeFragment != null )
            transaction.hide(activeFragment);
        transaction.show(fragment).commit();
        activeFragment = fragment;
    }


    public void onButtonClicked_Upload()
    {

        Intent intent3 = new Intent(ShowActivity.this, UploadActivity.class);
        startActivity(intent3);

    }
}
