package com.example.gridview_sanpham;

public class SanPham {
    private String tenSP;
    private String giaSP;
    private String thongtinSP;
    private int hinhSP;

    public SanPham(String tenSP, String giaSP, String thongtinSP, int hinhSP) {
        this.tenSP = tenSP;
        this.giaSP = giaSP;
        this.thongtinSP = thongtinSP;
        this.hinhSP = hinhSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public String getGiaSP() {
        return giaSP;
    }

    public void setGiaSP(String giaSP) {
        this.giaSP = giaSP;
    }

    public String getThongtinSP() {
        return thongtinSP;
    }

    public void setThongtinSP(String thongtinSP) {
        this.thongtinSP = thongtinSP;
    }

    public int getHinhSP() {
        return hinhSP;
    }

    public void setHinhSP(int hinhSP) {
        this.hinhSP = hinhSP;
    }
}
