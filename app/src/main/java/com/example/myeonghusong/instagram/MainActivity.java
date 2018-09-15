package com.example.myeonghusong.instagram;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButton1Clicked(View v)
    {
        TextView tv = (TextView)findViewById(R.id.textView);
        //tv.setText(getResources().getString(R.string.creator_name));
        tv.setText(R.string.creator_name);   //이 R은 무슨 의미지??

        Toast.makeText(getApplicationContext(), "버튼이 눌렸어요.", Toast.LENGTH_LONG).show();



    }

    public void onButton2Clicked(View v)
    {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://m.naver.com"));
        startActivity(intent);
    }

}
