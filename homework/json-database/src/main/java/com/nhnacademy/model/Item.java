package com.nhnacademy.model;

public class Item {
    private String id;
    private String model;
    private int hp;
    private int atk;
    private int def;
    private int mov;
    private int agi;

    public Item(String id, String model, int hp, int atk, int def, int mov, int agi) {
        this.id = id;
        this.model = model;
        this.hp = hp;
        this.atk = atk;
        this.def = def;
        this.mov = mov;
        this.agi = agi;
    }

    public String getID() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public int getHP() {
        return hp;
    }

    public int getATK() {
        return atk;
    }

    public int getDEF() {
        return def;
    }

    public int getMOV() {
        return mov;
    }

    public int getAGI() {
        return agi;
    }
}
