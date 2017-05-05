package com.iuproject.android.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by waqar on 1/15/2017.
 */
public class Fragment1 extends Fragment {

    public static final String LOGTAG="LOGTAG";


    public Fragment1(){
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(LOGTAG,"Fragment 1");
        getChildFragmentManager().beginTransaction().add(R.id.frame2,new Fragment2()).commit();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment1,container,false);
    }
}
