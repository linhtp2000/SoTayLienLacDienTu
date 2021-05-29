package com.example.contactapp.Models;

public class HocPhi {  //class học phí
    private String Id;
    private SinhVien SinhVien;
    private  HocKy HocKy;
    private  double tienHocPhi;
    private  boolean HoanThanh;

    public HocPhi(){}

    public HocPhi(String id, SinhVien sinhVien, HocKy hocKy, double tienHocPhi, boolean hoanThanh) {
        Id = id;
        SinhVien = sinhVien;
        HocKy = hocKy;
        this.tienHocPhi = tienHocPhi;
        HoanThanh = hoanThanh;
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

    public HocKy getHocKy() {
        return HocKy;
    }

    public void setHocKy(HocKy hocKy) {
        HocKy = hocKy;
    }

    public double getTienHocPhi() {
        return tienHocPhi;
    }

    public void setTienHocPhi(double tienHocPhi) {
        this.tienHocPhi = tienHocPhi;
    }

    public boolean isHoanThanh() {
        return HoanThanh;
    }

    public void setHoanThanh(boolean hoanThanh) {
        HoanThanh = hoanThanh;
    }
}
