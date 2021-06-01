package com.example.contactapp.Model;

public class Deadline_item {
    private String SinhVien;
    private String Name;
    private String GiaoVien;
    private Object BaiTapSV;
    private String NoiDung;
    private String NgayTao;
    private String Deadline;
    private String ThoiGianNop;
    private String ThoiGianTao;
    private String BaiGiang;


    public String getBaiGiang() {
        return BaiGiang;
    }

    public void setBaiGiang(String baiGiang) {
        BaiGiang = baiGiang;
    }

    public Deadline_item(){

    }

    public String getDeadline() {
        return Deadline;
    }

    public void setDeadline(String deadline) {
        Deadline = deadline;
    }

    public Deadline_item(String key, String name, String deadline, String giaoVien, Object baitapSV, String noiDung, String baigiang, String ngayTao, String thoiGianNop, String thoiGianTao) {
        this.SinhVien=key;
        this.Name = name;
        this.Deadline=deadline;
        this.GiaoVien = giaoVien;
        this.BaiTapSV = baitapSV;
        this.NoiDung = noiDung;
        this.NgayTao = ngayTao;
        this.BaiGiang=baigiang;
        this.ThoiGianNop = thoiGianNop;
        this.ThoiGianTao = thoiGianTao;
    }

    public String getKey() {
        return SinhVien;
    }

    public void setKey(String key) {
        this.SinhVien = key;
    }


    public Object getBaitapSV() {
        return BaiTapSV;
    }

    public String getGiaoVien() {
        return GiaoVien;
    }

    public void setGiaoVien(String giaoVien) {
        this.GiaoVien = giaoVien;
    }

    public void setBaitapSV(Object baitapSV) {
        this.BaiTapSV = baitapSV;
    }

    public String getNgayTao() {
        return NgayTao;
    }

    public void setNgayTao(String ngayTao) {
        this.NgayTao = ngayTao;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public String getNoiDung() {
        return NoiDung;
    }

    public void setNoiDung(String noiDung) {
        this.NoiDung = noiDung;
    }

//    public String getHanNop() {
//        return hanNop;
//    }
//
//    public void setHanNop(String hanNop) {
//        this.hanNop = hanNop;
//    }

    public String getThoiGianNop() {
        return ThoiGianNop;
    }

    public void setThoiGianNop(String thoiGianNop) {
        this.ThoiGianNop = thoiGianNop;
    }

    public String getThoiGianTao() {
        return ThoiGianTao;
    }

    public void setThoiGianTao(String thoiGianTao) {
        this.ThoiGianTao = thoiGianTao;
    }
}
