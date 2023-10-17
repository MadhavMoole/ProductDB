package com.example.productdb;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.List;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "ProductsDB";
    private static final int VERSION = 1;

    public DBHelper(Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //create a table
        String create_query = "CREATE TABLE product(id integer PRIMARY KEY autoincrement, pname text, pdesc text, price numeric, pcat integer)";
        db.execSQL(create_query);
    }

    public void addRecord(String pname, String pdesc, double price, int pcat) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cr = new ContentValues();
        cr.put("pname", pname);
        cr.put("pdesc", pdesc);
        cr.put("price", price);
        cr.put("pcat", pcat);
        db.insert("product", null, cr);
        db.close();
    }

    public Cursor getData() {
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "SELECT * FROM product";
        Cursor cursor = db.rawQuery(sql, null);
        return cursor;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


}
