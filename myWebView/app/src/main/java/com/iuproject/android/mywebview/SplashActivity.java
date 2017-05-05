package com.iuproject.android.mywebview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by waqar on 1/13/2017.
 */
public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mylayout);
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}