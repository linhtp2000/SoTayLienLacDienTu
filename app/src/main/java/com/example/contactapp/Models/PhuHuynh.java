package com.example.contactapp.Models;

public class PhuHuynh {  //class phụ huynh
    private String Id;
    private  String Name;
    private String SinhVien;
    private  String Phone;
    private  String Email;

    public PhuHuynh(){}

    public PhuHuynh(String id, String name,String sinhVien, String phone, String email) {
        Id = id;
        Name = name;
        SinhVien = sinhVien;
        Phone = phone;
        Email = email;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSinhVien() {
        return SinhVien;
    }

    public void setSinhVien(String sinhVien) {
        SinhVien = sinhVien;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
}
