package com.example.module2_2_bai5_quanlynhanvien;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView txtId, txtName, txtLoai;
    EditText editId, editName;
    Button btnNhap;
    RadioButton rad_ft, rad_pt;
    ListView lv_DanhSach;
    RadioGroup radioGroup;

    ArrayList<Employee> arrEmployee = new ArrayList<Employee>();
    ArrayAdapter<Employee> arrAdapter = null;
    Employee employee = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        * Cách 1: khai báo trực tiếp
        *
        */
        txtId = findViewById(R.id.textview_ma);
        txtName = findViewById(R.id.textview_ten);
        txtLoai = findViewById(R.id.textview_loaiNV);
        editId = findViewById(R.id.edittext_ma);
        editName = findViewById(R.id.edittext_ten);
        btnNhap = findViewById(R.id.button_nhap);
        rad_ft = findViewById(R.id.radioButton_chinhthuc);
        rad_pt = findViewById(R.id.radioButton_thoivu);
        lv_DanhSach = findViewById(R.id.listview_ds);
        radioGroup = findViewById(R.id.radioGroup);
        /*
         * Cách 2:  sử dụng hàm và gọi hàm để khởi tạo các đối tượng UI
         *
         */
       // initialize();

        arrAdapter = new ArrayAdapter<Employee>(this, android.R.layout.simple_list_item_1, arrEmployee);
        lv_DanhSach.setAdapter(arrAdapter);
        btnNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nhap();

            }
        });
    }

    public void nhap() {

        int radId = radioGroup.getCheckedRadioButtonId();
        String id = editId.getText() + "";
        String name = editName.getText() + "";
        if (radId == R.id.radioButton_chinhthuc) {
            employee = new EmployeeFullTime();
        } else {
            employee = new EmployeePartTime();
        }
        employee.setId(id);
        employee.setName(name);

        arrEmployee.add(employee);
        arrAdapter.notifyDataSetChanged();

    }

//    private void initialize() {
//        txtId = findViewById(R.id.textview_ma);
//        txtName = findViewById(R.id.textview_ten);
//        txtLoai = findViewById(R.id.textview_loaiNV);
//        editId = findViewById(R.id.edittext_ma);
//        editName = findViewById(R.id.edittext_ten);
//        btnNhap = findViewById(R.id.button_nhap);
//        rad_ft = findViewById(R.id.radioButton_chinhthuc);
//        rad_pt = findViewById(R.id.radioButton_thoivu);
//        lv_DanhSach = findViewById(R.id.listview_ds);
//        radioGroup = findViewById(R.id.radioGroup);
//    }
}