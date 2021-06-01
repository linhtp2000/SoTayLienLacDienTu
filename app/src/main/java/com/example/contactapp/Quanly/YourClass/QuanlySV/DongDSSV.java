package com.example.contactapp.Quanly.YourClass.QuanlySV;

public class DongDSSV {
    String Name;
    String MSSV;
    public DongDSSV(){

    }

    public DongDSSV(String name, String MSSV) {
        Name = name;
        this.MSSV = MSSV;
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
}
