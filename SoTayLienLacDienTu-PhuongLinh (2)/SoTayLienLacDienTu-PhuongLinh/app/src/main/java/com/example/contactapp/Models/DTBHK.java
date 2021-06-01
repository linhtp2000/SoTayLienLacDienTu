package com.example.contactapp.Models;

public class DTBHK {    //class điểm trung bình học kỳ
    private String Id;
    private  String DTBM;  //id điểm trung bình môn
    private  String SinhVien;
    private  double Diem;    //điểm trung bình
    private String XepLoai;
    private String HocKy;

    public DTBHK(){}

    public DTBHK( String DTBM, String SinhVien, double Diem, String XepLoai, String HocKy) {
        this.DTBM = DTBM;
        this.SinhVien = SinhVien;
        this.Diem = Diem;
        this.XepLoai = XepLoai;
        this.HocKy = HocKy;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        this.Id = Id;
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

    public String getHocKy() {
        return HocKy;
    }

    public void setHocKy(String HocKy) {
        this.HocKy = HocKy;
    }
}
