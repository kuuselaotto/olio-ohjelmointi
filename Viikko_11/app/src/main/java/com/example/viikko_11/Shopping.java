package com.example.viikko_11;

import java.util.Date;

public class Shopping {

    private String name;
    private Date date;

    public Shopping(String name, Date date) {

        this.name = name;
        this.date = date;
    }

    public Date getDate() {return date;}

    public void setName(String name) {this.name = name;}

    public String getName() {
        return name;
    }

}
