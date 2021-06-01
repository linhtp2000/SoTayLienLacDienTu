package com.example.contactapp.Models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class BaiTap implements Serializable {//bài tập do GV thêm
    private String Id;
    private  String Name;
    private  String NoiDung;
    private  String GiaoVien;
    private String BaiGiang;
    private String NgayTao;
    private String Deadline;
    private List<String> BaiTapSV;

    public String getNgayTao() {
        return NgayTao;
    }

    public String getDeadline() {
        return Deadline;
    }
    private String ThoiGianNop;
    private String ThoiGianTao;


    public BaiTap() {}

    public BaiTap(String Name, String NoiDung, String GiaoVien, String BaiGiang,
                  String NgayTao, String Deadline, List<String> BaiTapSV, String ThoiGianNop,String ThoiGianTao) {

       this.Name = Name;
        this.NoiDung = NoiDung;
        this.GiaoVien = GiaoVien;
        this.BaiGiang = BaiGiang;
        this.NgayTao = NgayTao;
        this.Deadline = Deadline;
        this.ThoiGianNop=ThoiGianNop;
        this.ThoiGianTao=ThoiGianTao;
        this.BaiTapSV = BaiTapSV;
    }
    public void setNgayTao(String ngayTao){
        this.NgayTao = NgayTao;
    }


    public void setDeadline(String Deadline) {
        this.Deadline = Deadline;
    }

    public String getThoiGianNop() {
        return ThoiGianNop;
    }

    public void setThoiGianNop(String ThoiGianNop) {
        this.ThoiGianNop=ThoiGianNop;
    }

    public String getThoiGianTao() {
        return ThoiGianTao;
    }

    public void setThoiGianTao(String ThoiGianTao) {
        this.ThoiGianTao=ThoiGianTao;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getNoiDung() {
        return NoiDung;
    }

    public void setNoiDung(String NoiDung) {
        this.NoiDung = NoiDung;
    }

    public String getGiaoVien() {
        return GiaoVien;
    }

    public void setGiaoVien(String GiaoVien) {
        this.GiaoVien = GiaoVien;
    }

    public String getBaiGiang() {
        return BaiGiang;
    }

    public void setBaiGiang(String BaiGiang) {
        this.BaiGiang = BaiGiang;
    }

    public List<String> getLstBTSV() {
        return BaiTapSV;
    }

    public void setLstBaiTapSV(List<String> BaiTapSV) {
        this.BaiTapSV = BaiTapSV;
    }
}
