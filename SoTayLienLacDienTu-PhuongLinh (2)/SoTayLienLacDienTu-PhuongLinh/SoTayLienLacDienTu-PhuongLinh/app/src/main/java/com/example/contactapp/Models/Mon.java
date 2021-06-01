package com.example.contactapp.Models;

public class Mon {  //class môn học
    private String Id;
    private  String Name;
    private Khoa Khoa;

    public Mon(){}

    public Mon(String id, String name, com.example.contactapp.Models.Khoa khoa) {
        Id = id;
        Name = name;
        Khoa = khoa;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Khoa getKhoa() {
        return Khoa;
    }

    public void setKhoa(Khoa khoa) {
        Khoa = khoa;
    }
}
