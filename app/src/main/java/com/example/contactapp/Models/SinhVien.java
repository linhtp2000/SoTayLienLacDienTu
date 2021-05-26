package com.example.contactapp.Models;

public class SinhVien {
    private String Id;
    private  String Name;
    private String Lop;
    private  String Phone;
    private  String Email;

    public SinhVien(){}

    public SinhVien(String id, String name, String lop, String phone, String email) {
        Id = id;
        Name = name;
        Lop = lop;
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

    public String getLop() {
        return Lop;
    }

    public void setLop(String lop) {
        Lop = lop;
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
