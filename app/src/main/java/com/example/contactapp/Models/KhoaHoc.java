package com.example.contactapp.Models;

import java.util.List;

public class KhoaHoc {
    private int Id;
    private List<Lop> lstLop;
    public KhoaHoc(){}

    public KhoaHoc(int id, List<Lop> lstLop) {

        Id = id;
        this.lstLop = lstLop;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public List<Lop> getLstLop() {
        return lstLop;
    }

    public void setLstLop(List<Lop> lstLop) {
        this.lstLop = lstLop;
    }
}
