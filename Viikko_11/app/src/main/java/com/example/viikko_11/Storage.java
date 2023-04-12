package com.example.viikko_11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Storage {

    private static Storage storage;
    private ArrayList<Shopping> shoppings = new ArrayList<>();

    public Storage() {

    }
    public static Storage getInstance() {
        if (storage == null) {
            storage = new Storage();
        }
        return storage;
    }
    public Shopping getShoppingById(int id) {

        return shoppings.get(id);
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
    public void removeShopping(String id) {

        int i = 0;
        for (Shopping shopping : shoppings) {
            if (shopping.getName().equals(id)) {
                break;
            }
            i++;
        }

        shoppings.remove(i);
    }
    public ArrayList<Shopping> getShoppings() {return shoppings;}
    public void addShopping(Shopping shopping) {shoppings.add(shopping);}
}
