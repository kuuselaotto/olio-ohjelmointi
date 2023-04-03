package com.example.viikko9;

import android.content.Context;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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

    public void saveUsers(Context context) {
        try {
            ObjectOutputStream userWriter = new ObjectOutputStream(context.openFileOutput("users.data", Context.MODE_PRIVATE));
            userWriter.writeObject(users);
            userWriter.close();

        } catch (IOException e) {
            System.out.println("Käyttäjien tallentaminen ei onnistunut.");
            e.printStackTrace();

        }


    }

    public void loadUsers(Context context) {

        try {
            ObjectInputStream userReader = new ObjectInputStream(context.openFileInput("users.data"));
            users = (ArrayList<User>) userReader.readObject();
            userReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("Käyttäjien lataaminen ei onnistunut.");
            e.printStackTrace();
        }
        catch (IOException e) {
            System.out.println("Käyttäjien lataaminen ei onnistunut.");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Käyttäjien lataaminen ei onnistunut.");
            e.printStackTrace();
        }

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
