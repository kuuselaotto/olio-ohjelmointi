package com.example.viikko12;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Storage {

    private static Storage storage;
    private ArrayList<Shopping> shoppings = new ArrayList<Shopping>();
    private ArrayList<Shopping> shoppingsImportant = new ArrayList<Shopping>();

    public Storage() {

    }

    public static Storage getInstance() {
        if (storage == null) {
            storage = new Storage();
        }
        return storage;
    }

    public ArrayList<Shopping> getShoppingsImportant() {
        return shoppingsImportant;
    }
    public Shopping getShoppingById(int id) {
        return shoppings.get(id);
    }
    public Shopping getShoppingImportantById(int id) {
        return shoppingsImportant.get(id);
    }

    public ArrayList<Shopping> sortByTime() {

        Collections.sort(shoppings, new Comparator<Shopping>() {
            @Override
            public int compare(Shopping shopping, Shopping t1) {
                return shopping.getDate().compareTo(t1.getDate());
            }
        });
        return shoppings;
    }

    public ArrayList<Shopping> sortByNames() {
        Collections.sort(shoppings, new Comparator<Shopping>() {
            @Override
            public int compare(Shopping shopping, Shopping t1) {
                return shopping.getName().compareTo(t1.getName());
            }
        });
        return shoppings;
    }

    public void deleteImportantShopping(String id) {
        int i = 0;
        for (Shopping shopping : shoppingsImportant) {
            if (shopping.getName().equals(id)) {
                break;
            }
            i++;
        }
        shoppingsImportant.remove(i);
    }
    public void deleteShopping(String id) {
        int i = 0;
        for (Shopping shopping: shoppings) {
            if (shopping.getName().equals(id)) {
                break;
            }
            i++;
        }
        shoppings.remove(i);
    }
    public ArrayList<Shopping> getShoppings() {
        return shoppings;
    }

    public void addShopping(Shopping shopping) {

        if (shopping.getImportant()) {
            shoppingsImportant.add(shopping);
        } else {
            shoppings.add(shopping);
        }
    }
}
