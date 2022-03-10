package com.example.button;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //Khai bao view sử dụng
    TextView txt1; // toàn cục
    Button btnClick;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ánh xạ
        txt1 = (TextView) findViewById(R.id.textview1);
        btnClick = (Button) findViewById(R.id.buttonClick);

        // Viết code
        txt1.setText(" Lập Trình Android"); // Gán txt1 thông qua phương thức setText
        btnClick.setOnClickListener(new View.OnClickListener() { // Sự kiện click của button khi nhấn vào hiển thị
            @Override
            public void onClick(View view) {
                // Viết code
                txt1.setText(" Lập Trình Android");
            }
        });

    }
}