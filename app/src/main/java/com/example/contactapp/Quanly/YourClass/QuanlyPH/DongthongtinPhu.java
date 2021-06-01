package com.example.contactapp.Quanly.YourClass.QuanlyPH;

import com.example.contactapp.Quanly.YourClass.QuanlySV.DongThongtinSV;

public class DongthongtinPhu {
    String Address,Email,Parentof,Name,Phone,SinhVien;
    public DongthongtinPhu(){

    }

    public DongthongtinPhu(String address, String email, String parentof, String name, String phone, String sinhVien) {
        Address = address;
        Email = email;
        Parentof = parentof;
        Name = name;
        Phone = phone;
        SinhVien = sinhVien;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getParentof() {
        return Parentof;
    }

    public void setParentof(String parentof) {
        Parentof = parentof;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getSinhVien() {
        return SinhVien;
    }

    public void setSinhVien(String sinhVien) {
        SinhVien = sinhVien;
    }

}
