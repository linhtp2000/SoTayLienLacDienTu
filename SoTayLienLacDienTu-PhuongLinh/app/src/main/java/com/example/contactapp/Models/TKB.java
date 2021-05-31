package com.example.contactapp.Models;

public class TKB {       //class thời khóa biểu
    private String Id;
    private SinhVien SinhVien;
    private BaiGiang BaiGiang;

    public TKB() {
    }

    public TKB(String id,SinhVien sinhVien, BaiGiang baiGiang) {
        Id = id;
        SinhVien = sinhVien;
        BaiGiang = baiGiang;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public SinhVien getSinhVien() {
        return SinhVien;
    }

    public void setSinhVien(SinhVien sinhVien) {
        SinhVien = sinhVien;
    }

    public BaiGiang getBaiGiang() {
        return BaiGiang;
    }

    public void setBaiGiang(BaiGiang baiGiang) {
        BaiGiang = baiGiang;
    }
}
