package com.example.contactapp.Models;

import java.util.Timer;

public class BaiGiang {  //class phân công giảng dạy
    private String Id;
    private  Khoa Khoa;
    private  Mon Mon;
    private HocKy HocKy;
    private  GiaoVien GiaoVien;
    private  String Thu;  //thứ
    private Timer ThoiGian;      //thời gian bắt đầu tiết học
    private String Phong;    //phòng học

    public BaiGiang(){}

    public BaiGiang(String id, Khoa khoa, Mon mon, HocKy hocKy,
                    GiaoVien giaoVien, String thu, Timer thoiGian, String phong) {
        Id = id;
        Khoa = khoa;
        Mon = mon;
        HocKy = hocKy;
        GiaoVien = giaoVien;
        Thu = thu;
        ThoiGian = thoiGian;
        Phong = phong;
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

    public Mon getMon() {
        return Mon;
    }

    public void setMon(Mon mon) {
        Mon = mon;
    }

    public HocKy getHocKy() {
        return HocKy;
    }

    public void setHocKy(HocKy hocKy) {
        HocKy = hocKy;
    }

    public GiaoVien getGiaoVien() {
        return GiaoVien;
    }

    public void setGiaoVien(GiaoVien giaoVien) {
        GiaoVien = giaoVien;
    }

    public String getThu() {
        return Thu;
    }

    public void setThu(String thu) {
        Thu = thu;
    }

    public Timer getThoiGian() {
        return ThoiGian;
    }

    public void setThoiGian(Timer thoiGian) {
        ThoiGian = thoiGian;
    }

    public String getPhong() {
        return Phong;
    }

    public void setPhong(String phong) {
        Phong = phong;
    }
}
