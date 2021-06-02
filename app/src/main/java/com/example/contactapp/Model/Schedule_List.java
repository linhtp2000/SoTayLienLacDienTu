package com.example.contactapp.Model;

public class Schedule_List {
    private String id;
    private Object BaiGiang;
    private String SinhVien;



    public Schedule_List(){

    }
    public Schedule_List(String id,Object listbaiGiang) {
        this.id=id;
        this.BaiGiang = listbaiGiang;
    }
//    public Object getBaiGiang() {
//        return BaiGiang;
//    }
//
//    public void setBaiGiang(Object baiGiang) {
//        BaiGiang = baiGiang;
//    }

    public String getIdSinhVien() {
        return SinhVien;
    }

    public void setIdSinhVien(String idSinhVien) {
        this.SinhVien = idSinhVien;
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

//    public Object getBaiGiang() {
//        return BaiGiang;
//    }

//    public void setBaiGiang(Object listbaiGiang) {
//        this.BaiGiang = listbaiGiang;
//    }
}
