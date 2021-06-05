package com.example.contactapp.Model;

public class BaiTapSV {
    private String Id;
    private String BaiTap;
    private String Comment;
    private Integer Diem;
    private String NgayNop;
    private String SinhVien;
    private String ThoiGian;

    public BaiTapSV(){

    }
    public BaiTapSV(String id, String baiTap, String comment, Integer diem, String ngayNop, String sinhVien, String thoiGian) {
        Id = id;
        BaiTap = baiTap;
        Comment = comment;
        Diem = diem;
        NgayNop = ngayNop;
        SinhVien = sinhVien;
        ThoiGian = thoiGian;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getBaiTap() {
        return BaiTap;
    }

    public void setBaiTap(String baiTap) {
        BaiTap = baiTap;
    }

    public String getComment() {
        return Comment;
    }

    public void setComment(String comment) {
        Comment = comment;
    }

    public Integer getDiem() {
        return Diem;
    }

    public void setDiem(Integer diem) {
        Diem = diem;
    }

    public String getNgayNop() {
        return NgayNop;
    }

    public void setNgayNop(String ngayNop) {
        NgayNop = ngayNop;
    }

    public String getSinhVien() {
        return SinhVien;
    }

    public void setSinhVien(String sinhVien) {
        SinhVien = sinhVien;
    }

    public String getThoiGian() {
        return ThoiGian;
    }

    public void setThoiGian(String thoiGian) {
        ThoiGian = thoiGian;
    }
}
