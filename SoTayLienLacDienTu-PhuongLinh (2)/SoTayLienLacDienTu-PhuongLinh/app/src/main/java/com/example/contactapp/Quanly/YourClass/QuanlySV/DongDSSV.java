package com.example.contactapp.Quanly.YourClass.QuanlySV;

public class DongDSSV {
    String STT;
    String Ten;
    String MSSV;

    public DongDSSV(String STT, String ten, String MSSV) {
        this.STT = STT;
        Ten = ten;
        this.MSSV = MSSV;
    }

    public String getSTT() {
        return STT;
    }

    public void setSTT(String STT) {
        this.STT = STT;
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
}
