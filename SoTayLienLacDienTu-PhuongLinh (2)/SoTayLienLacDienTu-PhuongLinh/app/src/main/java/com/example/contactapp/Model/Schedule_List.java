package com.example.contactapp.Model;

public class Schedule_List {
    public String id;
    public Object BaiGiang;

    public Schedule_List(){

    }
    public Schedule_List(String id,Object listbaiGiang) {
        this.id=id;
        this.BaiGiang = listbaiGiang;
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
