package com.example.gridview_sanpham;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ActivitySieuThi extends AppCompatActivity {
    ImageView anhSP;
    TextView tenSP, giaSP, thongtinSP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sieuthi);
        initializeElements();

        Intent intent = getIntent();

        if (intent.getExtras() != null) {
            String tenSP = intent.getStringExtra("name");
            int anhSP = intent.getIntExtra("image", 0);
            String giaSP = intent.getStringExtra("gia");
            String thongtinSP = intent.getStringExtra("thongtin");

            this.anhSP.setImageResource(anhSP);
            this.tenSP.setText(tenSP);
            this.giaSP.setText(giaSP);
            this.thongtinSP.setText(thongtinSP);
        }
    }

    private void initializeElements() {
        anhSP = findViewById(R.id.imageview_anhsp);
        tenSP = findViewById(R.id.textview_tensp);
        giaSP = findViewById(R.id.textview_giasp);
        thongtinSP = findViewById(R.id.textview_thongtinsp);
    }
}