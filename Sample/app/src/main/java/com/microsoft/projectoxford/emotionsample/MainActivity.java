//
// Copyright (c) Microsoft. All rights reserved.
// Licensed under the MIT license.
//
// Microsoft Cognitive Services (formerly Project Oxford): https://www.microsoft.com/cognitive-services
//
// Microsoft Cognitive Services (formerly Project Oxford) GitHub:
// https://github.com/Microsoft/Cognitive-Emotion-Android
//
// Copyright (c) Microsoft Corporation
// All rights reserved.
//
// MIT License:
// Permission is hereby granted, free of charge, to any person obtaining
// a copy of this software and associated documentation files (the
// "Software"), to deal in the Software without restriction, including
// without limitation the rights to use, copy, modify, merge, publish,
// distribute, sublicense, and/or sell copies of the Software, and to
// permit persons to whom the Software is furnished to do so, subject to
// the following conditions:
//
// The above copyright notice and this permission notice shall be
// included in all copies or substantial portions of the Software.
//
// THE SOFTWARE IS PROVIDED ""AS IS"", WITHOUT WARRANTY OF ANY KIND,
// EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
// MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
// NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
// LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
// OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
// WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
//
package com.microsoft.projectoxford.emotionsample;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.File;
import java.util.ArrayList;



import android.content.Intent;
import android.os.AsyncTask;
import android.os.Environment;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.File;
import java.util.ArrayList;

public class MainActivity extends Activity {

    public static final String LOGTAG="LOGTAG";
    ProgressBar progressBar;
    TextView loading_text;
    Intent fountain;
    Data_source datasource;
    static ArrayList<mysongs> list;

    static{
        list=new ArrayList<>();
        list.add(new mysongs("Happy1","happiness","bollywood",R.raw.fear));
        list.add(new mysongs("Happy2","happiness","hollywood",R.raw.fear));
        list.add(new mysongs("Happy3","happiness","random",R.raw.fear));

        list.add(new mysongs("Anger1","anger","bollywood",R.raw.fear));
        list.add(new mysongs("Anger2","anger","hollywood",R.raw.fear));
        list.add(new mysongs("Anger3","anger","random",R.raw.fear));

        list.add(new mysongs("Neutral1","neutral","bollywood",R.raw.m04));
        list.add(new mysongs("Neutral_Song","neutral","bollywood",R.raw.m04));
        list.add(new mysongs("Neutral2","neutral","hollywood",R.raw.m04));
        list.add(new mysongs("Neutral3","neutral","random",R.raw.fear));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loading_text= (TextView) findViewById(R.id.loading);
        fountain = new Intent(this,RecognizeActivity.class);
        insertsongs();

        new MyTask().execute();
    }



    public class MyTask extends AsyncTask<String,Integer,String> {


        @Override
        protected String doInBackground(String... params) {
            for(int i=0;i<20;i++){
                publishProgress(5);
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onPreExecute() {
            progressBar= (ProgressBar) findViewById(R.id.progressBar);
            progressBar.setMax(100);

            progressBar.setVisibility(View.VISIBLE);
            super.onPreExecute();
        }

        @Override
        protected void onProgressUpdate(Integer...progress) {
            progressBar.incrementProgressBy(progress[0]);
            super.onProgressUpdate(progress);
        }

        @Override
        protected void onPostExecute(String s) {
            startActivity(fountain);
            progressBar.setVisibility(View.GONE);
            loading_text.setVisibility(View.GONE);
            super.onPostExecute(s);
        }
    }


    public void insertsongs() {

        datasource=new Data_source(this);
        datasource.open();
        boolean mytable=datasource.check_table();
        if(!mytable){
            for(int i=0;i<list.size();i++){
                datasource.insert(list.get(i));
            }
            datasource.close();
        }else{
            Log.d(LOGTAG,"Already Exists");
        }
    }


    @Override
    public void onPause() {
        super.onPause();  // Always call the superclass method first
        finish();
    }
}
