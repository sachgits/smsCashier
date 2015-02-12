package com.sach.gits.storage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by sach on 2/12/2015.
 */
public class StoresRecord {
    private SQLiteDatabase readSQLitedatabase;
    private SQLiteDatabase writeSQLitedatabase;

    public StoresRecord(Context context){
        StoresDbHelper dbHelper = new StoresDbHelper(context);
        readSQLitedatabase = dbHelper.getReadableDatabase();
        writeSQLitedatabase = dbHelper.getWritableDatabase();
    }
    public long storehalfRecord(String phonenumber,String datetime,float amount,int record_type){
        ContentValues values = baselineContents(phonenumber,datetime,amount);
        return writeSQLitedatabase.insert(Stores.TABLE_NAME,null,values);
    }

    public long storeFullRecord(String phonenumber,String datetime,Float amount,String fullnames,String confirmationcode){
        ContentValues values = mpesaContentValues(phonenumber,datetime,amount,fullnames,confirmationcode);
        return writeSQLitedatabase.insert(Stores.TABLE_NAME,null,values);
    }

    public ContentValues baselineContents(String phonenumber,String datetime, Float amount){
        ContentValues baselineContentsValues = new ContentValues();
        baselineContentsValues.put(Stores.TABLE_COLUMNS.PHONE_NUMBER, phonenumber);
        baselineContentsValues.put(Stores.TABLE_COLUMNS.DATE_TIME, datetime);
        baselineContentsValues.put(Stores.TABLE_COLUMNS.AMOUNT, amount);
        baselineContentsValues.put(Stores.TABLE_COLUMNS.RECORD_TYPE, Stores.CREDO2MPESA_RECORD_TYPE);
        return baselineContentsValues;
    }
    public ContentValues mpesaContentValues(String phonenumber,String datetime,Float amount,
                                            String fullnames,String confirmationcode){
        ContentValues mpesaContentsValues = new ContentValues();
        mpesaContentsValues.put(Stores.TABLE_COLUMNS.FULL_NAMES, fullnames);
        mpesaContentsValues.put(Stores.TABLE_COLUMNS.CONFIRMATION_CODE,confirmationcode);
        mpesaContentsValues.putAll(baselineContents(phonenumber, datetime, amount));
        mpesaContentsValues.remove(Stores.TABLE_COLUMNS.RECORD_TYPE);
        mpesaContentsValues.put(Stores.TABLE_COLUMNS.RECORD_TYPE, Stores.MPESA2CREDO_RECORD_TYPE);//should be mpesa2credo_recordupdate
        return mpesaContentsValues;
    }

    public long updateRecordWithMpesa(String fullnames,String confirmationcode,String phonenumber,float amount){
        return 1L;
    }
    public long updateRecordWithCredo(String phonenumber,float amount){
        return 0L;
    }

    public Cursor readRecordsWithPhoneNumbers(String[] phonenumbers){
        return null;
    }

    public Cursor readRecordsOfCertainDate(String[] datetime){
        return null;
    }

    public Cursor readRecordsOfCertainAmount(float[] amounts){
        return null;
    }


}
