package com.example.contactapp.Models;

public class DTBHK {    //class điểm trung bình học kỳ
    private String Id;
    private  String DTBM;  //id điểm trung bình môn
    private  String SinhVien;
    private  double Diem;    //điểm trung bình
    private String XepLoai;
    private String HocKy;

    public DTBHK(){}

    public DTBHK(String id, String DTBM, String sinhVien, double diem, String xepLoai, String hocKy) {
        Id = id;
        this.DTBM = DTBM;
        SinhVien = sinhVien;
        Diem = diem;
        XepLoai = xepLoai;
        HocKy = hocKy;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getDTBM() {
        return DTBM;
    }

    public void setDTBM(String DTBM) {
        this.DTBM = DTBM;
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

    public String getHocKy() {
        return HocKy;
    }

    public void setHocKy(String hocKy) {
        HocKy = hocKy;
    }
}
