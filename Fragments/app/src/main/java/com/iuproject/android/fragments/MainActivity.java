package com.iuproject.android.fragments;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

   protected String mystr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        getFragmentManager().beginTransaction().add(R.id.frame,new Fragment1()).commit();

//        switchFragment(new Fragment1());
//        findViewById(R.id.frag1).setOnClickListener(this);
//        findViewById(R.id.frag2).setOnClickListener(this);
    }

//    @Override
//    public void onClick(View v) {
//        int id=v.getId();
//
//        if(id==R.id.frag1){
//            switchFragment(new Fragment1());
//        }else if(id==R.id.frag2){
//            switchFragment(new Fragment2());
//        }
//
//    }
//
//    public void switchFragment(Fragment fragment) {
//        getFragmentManager().beginTransaction().replace(R.id.frame,fragment).commit();
//    }


}
