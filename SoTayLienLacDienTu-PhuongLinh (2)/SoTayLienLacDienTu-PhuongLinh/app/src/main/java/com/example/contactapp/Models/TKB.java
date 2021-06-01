package com.example.contactapp.Models;

public class TKB {       //class thời khóa biểu
    private String Id;
    private String SinhVien;
    private String BaiGiang;

    public TKB() {
    }

    public TKB(String SinhVien, String BaiGiang) {
        this.SinhVien = SinhVien;
        this.BaiGiang = BaiGiang;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getSinhVien() {
        return SinhVien;
    }

    public void setSinhVien(String SinhVien) {
        this.SinhVien = SinhVien;
    }

    public String getBaiGiang() {
        return BaiGiang;
    }

    public void setBaiGiang(String BaiGiang) {
        this.BaiGiang = BaiGiang;
    }
}
