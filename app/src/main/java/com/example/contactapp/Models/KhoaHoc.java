package com.example.contactapp.Models;

import java.util.List;

public class KhoaHoc {
    private String Lop;
    private String Id;
    public KhoaHoc(){}

    public KhoaHoc(String Lop) {
        this.Lop = Lop;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getTenLop() {
        return Lop;
    }

    public void setLstLop(String Lop) {
        this.Lop = Lop;
    }
}
