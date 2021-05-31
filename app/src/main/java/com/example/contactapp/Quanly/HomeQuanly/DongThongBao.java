package com.example.contactapp.Quanly.HomeQuanly;

public class DongThongBao {
    String TenThongBao, NoiDungThongBao;

    public DongThongBao(String tenThongBao, String noiDungThongBao) {
        TenThongBao = tenThongBao;
        NoiDungThongBao = noiDungThongBao;
    }

    public String getTenThongBao() {
        return TenThongBao;
    }

    public void setTenThongBao(String tenThongBao) {
        TenThongBao = tenThongBao;
    }

    public String getNoiDungThongBao() {
        return NoiDungThongBao;
    }

    public void setNoiDungThongBao(String noiDungThongBao) {
        NoiDungThongBao = noiDungThongBao;
    }
}
