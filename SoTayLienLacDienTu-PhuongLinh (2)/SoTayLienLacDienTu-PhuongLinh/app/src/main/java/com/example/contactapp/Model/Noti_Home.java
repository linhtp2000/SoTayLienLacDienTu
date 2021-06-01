package com.example.contactapp.Model;

public class Noti_Home {
    private String Title;
    private String NoiDung;
    private String NguoiGui;
    private String NgayGui;
    private Noti_Home(){

    }
    public Noti_Home(String title, String noiDung, String nguoiGui, String ngayGui) {
        this.Title = title;
        this.NoiDung = noiDung;
        this.NguoiGui = nguoiGui;
        this.NgayGui = ngayGui;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        this.Title = title;
    }

    public String getNoiDung() {
        return NoiDung;
    }

    public void setNoiDung(String noiDung) {
        this.NoiDung = noiDung;
    }

    public String getNguoiGui() {
        return NguoiGui;
    }

    public void setNguoiGui(String nguoiGui) {
        this.NguoiGui = nguoiGui;
    }

    public String getNgayGui() {
        return NgayGui;
    }

    public void setNgayGui(String ngayGui) {
        this.NgayGui = ngayGui;
    }
}
