package com.example.contactapp.Models;

public class HocKy { //class học kỳ
    private  int HK;    //HỌC KỲ
    private  int Nam;
    public HocKy(){}

    public HocKy(int HK, int nam) {
        this.HK = HK;
        Nam = nam;
    }

    public int getHK() {
        return HK;
    }

    public void setHK(int HK) {
        this.HK = HK;
    }

    public int getNam() {
        return Nam;
    }

    public void setNam(int nam) {
        Nam = nam;
    }
}
