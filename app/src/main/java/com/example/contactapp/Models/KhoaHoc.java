package com.example.contactapp.Models;

import java.util.List;

public class KhoaHoc {
    private String Id;
    private String Tenlop;
    public KhoaHoc(){}

    public KhoaHoc(String id, String Lop) {

        Id = id;
        this.Tenlop = Lop;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getTenLop() {
        return Tenlop;
    }

    public void setLstLop(String Lop) {
        this.Tenlop = Lop;
    }
}
