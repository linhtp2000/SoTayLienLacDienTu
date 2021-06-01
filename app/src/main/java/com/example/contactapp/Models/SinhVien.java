package com.example.contactapp.Models;

public class SinhVien {
    private String Id;
    private  String Name;
    private String Lop;
    private  String Phone;
    private  String Email;
    private String Address;
    private String MSSV;

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getMSSV() {
        return MSSV;
    }

    public void setMSSV(String MSSV) {
        this.MSSV = MSSV;
    }

    public SinhVien(){}

    public SinhVien(String Id, String Name, String Lop, String Phone, String Email, String address, String Mssv) {
        this.Id = Id;
        this.Name = Name;
        this.Lop = Lop;
        this.Phone = Phone;
        this.Email = Email;
        this.Address=address;
        this.MSSV=Mssv;
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

    public String getLop() {
        return Lop;
    }

    public void setLop(String Lop) {
        this.Lop = Lop;
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

    public void setEmail(String Email) {
        this.Email = Email;
    }
}
