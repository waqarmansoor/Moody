package com.microsoft.projectoxford.emotionsample;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Selector extends ActionBarActivity {

    public static final String MOOD = "mood";
    public static final String GENRE = "genre";
    Intent intent;
    Intent songs;
    Intent feedback;
    String mood;
    TextView t_mood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selector);
        intent= getIntent();
        t_mood= (TextView) findViewById(R.id.mood);
        mood=intent.getStringExtra(RecognizeActivity.MOOD);
        //mood="hi";
        t_mood.setText(mood);

    }

    public void bollywood(View view) {
        songs=new Intent(this,songs.class);
        songs.putExtra(MOOD,mood.toLowerCase());
        songs.putExtra(GENRE,"bollywood");
        startActivity(songs);


    }

    public void random(View view) {
        songs=new Intent(this,songs.class);
        songs.putExtra(MOOD,mood.toLowerCase());
        songs.putExtra(GENRE,"random");
        startActivity(songs);

    }

    public void hollywood(View view) {
        songs=new Intent(this,songs.class);
        songs.putExtra(MOOD,mood.toLowerCase());
        songs.putExtra(GENRE,"hollywood");
        startActivity(songs);
    }

    public void feedback(View view) {
        feedback=new Intent(this,feedback.class);
        startActivity(feedback);
    }
}
