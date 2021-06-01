package com.example.contactapp.Models;

public class Khoa {  //class Khoa
    private String Id;
    private  String Name;
    public Khoa(){}
    public Khoa(String id, String name) {
        Id = id;
        Name = name;
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
}
