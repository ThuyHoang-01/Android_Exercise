package com.example.imageview2;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

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
    /*
     * Define Elements
     */
    ImageView iv1, iv2, iv3, iv4, iv5, iv6;
    Button bt_chiabai;
    TextView tv_ketQua, tv_ketQua1, tv_Timer;
    EditText et_ketQuaMay, et_ketQuaNguoi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setElements(); // Initialize function
        long duration = TimeUnit.MINUTES.toMillis(1); // Initialize timer duration - 1 Minute

        bt_chiabai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Initialize countdown timer
                new CountDownTimer(duration, 1000) {
                    @Override
                    public void onTick(long l) {
                        // When tick
                        // Convert millisecond to minute and second
                        String sDuration = String.format(Locale.ENGLISH, "%02d : %02d",
                                TimeUnit.MILLISECONDS.toMinutes(l),
                                TimeUnit.MILLISECONDS.toSeconds(l) - TimeUnit.MILLISECONDS.toSeconds(TimeUnit.MILLISECONDS.toMinutes(l)));
                        // Set converted string on text view;
                        tv_Timer.setText(sDuration);
                        danhBaiCao();
                    }

                    @Override
                    public void onFinish() {
                        // When finish
                        tv_Timer.setText("00 : 00");
                        int ketQuaHienTaiMayWin = Integer.valueOf(et_ketQuaMay.getText().toString());
                        int ketQuaHienTaiNguoiWin = Integer.valueOf(et_ketQuaNguoi.getText().toString());
                        soSanhKetQuaCuoi(ketQuaHienTaiMayWin, ketQuaHienTaiNguoiWin);
                        et_ketQuaNguoi.setText(String.valueOf(0));
                        et_ketQuaMay.setText(String.valueOf(0));
                    }
                }.start();
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
        tv_Timer = findViewById(R.id.textView_Timer);
        et_ketQuaMay = findViewById(R.id.edtKetQuaMayWin);
        et_ketQuaNguoi = findViewById(R.id.edtKetQuaNguoiChoiWin);
    }

    //------------------------------
    private void danhBaiCao() {
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
        tv_ketQua.setText("Kết quả:" + (ketQuaMay == 10 ? "Ba tây" : String.valueOf(ketQuaMay)));
        tv_ketQua1.setText("Kết quả:" + (ketQuaNguoi == 10 ? "Ba tây" : String.valueOf(ketQuaNguoi)));

        // so sánh kết quả 2 người chơi rồi cập nhật ô text của kết quả
        int ketQuaHienTaiMayWin = Integer.valueOf(et_ketQuaMay.getText().toString());
        int ketQuaHienTaiNguoiWin = Integer.valueOf(et_ketQuaNguoi.getText().toString());

        if (ketQuaMay < ketQuaNguoi) {
            ketQuaHienTaiNguoiWin = ++ketQuaHienTaiNguoiWin;
            et_ketQuaNguoi.setText(String.valueOf(ketQuaHienTaiNguoiWin));
        } else if (ketQuaMay == ketQuaNguoi) {
            ketQuaHienTaiNguoiWin = ++ketQuaHienTaiNguoiWin;
            ketQuaHienTaiMayWin = ++ketQuaHienTaiMayWin;
            et_ketQuaNguoi.setText(String.valueOf(ketQuaHienTaiNguoiWin));
            et_ketQuaMay.setText(String.valueOf(ketQuaHienTaiMayWin));
        } else {
            ketQuaHienTaiMayWin = ++ketQuaHienTaiMayWin;
            et_ketQuaMay.setText(String.valueOf(ketQuaHienTaiMayWin));
        }
    }

    //------------------------------
    private void soSanhKetQuaCuoi(int ketQuaHienTaiMayWin, int ketQuaHienTaiNguoiWin) {
        if (ketQuaHienTaiMayWin > ketQuaHienTaiNguoiWin) { // so sánh coi thang nao win sau 10 hiệp
            Toast.makeText(MainActivity.this, "Máy đã chiến thắng!", Toast.LENGTH_SHORT).show();  // thong bao may win
        } else if (ketQuaHienTaiMayWin < ketQuaHienTaiNguoiWin) {
            Toast.makeText(MainActivity.this, "Người chơi đã chiến thắng!", Toast.LENGTH_SHORT).show(); // thong bao nguoi win
        } else {
            Toast.makeText(MainActivity.this, "Hòa!", Toast.LENGTH_SHORT).show(); // thong bao hòa
        }
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
        baso[i++] = random(min, max); // phần tử đầu tiên trong mảng đc gán giá trị random
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
        baso[i++] = random(min, max); // phần tử đầu tiên trong mảng đc gán giá trị random
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