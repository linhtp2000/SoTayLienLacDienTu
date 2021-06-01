package com.example.contactapp.Models;

public class PhuHuynh {  //class phụ huynh
    private String Id;
    private  String Name;
    private String SinhVien;
    private  String Phone;
    private  String Email;

    public PhuHuynh(){}

    public PhuHuynh(String Name,String SinhVien, String Phone, String Email) {
       this.Name = Name;
        this.SinhVien = SinhVien;
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

    public void setName(String Name) {this.Name = Name;
    }

    public String getSinhVien() {
        return SinhVien;
    }

    public void setSinhVien(String SinhVien) {
        this.SinhVien = SinhVien;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {this.Phone = Phone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        this.Email = email;
    }
}
