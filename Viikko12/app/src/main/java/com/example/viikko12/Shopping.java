package com.example.viikko12;

import java.util.Date;

public class Shopping {

    private String name;
    private Date date;
    private boolean important;

    public Shopping(String name, Date date, boolean important) {
        this.name = name;
        this.date = date;
        this.important = important;
    }

    public boolean getImportant() {
        return important;
    }

    public String getName() {
        return name;
    }

    public Date getDate() {
        return date;
    }

    public void setName(String name) {
        this.name = name;
    }
}
