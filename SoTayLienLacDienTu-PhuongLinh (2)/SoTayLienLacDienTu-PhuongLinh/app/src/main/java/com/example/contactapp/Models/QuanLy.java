package com.example.contactapp.Models;

public class QuanLy {
    private String Id;
    private  String Name;
    private  String Phone;
    private  String Email;

    public QuanLy(){}

    public QuanLy(String Name, String Phone, String Email) {
        this.Name = Name;
        this.Phone = Phone;
        this.Email = Email;
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

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email){this.Email = Email;
    }
}
