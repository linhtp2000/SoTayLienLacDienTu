package com.example.contactapp.Models;

public class DTBHK {    //class điểm trung bình học kỳ
    private String Id;
    private  DTBM DTBM;  //id điểm trung bình môn
    private  SinhVien SinhVien;
    private  double Diem;    //điểm trung bình
    private String XepLoai;
    private HocKy HocKy;

    public DTBHK(){}

    public DTBHK(String id, DTBM DTBM, SinhVien sinhVien, double diem, String xepLoai, HocKy hocKy) {
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

    public DTBM getDTBM() {
        return DTBM;
    }

    public void setDTBM(DTBM DTBM) {
        this.DTBM = DTBM;
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

    public HocKy getHocKy() {
        return HocKy;
    }

    public void setHocKy(HocKy hocKy) {
        HocKy = hocKy;
    }
}
