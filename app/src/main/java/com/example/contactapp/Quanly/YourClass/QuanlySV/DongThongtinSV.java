package com.example.contactapp.Quanly.YourClass.QuanlySV;

public class DongThongtinSV {
    String Name,MSSV,Phone,Address,Lop,Email;
public DongThongtinSV(){

}
    public DongThongtinSV(String name, String MSSV, String phone, String address, String lop, String email) {
        Name = name;
        this.MSSV = MSSV;
        Phone = phone;
        Address = address;
        Lop = lop;
        Email = email;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getMSSV() {
        return MSSV;
    }

    public void setMSSV(String MSSV) {
        this.MSSV = MSSV;
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

    public String getLop() {
        return Lop;
    }

    public void setLop(String lop) {
        Lop = lop;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
}
