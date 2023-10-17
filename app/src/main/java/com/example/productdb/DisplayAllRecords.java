package com.example.productdb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class DisplayAllRecords extends AppCompatActivity {
    ListView lstRecords;
    DBHelper hlp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_all_records);
        lstRecords = findViewById(R.id.lstRecords);
        hlp = new DBHelper(this);

        //execute the query..
        Cursor data = hlp.getData();
        ArrayList<Product> pdata = new ArrayList<>();
        ArrayAdapter<Product> adapter = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, pdata);
        do{
            data.moveToNext();
            pdata.add(new Product(data.getInt(0), data.getString(1), data.getString(2), data.getInt(3), data.getInt(4)));
        }while(!data.isLast());
        lstRecords.setAdapter(adapter);
    }
}