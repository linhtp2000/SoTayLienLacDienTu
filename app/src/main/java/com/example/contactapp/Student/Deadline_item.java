package com.example.contactapp.Student;

public class Deadline_item {
    public String title;
    public String debcription;
    public String date;
    public String time;

    public Deadline_item(String title, String debcription, String date, String time) {
        this.title = title;
        this.debcription = debcription;
        this.date = date;
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDebcription() {
        return debcription;
    }

    public void setDebcription(String debcription) {
        this.debcription = debcription;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
