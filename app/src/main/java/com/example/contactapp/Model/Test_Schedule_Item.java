package com.example.contactapp.Model;

public class Test_Schedule_Item {
    public String title;
    public String time;
    public String date;

    public Test_Schedule_Item(String title, String time, String date) {
        this.title = title;
        this.time = time;
        this.date = date;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
