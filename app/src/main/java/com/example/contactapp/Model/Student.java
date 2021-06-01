package com.example.contactapp.Model;

public class Student {
    private String id;
    private String Email;
    private String Lop;
    private String Phone;
    private String Name;
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

    public Student(){
        //Nhận data từ fireBase
    }

    public Student(String id, String email, String lop, String phone, String name , String address,String mssv) {
        this.Address=address;
        this.MSSV=mssv;
        this.id = id;
        Email = email;
        Lop = lop;
        Phone = phone;
        Name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getLop() {
        return Lop;
    }

    public void setLop(String lop) {
        Lop = lop;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
