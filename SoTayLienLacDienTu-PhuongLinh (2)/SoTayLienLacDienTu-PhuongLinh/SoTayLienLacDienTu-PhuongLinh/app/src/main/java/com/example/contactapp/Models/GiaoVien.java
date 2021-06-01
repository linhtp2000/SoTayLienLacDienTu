package com.example.contactapp.Models;

public class GiaoVien {
    private String Id;
    private  String Name;
    private  String Phone;
    private  String Email;

    public GiaoVien(){}

    public GiaoVien(String id, String name, String phone, String email) {
        Id = id;
        Name = name;
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
