package com.example.contactapp.Models;

public class Khoa {  //class Khoa
    private String Id;
    private  String Name;
    public Khoa(){}
    public Khoa(String Id, String Name) {
        this.Id = Id;
        this.Name = Name;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name){this.Name = Name;}

}