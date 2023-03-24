package com.example.viikko9;

import java.util.ArrayList;

public final class UserStorage {

    private static UserStorage INSTANCE;

    ArrayList<User> users = new ArrayList<>();

    public UserStorage() {

    }

    public static UserStorage getInstance() {

        if (INSTANCE == null) {
            INSTANCE = new UserStorage();
        }

        return INSTANCE;
    }

    public ArrayList<User> getUser() {

        return users;
    }

    public void addUser(User user) {

        users.add(user);
    }

    public void removeUser(int id) {

        users.remove(id);
    }

}
