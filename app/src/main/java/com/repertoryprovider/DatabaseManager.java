package com.repertoryprovider;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseManager extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "bdrepertory.db";
    private static final int DATABASE_VERSION = 1;
    public DatabaseManager(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase database) {
        RepertoryTable.onCreate(database);
    }
    @Override
    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion
    ) {
        RepertoryTable.onUpgrade(database, oldVersion, newVersion);
    }
}
