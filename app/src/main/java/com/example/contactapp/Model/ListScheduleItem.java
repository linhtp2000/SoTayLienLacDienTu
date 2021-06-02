package com.example.contactapp.Model;

public class ListScheduleItem {

    private String id;
    private String Day;
    private String Name;
    private String Time;

    public ListScheduleItem(){

    }
    public ListScheduleItem(String id, String day, String name, String time) {
        this.id = id;
        Day = day;
        Name = name;
        Time = time;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDay() {
        return Day;
    }

    public void setDay(String day) {
        Day = day;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }
}
