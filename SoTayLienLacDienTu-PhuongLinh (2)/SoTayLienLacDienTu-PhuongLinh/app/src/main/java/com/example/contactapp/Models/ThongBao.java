package com.example.contactapp.Models;

import java.util.Date;
import java.util.List;

public class ThongBao {
    private String Id;
    private  String NoiDung;
    private  String NguoiGui;
    private List<String> NguoiNhan;
    private Date NgayGui;

    public ThongBao(){}

    public ThongBao(String Id, String NoiDung, String NguoiGui, List<String> NguoiNhan, Date NgayGui) {
       this.Id = Id;
        this.NoiDung = NoiDung;
        this.NguoiGui = NguoiGui;
        this.NguoiNhan = NguoiNhan;
        this.NgayGui = NgayGui;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getNoiDung() {
        return NoiDung;
    }

    public void setNoiDung(String NoiDung) {
        this.NoiDung = NoiDung;
    }

    public String getNguoiGui() {
        return NguoiGui;
    }

    public void setNguoiGui(String NguoiGui) {
        this.NguoiGui = NguoiGui;
    }

    public List<String> getLstNguoiNhan() {
        return NguoiNhan;
    }

    public void setLstNguoiNhan(List<String> NguoiNhan) {
        this.NguoiNhan = NguoiNhan;
    }

    public Date getNgayGui() {
        return NgayGui;
    }

    public void setNgayGui(Date NgayGui) {
        this.NgayGui = NgayGui;
    }
}
