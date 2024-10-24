package com.example.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDatabase extends SQLiteOpenHelper {
    public MyDatabase(Context context){
        super(context,"Login.db",null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table USERS(ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME text, SURNAME text, MARKS INTEGER)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS USERS");
    }
    public Cursor getAllData() {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res = db.rawQuery("Select * from USERS",null);
        return res;
    }


    public Boolean insertdata(String userVal, Integer passVal, String surnameVal) {
        SQLiteDatabase db = this.getWritableDatabase();
        //db.execSQL("DROP TABLE USERS");
        //db.execSQL("Create table USERS(ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME text,SURNAME text,MARKS INTEGER)");
        ContentValues contentValues = new ContentValues();
        contentValues.put("NAME", userVal);
        contentValues.put("SURNAME", surnameVal);
        contentValues.put("MARKS", passVal);
        long result = db.insert("USERS", null, contentValues);
        db.close();
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

}
