package com.example.virtualcashdrawer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Settings extends AppCompatActivity {

    private Button btnSave,btnSettings;
    private EditText edtDrawer1,edtDrawer2,edtDrawer3,edtDrawer4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        btnSave = (Button) findViewById(R.id.btnSave);
        btnSettings = (Button) findViewById(R.id.btnSettings);
        edtDrawer1 = (EditText) findViewById(R.id.edtDrawer1);
        edtDrawer2 = (EditText) findViewById(R.id.edtDrawer2);
        edtDrawer3 = (EditText) findViewById(R.id.edtDrawer3);
        edtDrawer4 = (EditText) findViewById(R.id.edtDrawer4);
        MyDatabaseHelper myDB = new MyDatabaseHelper(Settings.this);
        Cursor res5 = myDB.getUsers();
        res5.moveToFirst();
        edtDrawer1.setText(res5.getString(1).toString().trim());
        res5.moveToNext();
        edtDrawer2.setText(res5.getString(1).toString().trim());
        res5.moveToNext();
        edtDrawer3.setText(res5.getString(1).toString().trim());
        res5.moveToNext();
        edtDrawer4.setText(res5.getString(1).toString().trim());

        btnSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Settings.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDB.updateUser(edtDrawer1.getText().toString().trim(),edtDrawer2.getText().toString().trim(), edtDrawer3.getText().toString().trim(),edtDrawer4.getText().toString().trim());

                Intent intent = new Intent(Settings.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}