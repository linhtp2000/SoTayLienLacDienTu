package com.example.contactapp.Models;

import java.util.Timer;

public class BaiGiang {  //class phân công giảng dạy
    private String Id;
    private  String Name;
    private  String Khoa;
    private  int KhoaHoc;
    private  String Mon;
    private String HocKy;
    private  String GiaoVien;
    private  String Thu;  //thứ
    private String ThoiGian;      //thời gian bắt đầu tiết học
    private String Phong;    //phòng học

    public BaiGiang(){}

    public BaiGiang(String id,String name, String khoa, String mon, String hocKy,
                    String giaoVien, String thu, String thoiGian, String phong, int khoaHoc) {
        Id = id;
        Name=name;
        Khoa = khoa;
        Mon = mon;
        HocKy = hocKy;
        GiaoVien = giaoVien;
        Thu = thu;
        ThoiGian = thoiGian;
        Phong = phong;
        KhoaHoc=khoaHoc;

    }
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
    public int getKhoaHoc() {
        return KhoaHoc;
    }

    public void setKhoaHoc(int khoaHoc) {
        KhoaHoc = khoaHoc;
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

    public String getMon() {
        return Mon;
    }

    public void setMon(String mon) {
        Mon = mon;
    }

    public String getHocKy() {
        return HocKy;
    }

    public void setHocKy(String hocKy) {
        HocKy = hocKy;
    }

    public String getGiaoVien() {
        return GiaoVien;
    }

    public void setGiaoVien(String giaoVien) {
        GiaoVien = giaoVien;
    }

    public String getThu() {
        return Thu;
    }

    public void setThu(String thu) {
        Thu = thu;
    }

    public String getThoiGian() {
        return ThoiGian;
    }

    public void setThoiGian(String thoiGian) {
        ThoiGian = thoiGian;
    }

    public String getPhong() {
        return Phong;
    }

    public void setPhong(String phong) {
        Phong = phong;
    }
}
