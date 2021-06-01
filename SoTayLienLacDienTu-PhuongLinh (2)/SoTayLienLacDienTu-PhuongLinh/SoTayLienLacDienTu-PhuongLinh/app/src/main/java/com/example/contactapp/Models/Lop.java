package com.example.contactapp.Models;

public class Lop {
    private String Id;
    private  String Name;
    private  String Khoa;
    private String KhoaHoc;

    public  Lop(){}

    public Lop(String Name, String KhoaHoc) {
        this.Name = Name;
        this.KhoaHoc = KhoaHoc;
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

    public String getKhoa() {
        return Khoa;
    }

    public void setKhoa(String khoa) {
        Khoa = khoa;
    }

    public String getKhoaHoc() {
        return KhoaHoc;
    }

    public void setKhoaHoc(String khoaHoc) { KhoaHoc = khoaHoc;
    }
}
