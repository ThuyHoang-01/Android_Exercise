package com.example.module2_2_bai5_quanlynhanvien;

public class EmployeePartTime extends Employee{

    @Override
    public double TinhLuong() {
        return 150;
    }
    @Override
    public String toString() {
        return super.toString() + "---> Part time = " + TinhLuong();
    }

}
