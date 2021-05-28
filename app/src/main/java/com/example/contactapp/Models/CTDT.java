package com.example.contactapp.Models;

import java.util.Dictionary;

public class CTDT {   //class chương trình đào tạo, cho biết các môn cần học của SV
    private String Id;
    private  String Khoa;
    private String SinhVien;
    private Dictionary<String, String> lstMon;
    public CTDT(){}

    public CTDT(String Id, String Khoa, String SinhVien, Dictionary<String, String> Mon) {
        this.Id = Id;
        this.SinhVien = SinhVien;
        this.lstMon = Mon;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getKhoa() {
        return Khoa;
    }

    public void setKhoa(String khoa) {
        Khoa = khoa;
    }

    public String getSinhVien() {
        return SinhVien;
    }

    public void setSinhVien(String sinhVien) {
        SinhVien = sinhVien;
    }

    public Dictionary<String, String> getLstMon() {
        return lstMon;
    }

    public void setLstMon(Dictionary<String, String> lstMon) {
        this.lstMon = lstMon;
    }
}
