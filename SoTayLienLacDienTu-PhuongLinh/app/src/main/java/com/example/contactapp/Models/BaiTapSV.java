package com.example.contactapp.Models;

import java.util.Date;

public class BaiTapSV {
    private String Id;
    private BaiTap BaiTap;
    private double Diem;
    private SinhVien SinhVien;
    private Date NgayNop;
    private String Comment;

    public BaiTapSV(){}

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public BaiTap getBaiTap() {
        return BaiTap;
    }

    public void setBaiTap(BaiTap baiTap) {
        BaiTap = baiTap;
    }

    public double getDiem() {
        return Diem;
    }

    public void setDiem(double diem) {
        Diem = diem;
    }

    public SinhVien getSinhVien() {
        return SinhVien;
    }

    public void setSinhVien(SinhVien sinhVien) {
        SinhVien = sinhVien;
    }

    public Date getNgayNop() {
        return NgayNop;
    }

    public void setNgayNop(Date ngayNop) {
        NgayNop = ngayNop;
    }

    public String getComment() {
        return Comment;
    }

    public void setComment(String comment) {
        Comment = comment;
    }
}
