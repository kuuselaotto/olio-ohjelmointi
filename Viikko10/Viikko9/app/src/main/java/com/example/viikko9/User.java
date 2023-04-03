package com.example.viikko9;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;

public class User implements java.io.Serializable {

    private String firstName, lastName, email, degreeProgram;
    private StringBuilder degrees;
    protected int image;

    public User(String firstName, String lastName, String email, String degreeProgram, String imgIndex, StringBuilder degrees) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.degreeProgram = degreeProgram;
        this.degrees = degrees;

        switch (imgIndex) {
            case "Android":
                this.image = R.drawable.ic_action_user;
                break;
            case "User":
                this.image = R.drawable.ic_action_android;
                break;
            case "Smile":
                this.image = R.drawable.ic_action_emo_basic;
                break;
            case "Cool":
                this.image = R.drawable.ic_action_emo_cool;
        }

    }
    public StringBuilder getDegrees() {
        return degrees;
    }

    public String getFirstName() { return firstName; }

    public int getImage() {
        return image;
    }

    public String getLastName() { return lastName; }

    public String getEmail() { return email; }

    public String getDegreeProgram() { return degreeProgram; }

}
