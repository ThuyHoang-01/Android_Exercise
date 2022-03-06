package com.example.ui_demo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class NhanVienAdapter extends ArrayAdapter<NhanVien> {
    private Context mContext;
    private int mResource;

    public NhanVienAdapter(@NonNull Context context, int resource, @NonNull ArrayList<NhanVien> objects) {
        super(context, resource, objects);
        this.mContext = context;
        this.mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        convertView = layoutInflater.inflate(mResource, parent, false);

        ImageView imageView = convertView.findViewById(R.id.image);
        TextView txtMaso = convertView.findViewById(R.id.txtMaso);
        TextView txtHoten = convertView.findViewById(R.id.txtHoTen);
        TextView txtGioitinh = convertView.findViewById(R.id.txtGioiTinh);
        TextView txtDonVi = convertView.findViewById(R.id.txtDonVi);

        imageView.setImageResource(getItem(position).getImage());
        txtMaso.setText("Mã số: " + getItem(position).getMaso() + "");
        txtHoten.setText("Họ tên: " + getItem(position).getHoTen());
        txtGioitinh.setText("Giới tính: " + getItem(position).getGioiTinh());
        txtDonVi.setText("Đơn vị : " + getItem(position).getDonVi());

        return convertView;
    }
}
