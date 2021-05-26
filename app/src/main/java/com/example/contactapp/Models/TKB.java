package com.example.contactapp.Models;

public class TKB {       //class thời khóa biểu
    private String Id;
    private String SinhVien;
    private String BaiGiang;

    public TKB() {
    }

    public TKB(String id,String sinhVien, String baiGiang) {
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

    public String getSinhVien() {
        return SinhVien;
    }

    public void setSinhVien(String sinhVien) {
        SinhVien = sinhVien;
    }

    public String getBaiGiang() {
        return BaiGiang;
    }

    public void setBaiGiang(String baiGiang) {
        BaiGiang = baiGiang;
    }
}
