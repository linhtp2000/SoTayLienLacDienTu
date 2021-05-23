package com.example.contactapp.Student;

public class Expire_Home {
    private String title;
    private String debcription;
    private String time;

    public Expire_Home(String title, String debcription, String time) {
        this.title = title;
        this.debcription = debcription;
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
