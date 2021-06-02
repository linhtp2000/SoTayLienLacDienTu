package com.example.contactapp.Model;

public class ScheduleKey {
    private String keyBaiGiang;
    public ScheduleKey(){

    }
    public ScheduleKey(String id, String keyBaiGiang) {
        this.keyBaiGiang = keyBaiGiang;
    }

//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }

    public String getKeyBaiGiang() {
        return keyBaiGiang;
    }

    public void setKeyBaiGiang(String keyBaiGiang) {
        this.keyBaiGiang = keyBaiGiang;
    }
}
