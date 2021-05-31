package com.example.contactapp.Models;

public class DTBM { //class điểm trung bình môn
    private String Id;
    private  KhoaHoc KhoaHoc;
    private BaiGiang BaiGiang;
    private SinhVien SinhVien;
    private  double Diem;    //điểm trung bình môn
    private String XepLoai;
    public DTBM(){}

    public DTBM(String id, KhoaHoc khoaHoc, BaiGiang baiGiang,
                SinhVien sinhVien, double diem, String xepLoai) {
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

    public KhoaHoc getKhoaHoc() {
        return KhoaHoc;
    }

    public void setKhoaHoc(KhoaHoc khoaHoc) {
        KhoaHoc = khoaHoc;
    }

    public BaiGiang getBaiGiang() {
        return BaiGiang;
    }

    public void setBaiGiang(BaiGiang baiGiang) {
        BaiGiang = baiGiang;
    }

    public SinhVien getSinhVien() {
        return SinhVien;
    }

    public void setSinhVien(SinhVien sinhVien) {
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
