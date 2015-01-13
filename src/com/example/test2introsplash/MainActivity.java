package com.example.test2introsplash;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        //문제점 : splash 화면이 나오기 전에 main 화면이 잠깐 보였다가 splash 화면이 보여짐.
        startActivity(new Intent(this, IntroSplashActivity.class));
        setContentView(R.layout.layout_main);
    }
}
