package com.example.contactapp.Models;

import java.io.Serializable;
import java.util.Timer;

public class BaiGiang implements Serializable {  //class phân công giảng dạy
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

    public BaiGiang(String Id,String Name, String Khoa, String Mon, String HocKy,
                    String GiaoVien, String Thu, String ThoiGian, String Phong, int KhoaHoc) {
        this.Id = Id;
        this.Name=Name;
        this.Khoa = Khoa;
        this.Mon = Mon;
        this.HocKy = HocKy;
        this.GiaoVien = GiaoVien;
        this.Thu = Thu;
        this.ThoiGian = ThoiGian;
        this.Phong = Phong;
        this.KhoaHoc=KhoaHoc;

    }
    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name=Name;
    }
    public int getKhoaHoc() {
        return KhoaHoc;
    }

    public void setKhoaHoc(int KhoaHoc) { this.KhoaHoc=KhoaHoc;

    }
    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getKhoa() {
        return Khoa;
    }

    public void setKhoa(String Khoa) {
        this.Khoa = Khoa;
    }

    public String getMon() {
        return Mon;
    }

    public void setMon(String Mon) {
        this.Mon = Mon;
    }

    public String getHocKy() {
        return HocKy;
    }

    public void setHocKy(String HocKy) {
        this.HocKy = HocKy;
    }

    public String getGiaoVien() {
        return GiaoVien;
    }

    public void setGiaoVien(String GiaoVien) {
        this.GiaoVien = GiaoVien;
    }

    public String getThu() {
        return Thu;
    }

    public void setThu(String Thu){ this.Thu = Thu;
    }

    public String getThoiGian() {
        return ThoiGian;
    }

    public void setThoiGian(String ThoiGian) {
        this.ThoiGian = ThoiGian;
    }

    public String getPhong() {
        return Phong;
    }

    public void setPhong(String Phong) {
        this.Phong = Phong;
    }
}
