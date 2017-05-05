package com.microsoft.projectoxford.emotionsample;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by waqar on 10/14/2016.
 */
public class DB_helper extends SQLiteOpenHelper {

    public static final String TABLE_NAME = "songs";
    private static final String MOODY_DB = TABLE_NAME + "_DB";
    private static final int DB_VERSION =1;
    public static final String COL_ID = "COL_ID";
    public static final String SONG_NAME = "SONG_NAME";
    public static final String MOOD = "MOOD";
    public static final String GENRE = "GENRE";
    public static final String SONG_ID = "SONG_ID";

    private static final String CREATE_QUERY = "CREATE TABLE " + TABLE_NAME + "(" + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            SONG_NAME + " TEXT," +
            MOOD + " TEXT," +
            GENRE + " TEXT," +
            SONG_ID + " INTEGER"+ " );";
    public static final String LOGTAG = "LOGTAG";

    public DB_helper(Context context) {
        super(context, MOODY_DB, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_QUERY);
        Log.d(LOGTAG,"Table has been created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
        onCreate(db);

    }

}