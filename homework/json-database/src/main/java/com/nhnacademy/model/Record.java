package com.nhnacademy.model;

public class Record {
    private int plays;
    private int wins;

    public Record(int plays, int wins) {
        this.plays = plays;
        this.wins = wins;
    }

    public int getPlays() {
        return this.plays;
    }

    public int getWins() {
        return this.wins;
    }
}
