package com.example.contactapp.Models;

import java.util.List;

public class KhoaHoc {
    private List<String>Lop;
    private String Id;
    public KhoaHoc(){}

    public KhoaHoc(List<String>Lop) {
        this.Lop = Lop;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public List<String> getTenLop() {
        return Lop;
    }

    public void setLstLop(List<String>Lop) {
        this.Lop = Lop;
    }

    public KhoaHoc(String name, List<String> lop) {
        Lop = lop;
    }
    public List<String> getLop() {
        return Lop;
    }

    public void setLop(List<String> lop) {
        Lop = lop;
    }
}
