package com.example.contactapp.Model;

public class Parent {
    private String id;
    private String Email;
    private String Name;
    private String Phone;
    private String SinhVien;
    private String Address;

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public Parent(){

    }
    public Parent(String id, String email, String name, String phone, String sinhVien, String address) {
        this.id = id;
        Email = email;
        Name = name;
        Phone = phone;
        SinhVien = sinhVien;
        this.Address=address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
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
