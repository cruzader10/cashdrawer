package com.example.virtualcashdrawer;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyDatabaseHelper extends SQLiteOpenHelper {
    private Context context;
    private static final String DATABASE_NAME = "cashdrawer.db";
    private static final int DATABASE_VERSION =1;
    private static final String TABLE_NAME="drawer";
    private static final String TABLE_NAME2 ="users";
    private static final  String COL_USERID ="_id";
    private static  final String COL_USERNAME = "_username";
    private static final String TABLE_NAME3 ="currency";
    private static final String COL_CURRENCYID="_id";
    private static final String COL_CURRENCY="_currency";
    private static final String COL_ID="_id";
    private static final String COL_CODE="_drawercode";
    private static final String COL_1000="_col1000";
    private static final String COL_500="_col500";
    private static final String COL_200="_col200";
    private static final String COL_100="_col100";
    private static final String COL_50="_col50";
    private static final String COL_20bill="_col20bill";
    private static final String COL_20coin="_col20coin";
    private static final String COL_10="_col10";
    private static final String COL_5="_col5";
    private static final String COL_1="_col1";

    private static String query="";
    public MyDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        query="CREATE TABLE " + TABLE_NAME +
                " (" + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_CODE + " TEXT, " + COL_1000 + " INTEGER, " +
                COL_500 + " INTEGER, " +
                COL_200 + " INTEGER, " +
                COL_100 + " INTEGER, " +
                COL_50 + " INTEGER, " +
                COL_20bill + " INTEGER, " +
                COL_20coin + " INTEGER, " +
                COL_10 + " INTEGER, " +
                COL_5 + " INTEGER, " +
                COL_1 + " INTEGER) ;";

        db.execSQL(query);

        query="INSERT INTO " + TABLE_NAME +
        		"( " + COL_CODE +
        		", " + COL_1000 + 
        		", " + COL_500 +
        		", " + COL_200 +
        		", " + COL_100 +
        		", " + COL_50 +
        		", " + COL_20bill +
        		", " + COL_20coin +
        		", " + COL_10 +
        		", " + COL_5 +        		
        		", " + COL_1 +
        		") VALUES ('0',0,0,0,0,0,0,0,0,0,0),('1',0,0,0,0,0,0,0,0,0,0),('2',0,0,0,0,0,0,0,0,0,0),('3',0,0,0,0,0,0,0,0,0,0);";
        db.execSQL(query);

        query="CREATE TABLE " + TABLE_NAME2 +
                " (" + COL_USERID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_USERNAME + " TEXT);";

        db.execSQL(query);

        query="INSERT INTO " + TABLE_NAME2 +
                "( " + COL_USERNAME +
                ") VALUES ('Drawer 1'),('Drawer 2'),('Drawer 3'),('Total');";
        db.execSQL(query);

        query="CREATE TABLE " + TABLE_NAME3 +
                " (" + COL_CURRENCYID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_CURRENCY + " TEXT);";

        db.execSQL(query);

        query="INSERT INTO " + TABLE_NAME3 +
                "( " + COL_CURRENCY +
                ") VALUES ('₱'),('$'),('€'),('£');";
        db.execSQL(query);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
    public Cursor getdata (){

        SQLiteDatabase db = this.getReadableDatabase();
        String query = "select * from " + TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);
        return cursor;
    }

    public Cursor getSpecificData (String newItem1){

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from " + TABLE_NAME + " where _drawercode = ? ", new String[]{newItem1});
        return cursor;

    }
    public Cursor getTotal (){

        SQLiteDatabase db = this.getReadableDatabase();
        //String query = "select _drawercode,sum(_col1000),sum(_col500),sum(_col200),sum(_col100),sum(_col50),sum(_col20bill),sum(_col20coin),sum(_col10),sum(_col5),sum(_col1) from " + TABLE_NAME;
        String query = "select * from " + TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);
        return cursor;

    }
    public Cursor getUsers (){

        SQLiteDatabase db = this.getReadableDatabase();
        String query = "select * from " + TABLE_NAME2;
        Cursor cursor = db.rawQuery(query, null);
        return cursor;

    }

    void updateData(String username, int num1000, int num500, int num200, int num100, int num50, int num20bills, int num20coins, int num10, int num5, int num1){
        if (username.equals("3")){

        }else{
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues cv = new ContentValues();
            cv.put(COL_1000, num1000);
            cv.put(COL_500, num500);
            cv.put(COL_200, num200);
            cv.put(COL_100, num100);
            cv.put(COL_50, num50);
            cv.put(COL_20bill, num20bills);
            cv.put(COL_20coin, num20coins);
            cv.put(COL_10, num10);
            cv.put(COL_5, num5);
            cv.put(COL_1, num1);
            long result = db.update(TABLE_NAME, cv, "_drawercode=?", new String[]{username});

            if (result == -1){
                Toast.makeText(context, "Unknown Error", Toast.LENGTH_SHORT).show();
            }else{

            }
        }



    }
    void updateUser(String username1, String username2, String username3, String username4){
            int counter1=1;
            do{
                SQLiteDatabase db = this.getWritableDatabase();
                ContentValues cv = new ContentValues();

                if (counter1 == 1) {
                    cv.put(COL_USERNAME, username1);
                    long result = db.update(TABLE_NAME2, cv, "_id=?", new String[]{Integer.valueOf(counter1).toString().trim()});
                    if (result == -1){
                        Toast.makeText(context, "Unknown Error", Toast.LENGTH_SHORT).show();
                    }else{

                    }
                } else if (counter1==2) {
                    cv.put(COL_USERNAME, username2);
                    long result = db.update(TABLE_NAME2, cv, "_id=?", new String[]{Integer.valueOf(counter1).toString().trim()});
                    if (result == -1){
                        Toast.makeText(context, "Unknown Error", Toast.LENGTH_SHORT).show();
                    }else{

                    }
                } else if (counter1==3) {
                    cv.put(COL_USERNAME, username3);
                    long result = db.update(TABLE_NAME2, cv, "_id=?", new String[]{Integer.valueOf(counter1).toString().trim()});
                    if (result == -1){
                        Toast.makeText(context, "Unknown Error", Toast.LENGTH_SHORT).show();
                    }else{

                    }
                } else if (counter1==4) {
                    cv.put(COL_USERNAME, username4);
                    long result = db.update(TABLE_NAME2, cv, "_id=?", new String[]{Integer.valueOf(counter1).toString().trim()});
                    if (result == -1){
                        Toast.makeText(context, "Unknown Error", Toast.LENGTH_SHORT).show();
                    }else{

                    }
                }

                counter1 = counter1+1;
            }while(counter1<4);

    }


}
