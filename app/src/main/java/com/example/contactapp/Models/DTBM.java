package com.example.contactapp.Models;

public class DTBM { //class điểm trung bình môn
    private String Id;
    private  String KhoaHoc;
    private String BaiGiang;
    private String SinhVien;
    private  double Diem;    //điểm trung bình môn
    private String XepLoai;
    public DTBM(){}

    public DTBM(String Id, String KhoaHoc, String BaiGiang,
                String SinhVien, double Diem, String XepLoai) {

        this.KhoaHoc = KhoaHoc;
        this.BaiGiang = BaiGiang;
        this.SinhVien = SinhVien;
        this.Diem = Diem;
        this.XepLoai = XepLoai;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getKhoaHoc() {
        return KhoaHoc;
    }

    public void setKhoaHoc(String KhoaHoc) {
        this.KhoaHoc = KhoaHoc;
    }

    public String getBaiGiang() {
        return BaiGiang;
    }

    public void setBaiGiang(String BaiGiang) {
        this.BaiGiang = BaiGiang;
    }

    public String getSinhVien() {
        return SinhVien;
    }

    public void setSinhVien(String SinhVien) {
        this.SinhVien = SinhVien;
    }

    public double getDiem() {
        return Diem;
    }

    public void setDiem(double Diem) {
        this.Diem = Diem;
    }

    public String getXepLoai() {
        return XepLoai;
    }

    public void setXepLoai(String XepLoai) {
        this.XepLoai = XepLoai;
    }
}
