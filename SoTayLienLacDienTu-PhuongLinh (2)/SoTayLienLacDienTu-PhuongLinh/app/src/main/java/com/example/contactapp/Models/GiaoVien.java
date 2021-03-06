package com.example.contactapp.Models;

public class GiaoVien {
    private String Id;
    private  String Name;
    private  String Phone;
    private  String Email;

    public GiaoVien(){}

    public GiaoVien (String Name, String Phone, String Email) {

        this.Name = Name;
        this.Phone = Phone;
        this.Email = Email;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        this.Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name)  {this.Name = name;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        this.Phone = phone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        this.Email = email;
    }
}
