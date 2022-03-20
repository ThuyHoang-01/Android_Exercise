package com.example.module2_2_bai3_listview;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private ArrayList<String> myList;
    private ArrayAdapter<String> adapter;
    private ListView list ;
    private Button btnNhap;
    private TextView tvNhap ;
    String listItems[];
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView list_ten = findViewById(R.id.listview_ten);
        TextView tv_ten = findViewById(R.id.textview_ten);
        TextView tv_kq = findViewById(R.id.textview_kq);
        EditText ed_ten = findViewById(R.id.eidttext_ten);
        Button btn_nhap = findViewById(R.id.button_nhap);
        //Lấy danh sách trong string.xml
        listItems = getResources().getStringArray(R.array.hoten_array);

        myList = new ArrayList<>();
        list = (ListView) findViewById(R.id.listview_ten);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,myList);
        list.setAdapter(adapter);

        // xử lý nút btn
        btn_nhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myList.add(ed_ten.getText()+"");
                adapter.notifyDataSetChanged();
            }
        });

        //Xử lý listView
      //  tv_kq = (TextView)findViewById(R.id.textview_kq);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View view, int i, long l) {
                String msg = "position :" + i ;
                msg += " value " + arg0.getItemAtPosition(i).toString();


                tv_kq.setText(msg);

            }
        });


    }

}