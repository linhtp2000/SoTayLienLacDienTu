package com.example.contactapp.Models;

public class Lop {
    private String Id;
    private  String Name;
    private  String Khoa;
    private String KhoaHoc;

    public Lop(){}

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getKhoa() {
        return Khoa;
    }

    public void setKhoa(String Khoa) {
        this.Khoa = Khoa;
    }

    public String getKhoaHoc() {
        return KhoaHoc;
    }

    public void setKhoaHoc(String KhoaHoc) {
        this.KhoaHoc = KhoaHoc;
    }

    public Lop(String Name, String Khoa, String KhoaHoc) {
        this.Name = Name;
        this.Khoa = Khoa;
        this.KhoaHoc = KhoaHoc;
    }
}
