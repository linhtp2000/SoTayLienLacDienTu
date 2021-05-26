package com.example.contactapp.Models;

public class DTBM { //class điểm trung bình môn
    private String Id;
    private  String KhoaHoc;
    private String BaiGiang;
    private String SinhVien;
    private  double Diem;    //điểm trung bình môn
    private String XepLoai;
    public DTBM(){}

    public DTBM(String id, String khoaHoc, String baiGiang,
                String sinhVien, double diem, String xepLoai) {
        Id = id;
        KhoaHoc = khoaHoc;
        BaiGiang = baiGiang;
        SinhVien = sinhVien;
        Diem = diem;
        XepLoai = xepLoai;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getKhoaHoc() {
        return KhoaHoc;
    }

    public void setKhoaHoc(String khoaHoc) {
        KhoaHoc = khoaHoc;
    }

    public String getBaiGiang() {
        return BaiGiang;
    }

    public void setBaiGiang(String baiGiang) {
        BaiGiang = baiGiang;
    }

    public String getSinhVien() {
        return SinhVien;
    }

    public void setSinhVien(String sinhVien) {
        SinhVien = sinhVien;
    }

    public double getDiem() {
        return Diem;
    }

    public void setDiem(double diem) {
        Diem = diem;
    }

    public String getXepLoai() {
        return XepLoai;
    }

    public void setXepLoai(String xepLoai) {
        XepLoai = xepLoai;
    }
}
