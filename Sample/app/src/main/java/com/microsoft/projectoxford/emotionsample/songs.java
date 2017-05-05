package com.microsoft.projectoxford.emotionsample;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.File;
import java.util.ArrayList;

public class songs extends ActionBarActivity {
    Intent intent;
    String mood;
    String genre;
    mysongs temp_obj;

    ListView songs;
    ArrayAdapter<mysongs> adapter;
    ArrayList<mysongs> mylist;
    MediaPlayer mPlayer2;

    Data_source data_source;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_songs);
        data_source=new Data_source(this);
        intent=getIntent();
        mood=intent.getStringExtra(Selector.MOOD);
        genre=intent.getStringExtra(Selector.GENRE);
        mylist=new ArrayList<>();
        populateList(mood,genre);

        songs= (ListView) findViewById(R.id.songs);





        adapter=new ArrayAdapter(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, mylist);
        songs.setAdapter(adapter);

        songs.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView parent, View v, int position, long id){
                temp_obj = new mysongs();
                temp_obj=mylist.get(position);
                play(temp_obj.getSong_id());

            }
        });




    }

    public void play(int id) {
        if(mPlayer2==null){
            mPlayer2= MediaPlayer.create(this, id);
            mPlayer2.start();
        }else{
            mPlayer2.stop();
            mPlayer2.release();
            mPlayer2 = null;
        }
    }

    public void populateList(String mood,String genre) {
        data_source.open();
        mylist=data_source.getdata(mood,genre);
        data_source.showdata();
        data_source.close();
    }

    @Override
    public void onPause() {
        super.onPause();  // Always call the superclass method first
        if(mPlayer2!=null){
            mPlayer2.stop();
            mPlayer2.release();
            mPlayer2 = null;
        }
        finish();
    }



}
