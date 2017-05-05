package com.microsoft.projectoxford.emotionsample;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by waqar on 10/14/2016.
 */
public class Data_source {
    private static final String LOGTAG = "LOGTAG";
    SQLiteOpenHelper sqLiteOpenHelper;
    SQLiteDatabase sqLiteDatabase;
    String query="SELECT * FROM "+DB_helper.TABLE_NAME;

    Data_source(Context context){
        sqLiteOpenHelper=new DB_helper(context);

    }

    public void open(){
        sqLiteDatabase=sqLiteOpenHelper.getWritableDatabase();
        Log.d(LOGTAG,"Database opened");

    }

    public void close(){
        sqLiteOpenHelper.close();
        Log.d(LOGTAG,"Database closed");
    }

    public void insert(mysongs song_obj){
        ContentValues values=new ContentValues();
        values.put(DB_helper.SONG_NAME,song_obj.getName());
        values.put(DB_helper.MOOD,song_obj.getMood());
        values.put(DB_helper.GENRE,song_obj.getGenre());
        values.put(DB_helper.SONG_ID,song_obj.getSong_id());

        long insert=sqLiteDatabase.insert(DB_helper.TABLE_NAME,null,values);

    }

    public boolean check_table(){
        String count = "SELECT count(*) FROM "+DB_helper.TABLE_NAME;
        Cursor mcursor = sqLiteDatabase.rawQuery(count, null);
        mcursor.moveToFirst();
        int icount = mcursor.getInt(0);
        if(icount>0)
           return true;
        else
         return false;
    }



    public ArrayList<mysongs> getdata(String mood,String genre) {
        ArrayList<mysongs> list;
        list = new ArrayList<>();
        String myquery="SELECT * FROM "+DB_helper.TABLE_NAME+" WHERE "+DB_helper.MOOD+"="+"\""+mood+"\""+" AND "+DB_helper.GENRE+"="+"\""+genre+"\""+";";
        Log.d(LOGTAG,myquery);
        Cursor cursor = sqLiteDatabase.rawQuery(myquery, null);

        if (cursor.getCount() > 0) {
                while (cursor.moveToNext()) {

                mysongs temp_obj=new mysongs();
                temp_obj.setName(cursor.getString(cursor.getColumnIndex(DB_helper.SONG_NAME)));
                temp_obj.setMood(cursor.getString(cursor.getColumnIndex(DB_helper.MOOD)));
                temp_obj.setGenre(cursor.getString(cursor.getColumnIndex(DB_helper.GENRE)));
                temp_obj.setSong_id(cursor.getInt(cursor.getColumnIndex(DB_helper.SONG_ID)));
                list.add(temp_obj);
            }
        }
        return list;
    }

    public void showdata(){
        Cursor cursor = sqLiteDatabase.rawQuery(query, null);
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                Log.d(LOGTAG, (cursor.getString(cursor.getColumnIndex(DB_helper.SONG_NAME))).toString());
                Log.d(LOGTAG, (cursor.getString(cursor.getColumnIndex(DB_helper.MOOD))).toString());
                Log.d(LOGTAG, (cursor.getString(cursor.getColumnIndex(DB_helper.GENRE))).toString());
                Log.d(LOGTAG, String.valueOf(cursor.getInt(cursor.getColumnIndex(DB_helper.SONG_ID))));
            }
        }
    }


    public void delete(Context context){
        sqLiteDatabase.execSQL("Delete from "+ DB_helper.TABLE_NAME+";");
    }

}
