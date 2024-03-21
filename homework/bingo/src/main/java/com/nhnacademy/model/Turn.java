package com.nhnacademy.model;

public class Turn {
    int turn;
    int maxPlayers;

    public Turn(int maxPlayers) {
        turn = 0;
        this.maxPlayers = maxPlayers;
    }

    public int getTurn() {
        return turn;
    }

    public synchronized void setTurn() {
        turn = (turn + 1) % maxPlayers;
        notifyAll();
        try {
            wait();
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }
    }
}
