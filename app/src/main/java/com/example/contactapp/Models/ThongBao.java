package com.example.contactapp.Models;

import java.util.Date;
import java.util.List;

public class ThongBao {
    private String Id;
    private  String NoiDung;
    private  String NguoiGui;
    private List<String> lstNguoiNhan;
    private Date NgayGui;

    public ThongBao(){}

    public ThongBao(String id, String noiDung, String nguoiGui, List<String> lstNguoiNhan, Date ngayGui) {
        Id = id;
        NoiDung = noiDung;
        NguoiGui = nguoiGui;
        this.lstNguoiNhan = lstNguoiNhan;
        NgayGui = ngayGui;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getNoiDung() {
        return NoiDung;
    }

    public void setNoiDung(String noiDung) {
        NoiDung = noiDung;
    }

    public String getNguoiGui() {
        return NguoiGui;
    }

    public void setNguoiGui(String nguoiGui) {
        NguoiGui = nguoiGui;
    }

    public List<String> getLstNguoiNhan() {
        return lstNguoiNhan;
    }

    public void setLstNguoiNhan(List<String> lstNguoiNhan) {
        this.lstNguoiNhan = lstNguoiNhan;
    }

    public Date getNgayGui() {
        return NgayGui;
    }

    public void setNgayGui(Date ngayGui) {
        NgayGui = ngayGui;
    }
}
