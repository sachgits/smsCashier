package com.sach.gits.storage;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by sach on 2/12/2015.
 */
public class StoresDbHelper extends SQLiteOpenHelper{

    public static String DATABASE_NAME = "SmsCashier.db";
    public static int DATABASE_VERSION = 1;
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(Stores.CREATE_SmsCashier_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i2) {
        sqLiteDatabase.execSQL(Stores.DELETE_SmsCashier_TABLE);
        onCreate(sqLiteDatabase);
    }

    public StoresDbHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }


}
