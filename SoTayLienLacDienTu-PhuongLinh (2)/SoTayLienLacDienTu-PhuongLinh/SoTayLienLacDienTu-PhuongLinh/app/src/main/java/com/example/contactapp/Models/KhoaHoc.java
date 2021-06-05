package com.example.contactapp.Models;

import java.util.List;

public class KhoaHoc {
private String Id;
    private String Tenlop;

    public KhoaHoc(){}

    public KhoaHoc(String tenlop) {

      Tenlop=tenlop;

    }
    public String getTenlop() {
        return Tenlop;
    };
    public void setTenlop(String tenlop){this.Tenlop=tenlop;}

}
