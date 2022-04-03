package com.example.gridview_sanpham;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class SanPhamAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<SanPham> sanPhamList;

    public SanPhamAdapter(Context context, int layout, List<SanPham> sanPhamList) {
        this.context = context;
        this.layout = layout;
        this.sanPhamList = sanPhamList;
    }

    @Override
    public int getCount() {
        return sanPhamList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    private class ViewHolder {
        ImageView ivAnh;
        TextView tvTen, tvGia;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout, null); // Gan layout

            // Anh xa
            viewHolder.ivAnh = view.findViewById(R.id.imageview_anh);
            viewHolder.tvTen = view.findViewById(R.id.textview_ten);
            viewHolder.tvGia = view.findViewById(R.id.textview_gia);

            view.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        // Get San Pham
        SanPham sanPham = sanPhamList.get(i);

        // Gan gia tri San Pham
        viewHolder.ivAnh.setImageResource(sanPham.getHinhSP());
        viewHolder.tvTen.setText(sanPham.getTenSP());
        viewHolder.tvGia.setText(sanPham.getGiaSP());

        return view;
    }
}
