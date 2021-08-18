package com.example.vxhelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Datahelper extends SQLiteOpenHelper {
    private final static String DATABASE_NAME = "on_key.db";
    private final static int DATABASE_VERSION = 1;
    private Context mContext;


    public static final String CREATE_BOOK = "create table UserList ("
            + "id integer primary key autoincrement, "
            + "username text, "
            + "photo integer, "
            + "video integer, "
            + "image blob )";


    public Datahelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        mContext = context;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
