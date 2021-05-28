package com.example.contactapp.Models;

import java.util.Date;

public class BaiTapSV {
    private String Id;
    private String BaiTap;
    private double Diem;
    private String SinhVien;
    private String NgayNop;
    private String Comment;

    public BaiTapSV(String Id, String BaiTap, double Diem, String SinhVien, String NgayNop, String Comment) {

        this.BaiTap = BaiTap;
        this.Diem = Diem;
        this.SinhVien = SinhVien;
        this.NgayNop = NgayNop;
        this.Comment = Comment;
    }

    public BaiTapSV(){}

    public String getId() {
        return Id;
    }

    public void setId(String Id) {this.Id = Id;
    }

    public String getBaiTap() {
        return BaiTap;
    }

    public void setBaiTap(String BaiTap) {
        this.BaiTap = BaiTap;
    }

    public double getDiem() {
        return Diem;
    }

    public void setDiem(double Diem) {
        this.Diem = Diem;
    }

    public String getSinhVien() {
        return SinhVien;
    }

    public void setSinhVien(String SinhVien) {
        this.SinhVien = SinhVien;
    }

    public String getNgayNop() {
        return NgayNop;
    }

    public void setNgayNop(String NgayNop) {
        this.NgayNop = NgayNop;
    }

    public String getComment() {
        return Comment;
    }

    public void setComment(String Comment) {
        this.Comment = Comment;
    }
}
