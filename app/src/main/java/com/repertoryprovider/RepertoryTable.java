package com.repertoryprovider;

import android.database.sqlite.SQLiteDatabase;
import android.util.Log;



public class RepertoryTable {

    // Database table
    public static final String TABLE_NAME = "REPERTORY";
    static final String ID = "id";
    static final String NAME = "name";
    static final String NUMBER = "number";
    static final String CREATE_TABLE = " CREATE TABLE "
            + TABLE_NAME
            + " ( "
            + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + NAME + " TEXT NOT NULL, "
            + NUMBER + " TEXT NOT NULL"
            + ");";
    public static void onCreate(SQLiteDatabase database) {
        database.execSQL(CREATE_TABLE);
    }
    public static void onUpgrade(SQLiteDatabase database, int oldVersion,

                                 int newVersion) {

        Log.w(RepertoryTable.class.getName(), "Upgrading database from version "
                + oldVersion + " to " + newVersion
                + ", which will destroy all old data");
        database.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(database);
    }
}
