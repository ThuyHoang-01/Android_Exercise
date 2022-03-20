package com.example.module2_2_bai5_quanlynhanvien;

public class EmployeeFullTime extends Employee {


    @Override
    public double TinhLuong() {
        return 500;
    }
    @Override
    public String toString() {
        return super.toString() + "---> Full time = " + TinhLuong();
    }

}
