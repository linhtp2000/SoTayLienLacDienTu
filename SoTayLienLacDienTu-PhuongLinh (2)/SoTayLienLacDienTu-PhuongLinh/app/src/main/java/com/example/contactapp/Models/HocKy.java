package com.example.contactapp.Models;

public class HocKy { //class học kỳ
    private  int HocKy;    //HỌC KỲ
    private  int Nam;
    public HocKy(){}

    public HocKy(int HocKy, int Nam) {
        this.HocKy = HocKy;
        this.Nam = Nam;
    }

    public int getHK() {
        return HocKy;
    }

    public void setHK(int HocKy) {
        this.HocKy = HocKy;
    }

    public int getNam() {
        return Nam;
    }

    public void setNam(int Nam) {
        this.Nam = Nam;
    }
}
