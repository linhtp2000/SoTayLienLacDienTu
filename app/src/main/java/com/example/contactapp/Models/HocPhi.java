package com.example.contactapp.Models;

public class HocPhi {  //class học phí
    private String Id;
    private String SinhVien;
    private  String HocKy;
    private  String TienHocPhi;
    private boolean HoanThanh;

    public HocPhi(){}

    public HocPhi(String Id, String SinhVien,String HocKy, String TienHocPhi, boolean HoanThanh) {
        this.Id = Id;
        this.SinhVien = SinhVien;
        this.HocKy = HocKy;
        this.TienHocPhi = TienHocPhi;
        this.HoanThanh = HoanThanh;
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

    public String getHocKy() {
        return HocKy;
    }

    public void setHocKy(String HocKy) {
        this.HocKy = HocKy;
    }

    public String getTienHocPhi() {
        return TienHocPhi;
    }

    public void setTienHocPhi(String TienHocPhi) {
        this.TienHocPhi = TienHocPhi;
    }

    public boolean isHoanThanh() {
        return HoanThanh;
    }

    public void setHoanThanh(boolean HoanThanh) {
        this.HoanThanh = HoanThanh;
    }
}
