package com.example.ui_demo;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<NhanVien> nv_List = new ArrayList<>();
    String[] dv_List;
    ArrayAdapter<String> adapterDonvi;
    NhanVienAdapter nhanVienAdapter;

    /*
     * Mang anh
     */
    int mangHinhAnh[] = {
            R.drawable.image1, R.drawable.image2, R.drawable.image3,
            R.drawable.image4, R.drawable.image5, R.drawable.image6
    };

    /*
     * Define Elements
     */
    EditText et_MaSo, et_HoTen;
    ListView lv_NhanVien;
    RadioGroup rg_GioiTinh;
    RadioButton rb_Nam, rb_Nu;
    Spinner sp_DonVi;
    ImageView iv_AnhPreview;
    Button bt_Them, bt_Sua, bt_ChonAnh, bt_Thoat;

    /*
     * Define Nhan Vien Property
     */
    int maso, image;
    String hoTen, gioiTinh, donVi;

    /*
     * Define global index
     */
    int index = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeElements();

        // ----------------- Select don vi -----------------
        dv_List = getResources().getStringArray(R.array.donvi_list);
        adapterDonvi = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, dv_List);
        sp_DonVi.setAdapter(adapterDonvi);sp_DonVi.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                donVi = dv_List[i];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        // ----------------- Chọn ảnh -----------------
        bt_ChonAnh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int min = 0;
                int max = 5;

                //Generate random int value from 0 to 5
                int random_int = (int) Math.floor(Math.random() * (max - min + 1) + min);
                image = mangHinhAnh[random_int]; // Set image cho Nhan Vien
                iv_AnhPreview.setImageResource(image);
            }
        });

        //----------------- Đưa danh sách nhân viên vào listView -----------------
        nhanVienAdapter = new NhanVienAdapter(this, R.layout.list_row, nv_List);
        lv_NhanVien.setAdapter(nhanVienAdapter);

        //----------------- Them nhan vien -----------------
        bt_Them.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                maso = Integer.parseInt(et_MaSo.getText().toString());
                hoTen = et_HoTen.getText().toString();
                gioiTinh = ((RadioButton) findViewById(rg_GioiTinh.getCheckedRadioButtonId())).getText().toString();

                //Tạo đối tượng nhân viên
                NhanVien nv = new NhanVien(image, maso, hoTen, gioiTinh, donVi);
                //Thêm nhân viên vào danh sách
                nv_List.add(nv);

                nhanVienAdapter.notifyDataSetChanged(); // Cập nhật lại adapter khi dữ liệu trong mảng thay đổi
                resetNhanVienData(); // Xoá data NV đã nhập
            }
        });

        //----------------- View nhan vien -----------------
        lv_NhanVien.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                NhanVien nv = nv_List.get(i);
                iv_AnhPreview.setImageResource(nv.getImage());
                et_MaSo.setText(nv.getMaso() + "");
                et_HoTen.setText(nv.getHoTen());

                Log.d("AA", nv.getGioiTinh());
                //Xử lý giới tính
                if (nv.getGioiTinh().equals("Nam"))
                    rb_Nam.setChecked(true);
                else
                    rb_Nu.setChecked(true);

                //Xử lý đơn vị
                for (int j = 0; j < dv_List.length; j++) {
                    if (dv_List[j].equals(nv.getDonVi()))
                        sp_DonVi.setSelection(j);
                }

                index = i; // Set global index
            }
        });

        //----------------- Sua nhan vien -----------------
        bt_Sua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NhanVien nv = nv_List.get(index);
                nv.setImage(image);
                nv.setMaso(Integer.parseInt(et_MaSo.getText().toString()));
                nv.setHoTen(et_HoTen.getText().toString());
                nv.setGioiTinh(((RadioButton) findViewById(rg_GioiTinh.getCheckedRadioButtonId())).getText().toString());
                nv.setDonVi(donVi);

                nhanVienAdapter.notifyDataSetChanged(); // Cập nhật lại adapter khi dữ liệu trong mảng thay đổi
                resetNhanVienData(); // Xoá data NV đã nhập
            }
        });

        // ----------------- Thoat chuong trinh -----------------
        bt_Thoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finishAffinity();
                System.exit(0);
            }
        });
    }

    //----------------------------
    private void initializeElements() {
        et_MaSo = findViewById(R.id.et_MaSo);
        et_HoTen = findViewById(R.id.et_HoTen);
        lv_NhanVien = findViewById(R.id.listView_NhanVien);
        rg_GioiTinh = findViewById(R.id.radioGroup);
        rb_Nam = findViewById(R.id.radioButton_Nam);
        rb_Nu = findViewById(R.id.radioButton_Nu);
        sp_DonVi = findViewById(R.id.spinner_DonVi);
        bt_Them = findViewById(R.id.btn_Them);
        bt_ChonAnh = findViewById(R.id.btn_ChonAnh);
        bt_Sua = findViewById(R.id.btn_Sua);
        iv_AnhPreview = findViewById(R.id.iv_AnhPreview);
        bt_Thoat = findViewById(R.id.btn_Thoat);
    }

    //----------------------------
    private void resetNhanVienData() {
        iv_AnhPreview.setImageResource(0);
        et_MaSo.getText().clear();
        et_HoTen.getText().clear();
        rb_Nam.setChecked(false);
        rb_Nu.setChecked(false);
        sp_DonVi.setSelection(0);
    }
}