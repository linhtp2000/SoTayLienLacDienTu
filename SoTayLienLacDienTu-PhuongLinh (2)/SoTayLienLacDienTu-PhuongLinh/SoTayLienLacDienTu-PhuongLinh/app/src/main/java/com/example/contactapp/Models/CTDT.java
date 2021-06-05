package com.example.contactapp.Models;

import java.util.Dictionary;

public class CTDT {   //class chương trình đào tạo, cho biết các môn cần học của SV
    private String Id;
    private  Khoa Khoa;
    private SinhVien SinhVien;
    private Dictionary<Mon, String> lstMon;
    public CTDT(){}

    public CTDT(String id, Khoa khoa, SinhVien sinhVien, Dictionary<Mon, String> lstMon) {
        Id = id;
        Khoa = khoa;
        SinhVien = sinhVien;
        this.lstMon = lstMon;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public Khoa getKhoa() {
        return Khoa;
    }

    public void setKhoa(Khoa khoa) {
        Khoa = khoa;
    }

    public SinhVien getSinhVien() {
        return SinhVien;
    }

    public void setSinhVien(SinhVien sinhVien) {
        SinhVien = sinhVien;
    }

    public Dictionary<Mon, String> getLstMon() {
        return lstMon;
    }

    public void setLstMon(Dictionary<Mon, String> lstMon) {
        this.lstMon = lstMon;
    }
}
