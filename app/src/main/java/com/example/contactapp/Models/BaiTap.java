package com.example.contactapp.Models;

import java.util.Date;
import java.util.List;

public class BaiTap {//bài tập do GV thêm
    private String Id;
    private  String Name;
    private  String NoiDung;
    private  String GiaoVien;
    private String BaiGiang;
    private Date NgayTao;
    private Date Deadline;
    private List<String> lstBTSV;

    public BaiTap() {}

    public BaiTap(String id, String name, String noiDung, String giaoVien, String baiGiang,
                  Date ngayTao, Date deadline, List<String> lstBTSV) {
        Id = id;
        Name = name;
        NoiDung = noiDung;
        GiaoVien = giaoVien;
        BaiGiang = baiGiang;
        NgayTao = ngayTao;
        Deadline = deadline;
        this.lstBTSV = lstBTSV;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getNoiDung() {
        return NoiDung;
    }

    public void setNoiDung(String noiDung) {
        NoiDung = noiDung;
    }

    public String getGiaoVien() {
        return GiaoVien;
    }

    public void setGiaoVien(String giaoVien) {
        GiaoVien = giaoVien;
    }

    public String getBaiGiang() {
        return BaiGiang;
    }

    public void setBaiGiang(String baiGiang) {
        BaiGiang = baiGiang;
    }

    public Date getNgayTao() {
        return NgayTao;
    }

    public void setNgayTao(Date ngayTao) {
        NgayTao = ngayTao;
    }

    public Date getDeadline() {
        return Deadline;
    }

    public void setDeadline(Date deadline) {
        Deadline = deadline;
    }

    public List<String> getLstBTSV() {
        return lstBTSV;
    }

    public void setLstBTSV(List<String> lstBTSV) {
        this.lstBTSV = lstBTSV;
    }
}
