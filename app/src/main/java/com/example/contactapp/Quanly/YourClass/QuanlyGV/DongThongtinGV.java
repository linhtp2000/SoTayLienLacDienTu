package com.example.contactapp.Quanly.YourClass.QuanlyGV;

public class DongThongtinGV {
    String Name,Email,MSGV,Phone,Address;
    public DongThongtinGV(){

    }

    public DongThongtinGV(String name, String email, String MSGV, String phone, String address) {
        Name = name;
        Email = email;
        this.MSGV = MSGV;
        Phone = phone;
        Address = address;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getMSGV() {
        return MSGV;
    }

    public void setMSGV(String MSGV) {
        this.MSGV = MSGV;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }
}
