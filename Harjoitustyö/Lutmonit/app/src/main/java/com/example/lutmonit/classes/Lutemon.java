package com.example.lutmonit.classes;

import com.example.lutmonit.R;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.time.Duration;
import java.time.Period;

public class Lutemon implements Serializable {

    private String name, color;
    private int attack, defense, experience, health, maxHealth;
    private int image;
    private Date dateTrained;

    public Lutemon(String name, String color) {
        this.name = name;
        this.color = color;
        this.experience = 0;

        switch (color) {
            case "Valkoinen":
                this.attack = 5;
                this.defense = 4;
                this.maxHealth = 20;
                this.health = 20;
                this.image = R.drawable.lutemon_valkonen;
                break;

            case "Vihreä":
                this.attack = 6;
                this.defense = 3;
                this.maxHealth = 19;
                this.health = 19;
                this.image = R.drawable.lutemon_vihree;
                break;

            case "Pinkki":
                this.attack = 7;
                this.defense = 2;
                this.maxHealth = 18;
                this.health = 18;
                this.image = R.drawable.lutemon_pinkki;
                break;

            case "Oranssi":
                this.attack = 8;
                this.defense = 1;
                this.maxHealth = 17;
                this.health = 17;
                this.image = R.drawable.lutemon_oranssi;
                break;

            case "Musta":
                this.attack = 9;
                this.defense = 0;
                this.maxHealth = 16;
                this.health = 16;
                this.image = R.drawable.lutemon_musta;
                break;
        }
    }
    public Lutemon getLutemon() {
        return this;
    }
    public int getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getExperience() {
        return experience;
    }

    public int getHealth() {
        return health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }
    public void giveExperience() {
        this.experience++;
    }
    public void setHealthToMax() {
        this.health = maxHealth;
    }
    public void defense(Lutemon lutemon, int experience) {
        // Lutemons fight
        if (lutemon.getAttack() - this.defense > 0) {

            int damage = (lutemon.getAttack() + experience) - this.defense;
            this.health -= damage;

        }
    }
}
