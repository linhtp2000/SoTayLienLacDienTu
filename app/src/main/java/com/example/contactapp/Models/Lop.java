package com.example.contactapp.Models;

public class Lop {
    private String Id;
    private  String Name;
    private  Khoa Khoa;
    private KhoaHoc KhoaHoc;

    public Lop(){}

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

    public Khoa getKhoa() {
        return Khoa;
    }

    public void setKhoa(Khoa khoa) {
        Khoa = khoa;
    }

    public KhoaHoc getKhoaHoc() {
        return KhoaHoc;
    }

    public void setKhoaHoc(KhoaHoc khoaHoc) {
        KhoaHoc = khoaHoc;
    }
}
