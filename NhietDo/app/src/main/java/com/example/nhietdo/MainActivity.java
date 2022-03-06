package com.example.nhietdo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText et_F = findViewById(R.id.editext1);
        EditText et_C = findViewById(R.id.editext2);
        Button btn1 = findViewById(R.id.button1);
        Button btn2 = findViewById(R.id.button2);
        Button btn3 = findViewById(R.id.button3);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(et_F.getText().toString().equals("")){
                    Toast.makeText(MainActivity.this," de nghi ban nhap do F !!",Toast.LENGTH_LONG).show();
                }else {
                    int f  =Integer.parseInt(et_F.getText().toString());
                    double Celsius  = (double) 9 / 5 * (f-32);
                    et_C.setText(" Độ Celsius là : "+Celsius);
                }
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(et_C.getText().toString().equals("")){
                    Toast.makeText(MainActivity.this," de nghi ban nhap do C !!",Toast.LENGTH_LONG).show();
                }else {
                    int c = Integer.parseInt(et_C.getText().toString());
                    double Fahreheit = (double) 9 / 5 * c + 32;
                    et_F.setText(" Độ Fahreheit là : " + Fahreheit);
                }

            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                 et_F.setText("");
                 et_C.setText("");
            }
        });







    }
}