package com.example.chuyendoilich;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView txt_1 = findViewById(R.id.textview1);
        TextView txt_2 = findViewById(R.id.textview2);
        EditText et_1 = findViewById(R.id.edittext1);
        EditText et_2 = findViewById(R.id.edittext2);
        Button btn_1 = findViewById(R.id.button1);

        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a = Integer.parseInt(et_1.getText().toString());
                String can, chi;
                if (a >= 1900) {
                    Toast.makeText(MainActivity.this, " Mời bạn nhập số lớn hơn 1900 !", Toast.LENGTH_LONG).show();
                } else {
                    switch (a % 10) {
                        case 1:

                            break;
                        case 2:

                            break;
                        default:

                    }

                }
            }


        }
    }
