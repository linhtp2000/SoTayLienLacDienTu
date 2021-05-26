package com.example.contactapp.Models;

public class HocPhi {  //class học phí
    private String Id;
    private String SinhVien;
    private  String HocKy;
    private  double tienHocPhi;
    private  boolean HoanThanh;

    public HocPhi(){}

    public HocPhi(String id, String sinhVien,String hocKy, double tienHocPhi, boolean hoanThanh) {
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

    public String getSinhVien() {
        return SinhVien;
    }

    public void setSinhVien(String sinhVien) {
        SinhVien = sinhVien;
    }

    public String getHocKy() {
        return HocKy;
    }

    public void setHocKy(String hocKy) {
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
