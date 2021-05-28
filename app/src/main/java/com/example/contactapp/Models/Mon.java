package com.example.contactapp.Models;

public class Mon {  //class môn học
    private String Id;
    private  String Name;
    private String Khoa;

    public Mon(){}

    public Mon( String Name, String Khoa) {
       this.Name = Name;
        this.Khoa = Khoa;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id=Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = Name;
    }

    public String getKhoa() {
        return Khoa;
    }

    public void setKhoa(String khoa) {
        this.Khoa = Khoa;
    }
}
