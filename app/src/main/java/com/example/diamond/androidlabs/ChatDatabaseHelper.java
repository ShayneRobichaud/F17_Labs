/*package com.example.diamond.androidlabs;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Diamond on 04/01/2018.


public class ChatDatabaseHelper extends SQLiteOpenHelper {
    static String DATABASE_NAME = "db1";
    static int VERSION_NUM = 1;
    final static String id = "KEY_ID", message = "KEY_MESSAGE";
    SQLiteDatabase db;
    public ChatDatabaseHelper(Context ctx){
        super(ctx, DATABASE_NAME, null, VERSION_NUM);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql =    "CREATE TABLE messages ( " +
                        id + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                        message + " VARCHAR2(30) )";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVer, int newVer) {
        db.execSQL("DROP TABLE IF EXISTS messages");
        onCreate(db);
    }
    public void setDB(SQLiteDatabase db){
        this.db = db;
    }
}
*/