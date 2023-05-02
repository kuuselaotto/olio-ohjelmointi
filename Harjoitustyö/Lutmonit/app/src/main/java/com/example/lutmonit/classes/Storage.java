package com.example.lutmonit.classes;

import android.content.Context;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Storage {
    private ArrayList<Lutemon> lutemonsHome;
    private ArrayList<Lutemon> lutemonsTraining;
    private ArrayList<Lutemon> lutemonsBattle;
    private Lutemon lutemon;
    private static Storage storage;

    public Storage() {
        lutemonsHome = new ArrayList<>();
        lutemonsTraining = new ArrayList<>();
        lutemonsBattle = new ArrayList<>();
    }

    public Lutemon getLutemonByName(String name, ArrayList<Lutemon> list) {
        // Getting lutemon by its name
        list.forEach(lutemon1 -> {

            if (lutemon1.getName().equals(name)) {
                lutemon = lutemon1;
            }
        });
        return lutemon;
    }
    public void loadLutemons(Context context) {
        try {
            // Reading lutemons home
            ObjectInputStream lutemonReaderHome = new ObjectInputStream(context.openFileInput("lutemonsHome.data"));
            lutemonsHome = (ArrayList<Lutemon>) lutemonReaderHome.readObject();
            lutemonReaderHome.close();

            // Reading lutemons training
            ObjectInputStream lutemonReaderTraining = new ObjectInputStream(context.openFileInput("lutemonsTraining.data"));
            lutemonsTraining = (ArrayList<Lutemon>) lutemonReaderTraining.readObject();
            lutemonReaderTraining.close();

            // Reading lutemons battle
            ObjectInputStream lutemonReaderBattle = new ObjectInputStream(context.openFileInput("lutemonsBattle.data"));
            lutemonsBattle = (ArrayList<Lutemon>) lutemonReaderBattle.readObject();
            lutemonReaderBattle.close();

            System.out.println("Loaded lutemons.");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Loading lutemons failed.");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Loading lutemons failed.");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Loading lutemons failed.");
        }
    }

    public void moveLutemon(Lutemon lutemon, String fromWhere, String toWhere) {

        switch (fromWhere) {
            // Moving lutemon from home to battle or training
            case "Home":
                if (toWhere.equals("Battle")) {
                    lutemonsBattle.add(lutemon);
                } else if (toWhere.equals("Training")) {
                    lutemonsTraining.add(lutemon);
                }
                lutemonsHome.remove(lutemon);
                break;
            // Moving lutemon from training to home or battle
            case "Training":
                if (toWhere.equals("Battle")) {
                    lutemonsBattle.add(lutemon);
                } else if (toWhere.equals("Home")) {
                    // Giving max health to lutemon when moving back to home
                    lutemon.setHealthToMax();
                    lutemonsHome.add(lutemon);
                }
                lutemonsTraining.remove(lutemon);
                break;
            // Moving lutemon from battle to home or training
            case "Battle":
                if (toWhere.equals("Home")) {
                    // Giving max health to lutemon when moving back to home
                    lutemon.setHealthToMax();
                    lutemonsHome.add(lutemon);
                } else if (toWhere.equals("Training")) {
                    lutemonsTraining.add(lutemon);
                }
                lutemonsBattle.remove(lutemon);
                break;
        }
    }
    public void saveLutemons(Context context) {
        try {
            // Saving lutemons home
            ObjectOutputStream lutemonWriterHome = new ObjectOutputStream(context.openFileOutput("lutemonsHome.data", Context.MODE_PRIVATE));
            lutemonWriterHome.writeObject(lutemonsHome);
            lutemonWriterHome.close();

            // Saving lutemons training
            ObjectOutputStream lutemonWriterTraining = new ObjectOutputStream(context.openFileOutput("lutemonsTraining.data", Context.MODE_PRIVATE));
            lutemonWriterTraining.writeObject(lutemonsTraining);
            lutemonWriterTraining.close();

            // Saving lutemons battle
            ObjectOutputStream lutemonWriterBattle = new ObjectOutputStream(context.openFileOutput("lutemonsBattle.data", Context.MODE_PRIVATE));
            lutemonWriterBattle.writeObject(lutemonsBattle);
            lutemonWriterBattle.close();

            System.out.println("Lutemons saved.");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Saving lutemons failed.");
        }
    }
    public static Storage getInstance() {

        if (storage == null) {
            storage = new Storage();
        }
        return storage;
    }
    public void addLutemon(Lutemon lutemon) {
        // Adding a new lutemon to home list by default
        lutemonsHome.add(lutemon);
    }
    public ArrayList<Lutemon> getLutemonsHome() {
        return lutemonsHome;
    }
    public ArrayList<Lutemon> getLutemonsBattle() {
        return lutemonsBattle;
    }
    public ArrayList<Lutemon> getLutemonsTraining() {
        return lutemonsTraining;
    }
}