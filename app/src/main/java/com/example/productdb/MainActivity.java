package com.example.productdb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText pname, pdesc, price, pcat;
    Button btnAdd, btnView;
    DBHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbHelper = new DBHelper(this);

        //get all the views
        pname = findViewById(R.id.txtPName);
        pdesc = findViewById(R.id.txtPdesc);
        price = findViewById(R.id.txtPrice);
        pcat = findViewById(R.id.txtCat);
        btnAdd = findViewById(R.id.btnAdd);
        btnView = findViewById(R.id.btnView);

        btnAdd.setOnClickListener(v->{
            String name = pname.getText().toString();
            String desc = pdesc.getText().toString();
            double dprice = Double.parseDouble(price.getText().toString());
            int category = Integer.parseInt(pcat.getText().toString());
            dbHelper.addRecord(name, desc, dprice, category);

            pname.setText("");
            pdesc.setText("");
            price.setText("");
            pcat.setText("");
        });

        btnView.setOnClickListener(v->{
            Intent intent = new Intent(this, DisplayAllRecords.class);
            startActivity(intent);
        });
    }
}