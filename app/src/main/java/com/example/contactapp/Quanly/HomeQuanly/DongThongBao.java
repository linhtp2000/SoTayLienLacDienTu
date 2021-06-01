package com.example.contactapp.Quanly.HomeQuanly;

public class DongThongBao {
    String NgayGui,NguoiGui,NoiDung,Title;
    public DongThongBao(){

    }

    public DongThongBao( String ngayGui, String nguoiGui, String noiDung, String title) {
        NgayGui = ngayGui;
        NguoiGui = nguoiGui;
        NoiDung = noiDung;
        Title = title;
    }



    public String getNgayGui() {
        return NgayGui;
    }

    public void setNgayGui(String ngayGui) {
        NgayGui = ngayGui;
    }

    public String getNguoiGui() {
        return NguoiGui;
    }

    public void setNguoiGui(String nguoiGui) {
        NguoiGui = nguoiGui;
    }

    public String getNoiDung() {
        return NoiDung;
    }

    public void setNoiDung(String noiDung) {
        NoiDung = noiDung;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }
}
