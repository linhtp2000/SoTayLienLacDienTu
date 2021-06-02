package com.example.contactapp.Model;

import java.util.HashMap;

public class itemTKB {
    private String id;
    private Object BaiGiang;
    private String SinhVien;

    public itemTKB(){

    }
    public itemTKB(String id, Object baiGiang, String sinhVien) {
        this.id = id;
        BaiGiang = baiGiang;
        SinhVien = sinhVien;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Object getBaiGiang() {
        return BaiGiang;
    }

    public void setBaiGiang(HashMap baiGiang) {
        BaiGiang = baiGiang;
    }

    public String getSinhVien() {
        return SinhVien;
    }

    public void setSinhVien(String sinhVien) {
        SinhVien = sinhVien;
    }
}
