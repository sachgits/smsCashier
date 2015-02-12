package com.sach.gits.storage;

import android.provider.BaseColumns;

/**
 * Created by sach on 2/9/2015.
 * nessesary class for storage on everything waiting for outcome or for later processing of extracted sms monthly sales
 * Total sales can store localy or online
 */
public class Stores {

    public static abstract class TABLE_COLUMNS implements BaseColumns{
        public static String PHONE_NUMBER = "phonenumber";
        public static String DATE_TIME = "datetime";
        public static String AMOUNT = "amount";
        public static String CONFIRMATION_CODE = "confirmation";
        public static String FULL_NAMES = "fullnames";
        public static String RECORD_TYPE = "typerecord";//tries to know which type of record we are in Mpesa2Credo or Credo2Mpesa
    }

    public static String TABLE_NAME = "SmsCashierTable";
    public static int CREDO2MPESA_RECORD_TYPE = 0;
    public static int MPESA2CREDO_RECORD_TYPE = 1;

    //more record types to come soon like imcomplete transactions record types

    public static final String CREATE_SmsCashier_TABLE = "CREATE TABLE " +TABLE_NAME + " ( " +
            TABLE_COLUMNS._ID +" INT NOT NULL, " + TABLE_COLUMNS.PHONE_NUMBER + " VARCHAR(10) NOT NULL, " +
            TABLE_COLUMNS.DATE_TIME + " INT NOT NULL, " + TABLE_COLUMNS.AMOUNT + " FLOAT NOT NULL, " +
            TABLE_COLUMNS.RECORD_TYPE + " INT NOT NULL, " + TABLE_COLUMNS.FULL_NAMES + " VARCHAR(45) NULL, " +
            TABLE_COLUMNS.CONFIRMATION_CODE + "VARCHAR(15) NULL )";

    public static final String DELETE_SmsCashier_TABLE = "DROP IF EXISTS " + TABLE_NAME;

}
