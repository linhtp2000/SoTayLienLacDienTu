package com.example.contactapp.Model;

public class BaiGiang {
    private String key;
    private Object GiaoVien;
    private String HocKy;
    private String Khoa;
    private Long KhoaHoc;
    private String Mon;
    private String Name;
    private String Phong;
    private String ThoiGian;
    private String Thu;
    public BaiGiang(){

    }
    public BaiGiang(String key, Object giaoVien, String hocKy, String khoa, Long khoaHoc, String mon, String name, String phong, String thoiGian, String thu) {
        this.key = key;
        GiaoVien = giaoVien;
        HocKy = hocKy;
        Khoa = khoa;
        KhoaHoc = khoaHoc;
        Mon = mon;
        Name = name;
        Phong = phong;
        ThoiGian = thoiGian;
        Thu = thu;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Object getGiaoVien() {
        return GiaoVien;
    }

    public void setGiaoVien(Object giaoVien) {
        GiaoVien = giaoVien;
    }

    public String getHocKy() {
        return HocKy;
    }

    public void setHocKy(String hocKy) {
        HocKy = hocKy;
    }

    public String getKhoa() {
        return Khoa;
    }

    public void setKhoa(String khoa) {
        Khoa = khoa;
    }

    public Long getKhoaHoc() {
        return KhoaHoc;
    }

    public void setKhoaHoc(Long khoaHoc) {
        KhoaHoc = khoaHoc;
    }

    public String getMon() {
        return Mon;
    }

    public void setMon(String mon) {
        Mon = mon;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPhong() {
        return Phong;
    }

    public void setPhong(String phong) {
        Phong = phong;
    }

    public String getThoiGian() {
        return ThoiGian;
    }

    public void setThoiGian(String thoiGian) {
        ThoiGian = thoiGian;
    }

    public String getThu() {
        return Thu;
    }

    public void setThu(String thu) {
        Thu = thu;
    }
}
