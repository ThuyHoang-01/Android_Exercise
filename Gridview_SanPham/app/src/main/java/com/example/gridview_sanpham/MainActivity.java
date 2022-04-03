package com.example.gridview_sanpham;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    GridView gv_sanpham;
    Button button_thoat;

    ArrayList<SanPham> listSanPham;
    SanPhamAdapter sanPhamAdapter;

    String gioiThieu = "Sữa mẹ là thức ăn tốt nhất cho sức khỏe và sự phát triển toàn diện của trẻ nhỏ: ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeElements(); // Khoi tao thuoc tinh

        sanPhamAdapter = new SanPhamAdapter(this, R.layout.dong_sanpham, listSanPham);
        gv_sanpham.setAdapter(sanPhamAdapter);

        gv_sanpham.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, listSanPham.get(i).getTenSP(), Toast.LENGTH_SHORT).show();

                int hinhSP = listSanPham.get(i).getHinhSP();
                String tenSP = listSanPham.get(i).getTenSP();
                String giaSP = listSanPham.get(i).getGiaSP();
                String thongtinSP = listSanPham.get(i).getThongtinSP();

                Intent intent = new Intent(MainActivity.this, ActivitySieuThi.class);
                intent.putExtra("image", hinhSP);
                intent.putExtra("name", tenSP);
                intent.putExtra("gia", giaSP);
                intent.putExtra("thongtin", thongtinSP);

                startActivity(intent);
            }
        });

        button_thoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                System.exit(0);
            }
        });
    }

    private void initializeElements() {
        gv_sanpham = findViewById(R.id.grid_view_sanpham);
        button_thoat = findViewById(R.id.btn_thoat);

        listSanPham = new ArrayList<>();
        listSanPham.add(new SanPham("Sữa Blackmores Số 1 900g (0-6 tháng tuổi)", "590.000₫", gioiThieu + "Sữa Blackmores Newborn là sản phẩm dinh dưỡng nhập khẩu từ Úc, sữa bổ sung nguồn dinh dưỡng cao, các chất dễ tiêu hóa khác giúp bé hấp thu dễ dàng và hạn chế táo bón.", R.drawable.suablackmores));
        listSanPham.add(new SanPham("Sữa ColosBaby Gold 0+ 800g (0 - 12 tháng)", "890.000₫", gioiThieu + "Sữa bột Colos Baby Gold 0  - 800g - ColosBaby - VMCG8S01 với thành phần sữa non cao cấp nhập khẩu từ Mỹ cùng với Lactium và hệ dưỡng chất đầy đủ, cân đối giúp bé yêu khỏe mạnh, khôn lớn từng ngày", R.drawable.suacolosbaby));
        listSanPham.add(new SanPham("Sữa Famna Số 1 850g (0-6 tháng tuổi)", "469.000₫", gioiThieu + "Bột sữa (bột whey khử khoáng, sữa bột nguyên kem, dầu thực vật (dầu hạt cải, dầu bắp, dầu dừa, dầu hướng dương), lactose, chất khoáng", R.drawable.suafamna));
        listSanPham.add(new SanPham("Sữa Frisolac Gold số 1 380g (0-6 tháng)", "249.000₫", gioiThieu + "Frisolac® là sản phẩm được thiết kế cung cấp các dưỡng chất quan trọng giúp bé khỏe mạnh hơn từ bên trong để thỏa sức cùng mẹ khám phá thế giới mỗi ngày.", R.drawable.suafrisolac));
        listSanPham.add(new SanPham("Sữa GrowPLUS+ Đỏ 900g (từ 1 tuổi", "355.000₫", gioiThieu + "Sữa bột nguyên kem bổ sung vitamin A và D3, đường sucrose, maltodextrin, chất xơ thực phẩm (FOS/ Inulin),  axit docosahexaenoic (DHA) từ dầu cá, l - lysine hydrochlorid, vitamin và khoáng chất", R.drawable.suagrowplus));
        listSanPham.add(new SanPham("Sữa Meiji Infant Formula 800g (0-12 tháng)", "535.000₫", gioiThieu + "Meiji Infant Formula 800g (0-1 tuổi): lon thiếc dày dặn, nắp nhựa trắng có sẵn thanh gạt giúp việc đong sữa dễ dàng hơn. Thìa đong đựng sẵn trong lon, được thiết kế để pha chuẩn 20ml sữa.", R.drawable.suameijiinfant));
        listSanPham.add(new SanPham("Sữa Nan Optipro 1 900g, HMO (0-6 tháng)", "449.000₫", gioiThieu + "LACTOSE (từ SỮA) ĐẠM chất lượng OPTIPRO (ĐẠM WHEY-WHEY PROTEIN từ SỮA), Dầu hướng dương giàu Oleic, SỮA bột tách kem (skimmed MILK), Dầu ĐẬU NÀNH (SOYA bean oil), Canxi Citrate, 2'-O-Fucosyllactose (2'- FL)", R.drawable.suanan));
        listSanPham.add(new SanPham("Sữa Vinamilk Organic Gold 3 850g (Từ 12 tháng)", "625.000₫", gioiThieu + "Sản phẩm dinh dưỡng - Vinamilk Organic 3 Cho trẻ từ 12 tháng tuổi 100% nhập khẩu từ New Zealand, Úc và Châu Âu. Sản xuất và đóng gói tại : Việt Nam", R.drawable.suaoganic));
        listSanPham.add(new SanPham("Sữa Pediasure 850g  (1-10 tuổi)", "615.000₫", gioiThieu + "là thức uống dinh dưỡng đầy đủ và cân đối giúp trẻ tăng cường sức đề kháng được khuyên dùng bởi các chuyên gia dinh dưỡng nhi khoa. Sản phẩm không chỉ giúp bé hấp thu tốt, tăng chiều cao mà còn giúp giảm số ngày ốm.", R.drawable.suapediasure));
        listSanPham.add(new SanPham("Sữa Famna Số 1 850g (0-6 tháng tuổi)", "469.000₫", gioiThieu + "Hỗ trợ tiêu hóa tốt, tăng cường hấp thụ: 2’-FL HMO cùng hệ Synbiotics gồm Prebiotics (FOS/ Inulin) và Probiotics (Bifidobacterium lactics), vitamin nhóm B", R.drawable.suafamna));
        listSanPham.add(new SanPham("Sữa Vinamilk Yoko Gold 1 350g (0-1 tuổi)", "205.000₫", gioiThieu + "Bột sữa (sữa bột, chất béo sữa), lactoza, maltodextrin, dầu thực vật (dầu đậu nành, dầu dừa, dầu hướng dương giàu oleic), đạm whey cô đặc, chất xơ hòa tan (galacto-oligosaccharid (GOS) & oligofructose (FOS))", R.drawable.suayoko));
        listSanPham.add(new SanPham("Sữa Vinamilk Optimum Gold 1 800g (0-6 tháng)", "359.000₫", gioiThieu + "Lactoza, bột sữa (sữa bột, chất béo sữa), dầu thực vật (dầu hướng dương giàu oleic, dầu đậu nành, dầu dừa), maltodextrin, đạm whey cô đặc (whey giàu alpha-lactalbumin và whey), chất xơ hòa tan oligofructose (FOS)", R.drawable.vinamilkoptimum));

    }
}