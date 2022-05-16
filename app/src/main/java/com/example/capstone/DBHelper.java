package com.example.capstone;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper (Context context){
        super (context, "timerdatabase.db",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table TimerData(id int , timervalue INT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists TimerData");
    }

    public Boolean insertTimerData (int value){
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("id",1);
        contentValues.put("timervalue",value);

        long result = DB.insert("TimerData",null,contentValues);

        if (result == -1){
            return false;
        }
        else {
            return true;
        }
    }

    public Boolean updateTimerData (int value){
        String id = "1";
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("timervalue",value);

        long result = DB.update("TimerData",contentValues,"id=?", new String [] {id});

        if (result == -1){
            return false;
        }
        else {
            return true;
        }
    }

    public int getTimerData () {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select timervalue from TimerData where id=?", new String[] {"1"});
        int timerData = 0;
        if (cursor.moveToFirst()) {
           timerData = cursor.getInt(0);
        }
        cursor.close();
        return timerData;
    }
}