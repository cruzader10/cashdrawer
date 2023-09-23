package com.example.virtualcashdrawer;

import androidx.annotation.ColorInt;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.icu.text.DecimalFormat;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private EditText txt10001,txt5001,txt2001,txt1001,txt501;
    private EditText txt20bill1,txt20coin1,txt101,txt51,txt11;
    private TextView res10001,res5001,res2001,res1001,res501;
    private TextView res20bills1,res20coin1,res101,res51,res11;
    private TextView total;
    private TextView username;
    private Spinner drawer;
    private drawerAdapter adapter;
    private Button settings,btnClear,txt1000minus,txt500minus,txt200minus,txt100minus,txt50minus,txt20minus1,txt20minus,txt10minus,txt5minus,txt1minus,txt1000plus,txt500plus,txt200plus,txt100plus,txt50plus,txt20plus1,txt20plus,txt10plus,txt5plus,txt1plus;
    public String newItem1;
    public static int val1000, val500,val200,val100,val50,val20b,val20c,val10,val5,val1,totalamnt;
    DecimalFormat df = new DecimalFormat("Php ###,###.##");
    DecimalFormat df2 = new DecimalFormat("###,###.##");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner drawer = findViewById(R.id.spinner);
        MyDatabaseHelper myDB = new MyDatabaseHelper(MainActivity.this);
        Cursor res5 = myDB.getUsers();
        res5.moveToFirst();
        List<Drawer> drawerList = new ArrayList<>();
        Drawer Drawer1 = new Drawer();
        Drawer1.setName(res5.getString(1));
        drawerList.add(Drawer1);
        res5.moveToNext();
        Drawer Drawer2 = new Drawer();
        Drawer2.setName(res5.getString(1));
        drawerList.add(Drawer2);
        res5.moveToNext();
        Drawer Drawer3 = new Drawer();
        Drawer3.setName(res5.getString(1));
        drawerList.add(Drawer3);
        res5.moveToNext();
        Drawer Drawer4 = new Drawer();
        Drawer4.setName(res5.getString(1));
        drawerList.add(Drawer4);
        adapter = new drawerAdapter(MainActivity.this, drawerList);
        drawer.setAdapter(adapter);



        btnClear = (Button) findViewById(R.id.btnClear);
        txt1000minus = (Button) findViewById(R.id.txt1000minus);
        txt500minus = (Button) findViewById(R.id.txt500minus);
        txt200minus = (Button) findViewById(R.id.txt200minus);
        txt100minus = (Button) findViewById(R.id.txt100minus);
        txt50minus = (Button) findViewById(R.id.txt50minus);
        txt20minus1 = (Button) findViewById(R.id.txt20minus1);
        txt20minus = (Button) findViewById(R.id.txt20minus);
        txt10minus = (Button) findViewById(R.id.txt10minus);
        txt5minus = (Button) findViewById(R.id.txt5minus);
        txt1minus = (Button) findViewById(R.id.txt1minus);
        txt1000plus = (Button) findViewById(R.id.txt1000plus);
        txt500plus = (Button) findViewById(R.id.txt500plus);
        txt200plus = (Button) findViewById(R.id.txt200plus);
        txt100plus = (Button) findViewById(R.id.txt100plus);
        txt50plus = (Button) findViewById(R.id.txt50plus);
        txt20plus1 = (Button) findViewById(R.id.txt20plus1);
        txt20plus = (Button) findViewById(R.id.txt20plus);
        txt10plus = (Button) findViewById(R.id.txt10plus);
        txt5plus = (Button) findViewById(R.id.txt5plus);
        txt1plus = (Button) findViewById(R.id.txt1plus);
        settings = (Button) findViewById(R.id.settings);

        username =(TextView) findViewById(R.id.ProjectTitle) ;
        txt10001 = (EditText) findViewById(R.id.edt1000);
        res10001 = (TextView) findViewById(R.id.txt1000tot);
        txt5001 = (EditText) findViewById(R.id.edt500);
        res5001 = (TextView) findViewById(R.id.txt500tot);
        txt2001 = (EditText) findViewById(R.id.edt200);
        res2001 = (TextView) findViewById(R.id.txt200tot);
        txt1001 = (EditText) findViewById(R.id.edt100);
        res1001 = (TextView) findViewById(R.id.txt100tot);
        txt501 = (EditText) findViewById(R.id.edt50);
        res501 = (TextView) findViewById(R.id.txt50tot);
        txt20bill1 = (EditText) findViewById(R.id.edt20);
        res20bills1 = (TextView) findViewById(R.id.txt20tot);
        txt20coin1 = (EditText) findViewById(R.id.edt201);
        res20coin1 = (TextView) findViewById(R.id.txt20tot1);
        txt101 = (EditText) findViewById(R.id.edt10);
        res101 = (TextView) findViewById(R.id.txt10tot);
        txt51 = (EditText) findViewById(R.id.edt5);
        res51 = (TextView) findViewById(R.id.txt5tot);
        txt11 = (EditText) findViewById(R.id.edt1);
        res11 = (TextView) findViewById(R.id.txt1tot);
        total = (TextView) findViewById(R.id.total2);
        drawer.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String newItem = drawer.getSelectedItem().toString();
                //Toast.makeText(getApplicationContext(),"You selected: " + newItem, Toast.LENGTH_LONG).show();
                username.setText(newItem);
                if( username.getText().toString().trim().equals("3")){
                    Cursor res = myDB.getTotal();

                    int x1 = 0;
                    int x2 = 0;
                    int x3 = 0;
                    int x4 = 0;
                    int x5 = 0;
                    int x6 = 0;
                    int x7 = 0;
                    int x8 = 0;
                    int x9 = 0;
                    int x10 = 0;
                    if(res.moveToFirst()){

                        do{
                            x1 = x1 + Integer.valueOf(res.getString(2));
                            x2 = x2 + Integer.valueOf(res.getString(3));
                            x3 = x3 + Integer.valueOf(res.getString(4));
                            x4 = x4 + Integer.valueOf(res.getString(5));
                            x5 = x5 + Integer.valueOf(res.getString(6));
                            x6 = x6 + Integer.valueOf(res.getString(7));
                            x7 = x7 + Integer.valueOf(res.getString(8));
                            x8 = x8 + Integer.valueOf(res.getString(9));
                            x9 = x9 + Integer.valueOf(res.getString(10));
                            x10 = x10 + Integer.valueOf(res.getString(11));

                        }while(res.moveToNext());

                        txt10001.setText(Integer.valueOf(x1).toString());
                        txt5001.setText(Integer.valueOf(x2).toString());
                        txt2001.setText(Integer.valueOf(x3).toString());
                        txt1001.setText(Integer.valueOf(x4).toString());
                        txt501.setText(Integer.valueOf(x5).toString());
                        txt20bill1.setText(Integer.valueOf(x6).toString());
                        txt20coin1.setText(Integer.valueOf(x7).toString());
                        txt101.setText(Integer.valueOf(x8).toString());
                        txt51.setText(Integer.valueOf(x9).toString());
                        txt11.setText(Integer.valueOf(x10).toString());
                    }
                    res.close();
                    txt10001.setEnabled(false);
                    txt5001.setEnabled(false);
                    txt2001.setEnabled(false);
                    txt1001.setEnabled(false);
                    txt501.setEnabled(false);
                    txt20bill1.setEnabled(false);
                    txt20coin1.setEnabled(false);
                    txt101.setEnabled(false);
                    txt51.setEnabled(false);
                    txt11.setEnabled(false);
                    txt10001.setBackgroundColor(Color.YELLOW);
                    txt5001.setBackgroundColor(Color.YELLOW);
                    txt2001.setBackgroundColor(Color.YELLOW);
                    txt1001.setBackgroundColor(Color.YELLOW);
                    txt501.setBackgroundColor(Color.YELLOW);
                    txt20bill1.setBackgroundColor(Color.YELLOW);
                    txt20coin1.setBackgroundColor(Color.YELLOW);
                    txt101.setBackgroundColor(Color.YELLOW);
                    txt51.setBackgroundColor(Color.YELLOW);
                    txt11.setBackgroundColor(Color.YELLOW);


                }else{

                    Cursor res = myDB.getSpecificData(username.getText().toString().trim());
                    if (res.getCount() == 0){
                        Toast.makeText(MainActivity.this,"No Entry Exist", Toast.LENGTH_SHORT).show();
                        return;
                    }else{
                        while (res.moveToNext()){
                            txt10001.setText(Integer.valueOf(res.getString(2)).toString());
                            txt5001.setText(Integer.valueOf(res.getString(3)).toString());
                            txt2001.setText(Integer.valueOf(res.getString(4)).toString());
                            txt1001.setText(Integer.valueOf(res.getString(5)).toString());
                            txt501.setText(Integer.valueOf(res.getString(6)).toString());
                            txt20bill1.setText(Integer.valueOf(res.getString(7)).toString());
                            txt20coin1.setText(Integer.valueOf(res.getString(8)).toString());
                            txt101.setText(Integer.valueOf(res.getString(9)).toString());
                            txt51.setText(Integer.valueOf(res.getString(10)).toString());
                            txt11.setText(Integer.valueOf(res.getString(11)).toString());

                            val1000 = Integer.parseInt(txt10001.getText().toString());
                            res10001.setText(Integer.toString(val1000*1000));
                            val500 = Integer.parseInt(txt5001.getText().toString());
                            res5001.setText(Integer.toString(val500*500));
                            val200 = Integer.parseInt(txt2001.getText().toString());
                            res2001.setText(Integer.toString(val200*200));
                            val100 = Integer.parseInt(txt1001.getText().toString());
                            res1001.setText(Integer.toString(val100*100));
                            val50 = Integer.parseInt(txt501.getText().toString());
                            res501.setText(Integer.toString(val50*50));
                            val20b = Integer.parseInt(txt20bill1.getText().toString());
                            res20bills1.setText(Integer.toString(val20b*20));
                            val20c = Integer.parseInt(txt20coin1.getText().toString());
                            res20coin1.setText(Integer.toString(val20c*20));
                            val10 = Integer.parseInt(txt101.getText().toString());
                            res101.setText(Integer.toString(val10*10));
                            val5 = Integer.parseInt(txt51.getText().toString());
                            res51.setText(Integer.toString(val5*5));
                            val1 = Integer.parseInt(txt11.getText().toString());
                            res11.setText(Integer.toString(val1*1));


                            totalamnt = Integer.parseInt(res10001.getText().toString()) +
                                    Integer.parseInt(res5001.getText().toString()) +
                                    Integer.parseInt(res2001.getText().toString()) +
                                    Integer.parseInt(res1001.getText().toString()) +
                                    Integer.parseInt(res501.getText().toString()) +
                                    Integer.parseInt(res20bills1.getText().toString()) +
                                    Integer.parseInt(res20coin1.getText().toString()) +
                                    Integer.parseInt(res101.getText().toString()) +
                                    Integer.parseInt(res51.getText().toString()) +
                                    Integer.parseInt(res11.getText().toString());
                            total.setText(df.format(Double.parseDouble(Integer.toString(totalamnt))));
                        }


                        txt10001.setEnabled(true);
                        txt5001.setEnabled(true);
                        txt2001.setEnabled(true);
                        txt1001.setEnabled(true);
                        txt501.setEnabled(true);
                        txt20bill1.setEnabled(true);
                        txt20coin1.setEnabled(true);
                        txt101.setEnabled(true);
                        txt51.setEnabled(true);
                        txt11.setEnabled(true);
                        txt10001.setBackgroundColor(Color.parseColor("#DADADA"));
                        txt5001.setBackgroundColor(Color.parseColor("#DADADA"));
                        txt2001.setBackgroundColor(Color.parseColor("#DADADA"));
                        txt1001.setBackgroundColor(Color.parseColor("#DADADA"));
                        txt501.setBackgroundColor(Color.parseColor("#DADADA"));
                        txt20bill1.setBackgroundColor(Color.parseColor("#DADADA"));
                        txt20coin1.setBackgroundColor(Color.parseColor("#DADADA"));
                        txt101.setBackgroundColor(Color.parseColor("#DADADA"));
                        txt51.setBackgroundColor(Color.parseColor("#DADADA"));
                        txt11.setBackgroundColor(Color.parseColor("#DADADA"));
                    }
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(MainActivity.this, Settings.class);
                startActivity(intent1);
            }
        });
        Cursor res = myDB.getSpecificData(username.getText().toString().trim());
        if (res.getCount() == 0){
            Toast.makeText(MainActivity.this,"No Entry Exist", Toast.LENGTH_SHORT).show();
            return;
        }else{
            while (res.moveToNext()){
                txt10001.setText(Integer.valueOf(res.getString(2)).toString());
                txt5001.setText(Integer.valueOf(res.getString(3)).toString());
                txt2001.setText(Integer.valueOf(res.getString(4)).toString());
                txt1001.setText(Integer.valueOf(res.getString(5)).toString());
                txt501.setText(Integer.valueOf(res.getString(6)).toString());
                txt20bill1.setText(Integer.valueOf(res.getString(7)).toString());
                txt20coin1.setText(Integer.valueOf(res.getString(8)).toString());
                txt101.setText(Integer.valueOf(res.getString(9)).toString());
                txt51.setText(Integer.valueOf(res.getString(10)).toString());
                txt11.setText(Integer.valueOf(res.getString(11)).toString());

                val1000 = Integer.parseInt(txt10001.getText().toString());
                res10001.setText(Integer.toString(val1000*1000));
                val500 = Integer.parseInt(txt5001.getText().toString());
                res5001.setText(Integer.toString(val500*500));
                val200 = Integer.parseInt(txt2001.getText().toString());
                res2001.setText(Integer.toString(val200*200));
                val100 = Integer.parseInt(txt1001.getText().toString());
                res1001.setText(Integer.toString(val100*100));
                val50 = Integer.parseInt(txt501.getText().toString());
                res501.setText(Integer.toString(val50*50));
                val20b = Integer.parseInt(txt20bill1.getText().toString());
                res20bills1.setText(Integer.toString(val20b*20));
                val20c = Integer.parseInt(txt20coin1.getText().toString());
                res20coin1.setText(Integer.toString(val20c*20));
                val10 = Integer.parseInt(txt101.getText().toString());
                res101.setText(Integer.toString(val10*10));
                val5 = Integer.parseInt(txt51.getText().toString());
                res51.setText(Integer.toString(val5*5));
                val1 = Integer.parseInt(txt11.getText().toString());
                res11.setText(Integer.toString(val1*1));


                totalamnt = Integer.parseInt(res10001.getText().toString()) +
                        Integer.parseInt(res5001.getText().toString()) +
                        Integer.parseInt(res2001.getText().toString()) +
                        Integer.parseInt(res1001.getText().toString()) +
                        Integer.parseInt(res501.getText().toString()) +
                        Integer.parseInt(res20bills1.getText().toString()) +
                        Integer.parseInt(res20coin1.getText().toString()) +
                        Integer.parseInt(res101.getText().toString()) +
                        Integer.parseInt(res51.getText().toString()) +
                        Integer.parseInt(res11.getText().toString());
                total.setText(df.format(Double.parseDouble(Integer.toString(totalamnt))));
            }

        }
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt10001.setText("0");
                txt5001.setText("0");
                txt2001.setText("0");
                txt1001.setText("0");
                txt501.setText("0");
                txt20bill1.setText("0");
                txt20coin1.setText("0");
                txt101.setText("0");
                txt51.setText("0");
                txt11.setText("0");
            }
        });
        txt10001.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(txt10001.getText().toString().isEmpty()){
                    txt10001.setText("0");
                    txt10001.selectAll();
                }
                val1000 = Integer.parseInt(txt10001.getText().toString());

                    if (s.length()!=0){
                        res10001.setText(Integer.toString(val1000*1000));
                        txt1000minus.setEnabled(true);
                    }else{
                        res10001.setText(Integer.toString(val1000*0));
                        txt1000minus.setEnabled(false);
                    }
                totalamnt = Integer.parseInt(res10001.getText().toString()) +
                        Integer.parseInt(res5001.getText().toString()) +
                        Integer.parseInt(res2001.getText().toString()) +
                        Integer.parseInt(res1001.getText().toString()) +
                        Integer.parseInt(res501.getText().toString()) +
                        Integer.parseInt(res20bills1.getText().toString()) +
                        Integer.parseInt(res20coin1.getText().toString()) +
                        Integer.parseInt(res101.getText().toString()) +
                        Integer.parseInt(res51.getText().toString()) +
                        Integer.parseInt(res11.getText().toString());
                total.setText(df.format(Double.parseDouble(Integer.toString(totalamnt))));

                MyDatabaseHelper myDB = new MyDatabaseHelper(MainActivity.this);
                myDB.updateData(username.getText().toString().trim(),
                        Integer.parseInt(txt10001.getText().toString()),
                        Integer.parseInt(txt5001.getText().toString()),
                        Integer.parseInt(txt2001.getText().toString()),
                        Integer.parseInt(txt1001.getText().toString()),
                        Integer.parseInt(txt501.getText().toString()),
                        Integer.parseInt(txt20bill1.getText().toString()),
                        Integer.parseInt(txt20coin1.getText().toString()),
                        Integer.parseInt(txt101.getText().toString()),
                        Integer.parseInt(txt51.getText().toString()),
                        Integer.parseInt(txt11.getText().toString()));

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        txt5001.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(txt5001.getText().toString().isEmpty()){
                    txt5001.setText("0");
                    txt5001.selectAll();
                }
                val500 = Integer.parseInt(txt5001.getText().toString());
                if (s.length()!=0){
                    res5001.setText(Integer.toString(val500*500));
                    txt500minus.setEnabled(true);
                }else{
                    res5001.setText(Integer.toString(val500*0));
                    txt500minus.setEnabled(false);
                }
                totalamnt = Integer.parseInt(res10001.getText().toString()) +
                        Integer.parseInt(res5001.getText().toString()) +
                        Integer.parseInt(res2001.getText().toString()) +
                        Integer.parseInt(res1001.getText().toString()) +
                        Integer.parseInt(res501.getText().toString()) +
                        Integer.parseInt(res20bills1.getText().toString()) +
                        Integer.parseInt(res20coin1.getText().toString()) +
                        Integer.parseInt(res101.getText().toString()) +
                        Integer.parseInt(res51.getText().toString()) +
                        Integer.parseInt(res11.getText().toString());
                total.setText(df.format(Double.parseDouble(Integer.toString(totalamnt))));

                MyDatabaseHelper myDB = new MyDatabaseHelper(MainActivity.this);
                myDB.updateData(username.getText().toString().trim(),
                        Integer.parseInt(txt10001.getText().toString()),
                        Integer.parseInt(txt5001.getText().toString()),
                        Integer.parseInt(txt2001.getText().toString()),
                        Integer.parseInt(txt1001.getText().toString()),
                        Integer.parseInt(txt501.getText().toString()),
                        Integer.parseInt(txt20bill1.getText().toString()),
                        Integer.parseInt(txt20coin1.getText().toString()),
                        Integer.parseInt(txt101.getText().toString()),
                        Integer.parseInt(txt51.getText().toString()),
                        Integer.parseInt(txt11.getText().toString()));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        txt2001.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(txt2001.getText().toString().isEmpty()){
                    txt2001.setText("0");
                    txt2001.selectAll();
                }
                val200 = Integer.parseInt(txt2001.getText().toString());
                if (s.length()!=0){
                    res2001.setText(Integer.toString(val200*200));
                    txt200minus.setEnabled(true);
                }else{
                    res2001.setText(Integer.toString(val200*0));
                    txt200minus.setEnabled(false);
                }
                totalamnt = Integer.parseInt(res10001.getText().toString()) +
                        Integer.parseInt(res5001.getText().toString()) +
                        Integer.parseInt(res2001.getText().toString()) +
                        Integer.parseInt(res1001.getText().toString()) +
                        Integer.parseInt(res501.getText().toString()) +
                        Integer.parseInt(res20bills1.getText().toString()) +
                        Integer.parseInt(res20coin1.getText().toString()) +
                        Integer.parseInt(res101.getText().toString()) +
                        Integer.parseInt(res51.getText().toString()) +
                        Integer.parseInt(res11.getText().toString());
                total.setText(df.format(Double.parseDouble(Integer.toString(totalamnt))));

                MyDatabaseHelper myDB = new MyDatabaseHelper(MainActivity.this);
                myDB.updateData(username.getText().toString().trim(),
                        Integer.parseInt(txt10001.getText().toString()),
                        Integer.parseInt(txt5001.getText().toString()),
                        Integer.parseInt(txt2001.getText().toString()),
                        Integer.parseInt(txt1001.getText().toString()),
                        Integer.parseInt(txt501.getText().toString()),
                        Integer.parseInt(txt20bill1.getText().toString()),
                        Integer.parseInt(txt20coin1.getText().toString()),
                        Integer.parseInt(txt101.getText().toString()),
                        Integer.parseInt(txt51.getText().toString()),
                        Integer.parseInt(txt11.getText().toString()));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        txt1001.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(txt1001.getText().toString().isEmpty()){
                    txt1001.setText("0");
                    txt1001.selectAll();
                }
                val100 = Integer.parseInt(txt1001.getText().toString());
                if (s.length()!=0){
                    res1001.setText(Integer.toString(val100*100));
                    txt100minus.setEnabled(true);
                }else{
                    res1001.setText(Integer.toString(val100*0));
                    txt100minus.setEnabled(false);
                }
                totalamnt = Integer.parseInt(res10001.getText().toString()) +
                        Integer.parseInt(res5001.getText().toString()) +
                        Integer.parseInt(res2001.getText().toString()) +
                        Integer.parseInt(res1001.getText().toString()) +
                        Integer.parseInt(res501.getText().toString()) +
                        Integer.parseInt(res20bills1.getText().toString()) +
                        Integer.parseInt(res20coin1.getText().toString()) +
                        Integer.parseInt(res101.getText().toString()) +
                        Integer.parseInt(res51.getText().toString()) +
                        Integer.parseInt(res11.getText().toString());
                total.setText(df.format(Double.parseDouble(Integer.toString(totalamnt))));

                MyDatabaseHelper myDB = new MyDatabaseHelper(MainActivity.this);
                myDB.updateData(username.getText().toString().trim(),
                        Integer.parseInt(txt10001.getText().toString()),
                        Integer.parseInt(txt5001.getText().toString()),
                        Integer.parseInt(txt2001.getText().toString()),
                        Integer.parseInt(txt1001.getText().toString()),
                        Integer.parseInt(txt501.getText().toString()),
                        Integer.parseInt(txt20bill1.getText().toString()),
                        Integer.parseInt(txt20coin1.getText().toString()),
                        Integer.parseInt(txt101.getText().toString()),
                        Integer.parseInt(txt51.getText().toString()),
                        Integer.parseInt(txt11.getText().toString()));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        txt501.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(txt501.getText().toString().isEmpty()){
                    txt501.setText("0");
                    txt501.selectAll();
                }
                val50 = Integer.parseInt(txt501.getText().toString());
                if (s.length()!=0){
                    res501.setText(Integer.toString(val50*50));
                    txt50minus.setEnabled(true);
                }else{
                    res501.setText(Integer.toString(val50*0));
                    txt50minus.setEnabled(false);
                }
                totalamnt = Integer.parseInt(res10001.getText().toString()) +
                        Integer.parseInt(res5001.getText().toString()) +
                        Integer.parseInt(res2001.getText().toString()) +
                        Integer.parseInt(res1001.getText().toString()) +
                        Integer.parseInt(res501.getText().toString()) +
                        Integer.parseInt(res20bills1.getText().toString()) +
                        Integer.parseInt(res20coin1.getText().toString()) +
                        Integer.parseInt(res101.getText().toString()) +
                        Integer.parseInt(res51.getText().toString()) +
                        Integer.parseInt(res11.getText().toString());
                total.setText(df.format(Double.parseDouble(Integer.toString(totalamnt))));

                MyDatabaseHelper myDB = new MyDatabaseHelper(MainActivity.this);
                myDB.updateData(username.getText().toString().trim(),
                        Integer.parseInt(txt10001.getText().toString()),
                        Integer.parseInt(txt5001.getText().toString()),
                        Integer.parseInt(txt2001.getText().toString()),
                        Integer.parseInt(txt1001.getText().toString()),
                        Integer.parseInt(txt501.getText().toString()),
                        Integer.parseInt(txt20bill1.getText().toString()),
                        Integer.parseInt(txt20coin1.getText().toString()),
                        Integer.parseInt(txt101.getText().toString()),
                        Integer.parseInt(txt51.getText().toString()),
                        Integer.parseInt(txt11.getText().toString()));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        txt20bill1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(txt20bill1.getText().toString().isEmpty()){
                    txt20bill1.setText("0");
                    txt20bill1.selectAll();
                }
                val20b = Integer.parseInt(txt20bill1.getText().toString());
                if (s.length()!=0){
                    res20bills1.setText(Integer.toString(val20b*20));
                    txt20minus1.setEnabled(true);
                }else{
                    res20bills1.setText(Integer.toString(val20b*0));
                    txt20minus1.setEnabled(false);
                }
                totalamnt = Integer.parseInt(res10001.getText().toString()) +
                        Integer.parseInt(res5001.getText().toString()) +
                        Integer.parseInt(res2001.getText().toString()) +
                        Integer.parseInt(res1001.getText().toString()) +
                        Integer.parseInt(res501.getText().toString()) +
                        Integer.parseInt(res20bills1.getText().toString()) +
                        Integer.parseInt(res20coin1.getText().toString()) +
                        Integer.parseInt(res101.getText().toString()) +
                        Integer.parseInt(res51.getText().toString()) +
                        Integer.parseInt(res11.getText().toString());
                total.setText(df.format(Double.parseDouble(Integer.toString(totalamnt))));

                MyDatabaseHelper myDB = new MyDatabaseHelper(MainActivity.this);
                myDB.updateData(username.getText().toString().trim(),
                        Integer.parseInt(txt10001.getText().toString()),
                        Integer.parseInt(txt5001.getText().toString()),
                        Integer.parseInt(txt2001.getText().toString()),
                        Integer.parseInt(txt1001.getText().toString()),
                        Integer.parseInt(txt501.getText().toString()),
                        Integer.parseInt(txt20bill1.getText().toString()),
                        Integer.parseInt(txt20coin1.getText().toString()),
                        Integer.parseInt(txt101.getText().toString()),
                        Integer.parseInt(txt51.getText().toString()),
                        Integer.parseInt(txt11.getText().toString()));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        txt20coin1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(txt20coin1.getText().toString().isEmpty()){
                    txt20coin1.setText("0");
                    txt20coin1.selectAll();
                }
                val20c = Integer.parseInt(txt20coin1.getText().toString());
                if (s.length()!=0){
                    res20coin1.setText(Integer.toString(val20c*20));
                    txt20minus.setEnabled(true);
                }else{
                    res20coin1.setText(Integer.toString(val20c*0));
                    txt20minus.setEnabled(false);
                }
                totalamnt = Integer.parseInt(res10001.getText().toString()) +
                        Integer.parseInt(res5001.getText().toString()) +
                        Integer.parseInt(res2001.getText().toString()) +
                        Integer.parseInt(res1001.getText().toString()) +
                        Integer.parseInt(res501.getText().toString()) +
                        Integer.parseInt(res20bills1.getText().toString()) +
                        Integer.parseInt(res20coin1.getText().toString()) +
                        Integer.parseInt(res101.getText().toString()) +
                        Integer.parseInt(res51.getText().toString()) +
                        Integer.parseInt(res11.getText().toString());
                total.setText(df.format(Double.parseDouble(Integer.toString(totalamnt))));

                MyDatabaseHelper myDB = new MyDatabaseHelper(MainActivity.this);
                myDB.updateData(username.getText().toString().trim(),
                        Integer.parseInt(txt10001.getText().toString()),
                        Integer.parseInt(txt5001.getText().toString()),
                        Integer.parseInt(txt2001.getText().toString()),
                        Integer.parseInt(txt1001.getText().toString()),
                        Integer.parseInt(txt501.getText().toString()),
                        Integer.parseInt(txt20bill1.getText().toString()),
                        Integer.parseInt(txt20coin1.getText().toString()),
                        Integer.parseInt(txt101.getText().toString()),
                        Integer.parseInt(txt51.getText().toString()),
                        Integer.parseInt(txt11.getText().toString()));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        txt101.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(txt101.getText().toString().isEmpty()){
                    txt101.setText("0");
                    txt101.selectAll();
                }
                val10 = Integer.parseInt(txt101.getText().toString());
                if (s.length()!=0){
                    res101.setText(Integer.toString(val10*10));
                    txt10minus.setEnabled(true);
                }else{
                    res101.setText(Integer.toString(val10*0));
                    txt10minus.setEnabled(false);
                }
                totalamnt = Integer.parseInt(res10001.getText().toString()) +
                        Integer.parseInt(res5001.getText().toString()) +
                        Integer.parseInt(res2001.getText().toString()) +
                        Integer.parseInt(res1001.getText().toString()) +
                        Integer.parseInt(res501.getText().toString()) +
                        Integer.parseInt(res20bills1.getText().toString()) +
                        Integer.parseInt(res20coin1.getText().toString()) +
                        Integer.parseInt(res101.getText().toString()) +
                        Integer.parseInt(res51.getText().toString()) +
                        Integer.parseInt(res11.getText().toString());
                total.setText(df.format(Double.parseDouble(Integer.toString(totalamnt))));

                MyDatabaseHelper myDB = new MyDatabaseHelper(MainActivity.this);
                myDB.updateData(username.getText().toString().trim(),
                        Integer.parseInt(txt10001.getText().toString()),
                        Integer.parseInt(txt5001.getText().toString()),
                        Integer.parseInt(txt2001.getText().toString()),
                        Integer.parseInt(txt1001.getText().toString()),
                        Integer.parseInt(txt501.getText().toString()),
                        Integer.parseInt(txt20bill1.getText().toString()),
                        Integer.parseInt(txt20coin1.getText().toString()),
                        Integer.parseInt(txt101.getText().toString()),
                        Integer.parseInt(txt51.getText().toString()),
                        Integer.parseInt(txt11.getText().toString()));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        txt51.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(txt51.getText().toString().isEmpty()){
                    txt51.setText("0");
                    txt51.selectAll();
                }
                val5 = Integer.parseInt(txt51.getText().toString());
                if (s.length()!=0){
                    res51.setText(Integer.toString(val5*5));
                    txt5minus.setEnabled(true);
                }else{
                    res51.setText(Integer.toString(val5*0));
                    txt5minus.setEnabled(false);
                }
                totalamnt = Integer.parseInt(res10001.getText().toString()) +
                        Integer.parseInt(res5001.getText().toString()) +
                        Integer.parseInt(res2001.getText().toString()) +
                        Integer.parseInt(res1001.getText().toString()) +
                        Integer.parseInt(res501.getText().toString()) +
                        Integer.parseInt(res20bills1.getText().toString()) +
                        Integer.parseInt(res20coin1.getText().toString()) +
                        Integer.parseInt(res101.getText().toString()) +
                        Integer.parseInt(res51.getText().toString()) +
                        Integer.parseInt(res11.getText().toString());
                total.setText(df.format(Double.parseDouble(Integer.toString(totalamnt))));

                MyDatabaseHelper myDB = new MyDatabaseHelper(MainActivity.this);
                myDB.updateData(username.getText().toString().trim(),
                        Integer.parseInt(txt10001.getText().toString()),
                        Integer.parseInt(txt5001.getText().toString()),
                        Integer.parseInt(txt2001.getText().toString()),
                        Integer.parseInt(txt1001.getText().toString()),
                        Integer.parseInt(txt501.getText().toString()),
                        Integer.parseInt(txt20bill1.getText().toString()),
                        Integer.parseInt(txt20coin1.getText().toString()),
                        Integer.parseInt(txt101.getText().toString()),
                        Integer.parseInt(txt51.getText().toString()),
                        Integer.parseInt(txt11.getText().toString()));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        txt11.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(txt11.getText().toString().isEmpty()){
                    txt11.setText("0");
                    txt11.selectAll();
                }
                val1 = Integer.parseInt(txt11.getText().toString());

                if (s.length()!=0){
                    res11.setText(Integer.toString(val1*1));
                    txt1minus.setEnabled(true);
                }else{
                    res11.setText(Integer.toString(0));
                    txt1minus.setEnabled(false);
                }
                totalamnt = Integer.parseInt(res10001.getText().toString()) +
                        Integer.parseInt(res5001.getText().toString()) +
                        Integer.parseInt(res2001.getText().toString()) +
                        Integer.parseInt(res1001.getText().toString()) +
                        Integer.parseInt(res501.getText().toString()) +
                        Integer.parseInt(res20bills1.getText().toString()) +
                        Integer.parseInt(res20coin1.getText().toString()) +
                        Integer.parseInt(res101.getText().toString()) +
                        Integer.parseInt(res51.getText().toString()) +
                        Integer.parseInt(res11.getText().toString());
                total.setText(df.format(Double.parseDouble(Integer.toString(totalamnt))));

                MyDatabaseHelper myDB = new MyDatabaseHelper(MainActivity.this);
                myDB.updateData(username.getText().toString().trim(),
                        Integer.parseInt(txt10001.getText().toString()),
                        Integer.parseInt(txt5001.getText().toString()),
                        Integer.parseInt(txt2001.getText().toString()),
                        Integer.parseInt(txt1001.getText().toString()),
                        Integer.parseInt(txt501.getText().toString()),
                        Integer.parseInt(txt20bill1.getText().toString()),
                        Integer.parseInt(txt20coin1.getText().toString()),
                        Integer.parseInt(txt101.getText().toString()),
                        Integer.parseInt(txt51.getText().toString()),
                        Integer.parseInt(txt11.getText().toString()));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        txt1000minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int edtvalue = Integer.valueOf(txt10001.getText().toString().trim());
                if (edtvalue>0){
                    txt10001.setText(Integer.toString(edtvalue - 1));
                }

            }
        });
        txt1000plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int edtvalue = Integer.valueOf(txt10001.getText().toString().trim());
                    txt10001.setText(Integer.toString(edtvalue + 1));
            }
        });
        txt500minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int edtvalue = Integer.valueOf(txt5001.getText().toString().trim());
                if (edtvalue>0){
                    txt5001.setText(Integer.toString(edtvalue - 1));
                }
                
            }
        });
        txt500plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int edtvalue = Integer.valueOf(txt5001.getText().toString().trim());
                    txt5001.setText(Integer.toString(edtvalue + 1));
            }
        });
        txt200minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int edtvalue = Integer.valueOf(txt2001.getText().toString().trim());
                if (edtvalue>0){
                txt2001.setText(Integer.toString(edtvalue - 1));}
            }
        });
        txt200plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int edtvalue = Integer.valueOf(txt2001.getText().toString().trim());
                    txt2001.setText(Integer.toString(edtvalue + 1));
            }
        });
        txt100minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int edtvalue = Integer.valueOf(txt1001.getText().toString().trim());
                if (edtvalue>0){
                txt1001.setText(Integer.toString(edtvalue - 1));}
            }
        });
        txt100plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int edtvalue = Integer.valueOf(txt1001.getText().toString().trim());
                    txt1001.setText(Integer.toString(edtvalue + 1));
            }
        });
        txt50plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int edtvalue = Integer.valueOf(txt501.getText().toString().trim());
                    txt501.setText(Integer.toString(edtvalue + 1));
            }
        });
        txt50minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int edtvalue = Integer.valueOf(txt501.getText().toString().trim());
                if (edtvalue>0){
                txt501.setText(Integer.toString(edtvalue - 1));}
            }
        });
        txt20plus1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int edtvalue = Integer.valueOf(txt20coin1.getText().toString().trim());
                    txt20coin1.setText(Integer.toString(edtvalue + 1));
            }
        });
        txt20minus1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int edtvalue = Integer.valueOf(txt20coin1.getText().toString().trim());
                if (edtvalue>0){
                txt20coin1.setText(Integer.toString(edtvalue - 1));}
            }
        });
        txt20plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int edtvalue = Integer.valueOf(txt20bill1.getText().toString().trim());
                    txt20bill1.setText(Integer.toString(edtvalue + 1));
            }
        });
        txt20minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int edtvalue = Integer.valueOf(txt20bill1.getText().toString().trim());
                if (edtvalue>0){
                txt20bill1.setText(Integer.toString(edtvalue - 1));}
            }
        });        
        txt10plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int edtvalue = Integer.valueOf(txt101.getText().toString().trim());
                    txt101.setText(Integer.toString(edtvalue + 1));
            }
        });
        txt10minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int edtvalue = Integer.valueOf(txt101.getText().toString().trim());
                if (edtvalue>0){
                txt101.setText(Integer.toString(edtvalue - 1));}
            }
        });
        txt5plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int edtvalue = Integer.valueOf(txt51.getText().toString().trim());
                    txt51.setText(Integer.toString(edtvalue + 1));
            }
        });
        txt5minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int edtvalue = Integer.valueOf(txt51.getText().toString().trim());
                if (edtvalue>0){
                txt51.setText(Integer.toString(edtvalue - 1));}
            }
        });
        txt1plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int edtvalue = Integer.valueOf(txt11.getText().toString().trim());
                    txt11.setText(Integer.toString(edtvalue + 1));
            }
        });
        txt1minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int edtvalue = Integer.valueOf(txt11.getText().toString().trim());
                if (edtvalue>0){
                txt11.setText(Integer.toString(edtvalue - 1));}
            }
        });
    }
}