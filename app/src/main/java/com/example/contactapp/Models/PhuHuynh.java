package com.example.contactapp.Models;

public class PhuHuynh {  //class phụ huynh
    private String Id;
    private  String Name;
    private SinhVien SinhVien;
    private  String Phone;
    private  String Email;
    private String Parentof;
    public PhuHuynh(){}

    public PhuHuynh(String id, String name, com.example.contactapp.Models.SinhVien sinhVien, String phone, String email, String parentof) {
        Id = id;
        Name = name;
        SinhVien = sinhVien;
        Phone = phone;
        Email = email;
        Parentof = parentof;
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

    public SinhVien getSinhVien() {
        return SinhVien;
    }

    public void setSinhVien(SinhVien sinhVien) {
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

    public String getParentof() {
        return Parentof;
    }

    public void setParentof(String parentof) {
        Parentof = parentof;
    }
}
