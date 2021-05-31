package com.example.contactapp.Quanly.YourClass.QuanlySV;

public class DongDiemTB {
    String Ten,MSSV,DiemTB,XepLoai;

    public DongDiemTB(String ten, String MSSV, String diemTB, String xepLoai) {
        Ten = ten;
        this.MSSV = MSSV;
        DiemTB = diemTB;
        XepLoai = xepLoai;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String ten) {
        Ten = ten;
    }

    public String getMSSV() {
        return MSSV;
    }

    public void setMSSV(String MSSV) {
        this.MSSV = MSSV;
    }

    public String getDiemTB() {
        return DiemTB;
    }

    public void setDiemTB(String diemTB) {
        DiemTB = diemTB;
    }

    public String getXepLoai() {
        return XepLoai;
    }

    public void setXepLoai(String xepLoai) {
        XepLoai = xepLoai;
    }
}
