package com.example.imageview;

import static java.util.Arrays.stream;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    int manghinhbai[] = {
            R.drawable.c1, R.drawable.c2, R.drawable.c3, R.drawable.c4, R.drawable.c5,
            R.drawable.c6, R.drawable.c7, R.drawable.c8, R.drawable.c9, R.drawable.c10,
            R.drawable.cj, R.drawable.cq, R.drawable.ck,
            R.drawable.d1, R.drawable.d2, R.drawable.d3, R.drawable.d4, R.drawable.d5,
            R.drawable.d6, R.drawable.d7, R.drawable.d8, R.drawable.d9, R.drawable.d10,
            R.drawable.dj, R.drawable.dq, R.drawable.dk,
            R.drawable.h1, R.drawable.h2, R.drawable.h3, R.drawable.h4, R.drawable.h5,
            R.drawable.h6, R.drawable.h7, R.drawable.h8, R.drawable.h9, R.drawable.h10,
            R.drawable.hj, R.drawable.hq, R.drawable.hk,
            R.drawable.s1, R.drawable.s2, R.drawable.s3, R.drawable.s4, R.drawable.s5,
            R.drawable.s6, R.drawable.s7, R.drawable.s8, R.drawable.s9, R.drawable.s10,
            R.drawable.sj, R.drawable.sq, R.drawable.sk};
    int count = 0;
    int mayWin = 0 , nguoiWin = 0 ;
    int mayHoa = 0, nguoiHoa = 0 ;


    /*
     * Define Elements
     */
    ImageView iv1, iv2, iv3, iv4, iv5, iv6;
    Button bt_chiabai;
    TextView tv_ketQua, tv_ketQua1, tv_soLuotChoi;
    EditText et_ketQuaMay, et_ketQuaNguoi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setElements(); // Initialize function

        bt_chiabai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int[] balabai = laySauSoNgauNhien(0, 51);
                int bai1[] = new int[3];
                int bai2[] = new int[3];

                int j = 0;
                for (int i = 0; i < balabai.length; i++) {
                    if (i < 3) {
                        bai1[i] = balabai[i];
                    } else {
                        bai2[j++] = balabai[i];
                    }
                }

                iv1.setImageResource(manghinhbai[balabai[0]]);
                iv2.setImageResource(manghinhbai[balabai[1]]);
                iv3.setImageResource(manghinhbai[balabai[2]]);
                iv4.setImageResource(manghinhbai[balabai[3]]);
                iv5.setImageResource(manghinhbai[balabai[4]]);
                iv6.setImageResource(manghinhbai[balabai[5]]);

                int ketQuaMay = tinhKetQua(bai1), ketQuaNguoi = tinhKetQua(bai2);
                tv_ketQua.setText("K???t qu???:" + (ketQuaMay == 10 ? "Ba t??y" : String.valueOf(ketQuaMay)));
                tv_ketQua1.setText("K???t qu???:" + (ketQuaNguoi == 10 ? "Ba t??y" : String.valueOf(ketQuaNguoi)));

                // so s??nh k???t qu??? 2 ng?????i ch??i r???i c???p nh???t ?? text c???a k???t qu???

                // int ketQuaHienTaiMayWin = Integer.valueOf(et_ketQuaMay.getText().toString());
               // int ketQuaHienTaiNguoiWin = Integer.valueOf(et_ketQuaNguoi.getText().toString());

                if (ketQuaMay < ketQuaNguoi) {
                    nguoiWin++;
                    et_ketQuaNguoi.setText(String.valueOf(nguoiWin));
                } else if (ketQuaMay == ketQuaNguoi) {
                    mayHoa++;
                    nguoiHoa++;
                    et_ketQuaNguoi.setText(String.valueOf(mayHoa));
                    et_ketQuaMay.setText(String.valueOf(nguoiHoa));
                } else {
                    mayWin++;
                    et_ketQuaMay.setText(String.valueOf(mayWin));
                }

                ++count; // t??ng s??? l???n ch??i l??n
                tv_soLuotChoi.setText(String.valueOf("S??? l?????t ch??i: " + count));
                if (count == 10) {
                    if (mayWin > nguoiWin) { // so s??nh coi thang nao win sau 10 hi???p
                        Toast.makeText(MainActivity.this, "M??y ???? chi???n th???ng!", Toast.LENGTH_SHORT).show();  // thong bao may win
                    }
                    else {
                        Toast.makeText(MainActivity.this, "Ng?????i ch??i ???? chi???n th???ng!", Toast.LENGTH_SHORT).show(); // thong bao nguoi win
                    }

                    count = 1; // kh???i t???o set count = 1 b???t ?????u v??ng ch??i m???i
                    et_ketQuaNguoi.setText(String.valueOf(0));
                    et_ketQuaMay.setText(String.valueOf(0));
                }
            }
        });
    }

    //------------------------------
    private void setElements() {
        iv1 = findViewById(R.id.imageView1);
        iv2 = findViewById(R.id.imageView2);
        iv3 = findViewById(R.id.imageView3);
        iv4 = findViewById(R.id.imageView4);
        iv5 = findViewById(R.id.imageView5);
        iv6 = findViewById(R.id.imageView6);
        bt_chiabai = findViewById(R.id.button_ChiaBai);
        tv_ketQua = findViewById(R.id.textView_KetQua);
        tv_ketQua1 = findViewById(R.id.textView_KetQua1);
        tv_soLuotChoi = findViewById(R.id.textView_SoLuot);
        et_ketQuaMay = findViewById(R.id.edtKetQuaMayWin);
        et_ketQuaNguoi = findViewById(R.id.edtKetQuaNguoiChoiWin);
    }

    //------------------------------
    private int tinhKetQua(int[] arr) {
        int ketQua = 0;
        if (tinhSoTay(arr) == 3) {
            ketQua = 11; // ba tay
        } else {
            int tong = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] % 13 < 10) {
                    tong += arr[i] % 13 + 1;
                }
            }
            if (tong % 10 == 0) {
                ketQua = 0;
            } else
                ketQua = (tong % 10);
        }
        return ketQua;
    }

    //---------------------------
    private int tinhSoTay(int[] arr) {
        int k = 0;
        for (int i = 0; i < arr.length; i++)
            if (arr[i] % 13 >= 10)
                k++;
        return k;
    }

    //----------------------------
    private int[] layBaSoNgauNhien(int min, int max) {
        int[] baso = new int[3];
        int i = 0;
        baso[i++] = random(min, max); // ph???n t??? ?????u ti??n trong m???ng ??c g??n gi?? tr??? random
        do {
            int k = random(min, max);
            if (!kiemTraTrung(k, baso))
                baso[i++] = k;
        } while (i < 3);
        return baso;
    }

    //---------------------------
    private int[] laySauSoNgauNhien(int min, int max) {
        int[] baso = new int[6];
        int i = 0;
        baso[i++] = random(min, max); // ph???n t??? ?????u ti??n trong m???ng ??c g??n gi?? tr??? random
        do {
            int k = random(min, max);
            if (!kiemTraTrung(k, baso))
                baso[i++] = k;
        } while (i < 6);
        return baso;
    }

    //------------------------------
    private boolean kiemTraTrung(int k, int[] arr) {
        for (int i = 0; i < arr.length; i++)
            if (arr[i] == k)
                return true;
        return false;
    }

    //----------------------------
    private int random(int min, int max) {
        return min + (int) (Math.random() * (((max - min) + 1)));
    }
}