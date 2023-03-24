package com.example.viikko9;

public class User {

    private String firstName, lastName, email, degreeProgram;
    protected int image;

    public User(String firstName, String lastName, String email, String degreeProgram, String imgIndex) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.degreeProgram = degreeProgram;
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

    public String getFirstName() {

        return firstName;
    }

    public int getImage() {
        return image;
    }

    public String getLastName() {

        return lastName;
    }

    public String getEmail() {

        return email;
    }

    public String getDegreeProgram() {

        return degreeProgram;
    }

}
