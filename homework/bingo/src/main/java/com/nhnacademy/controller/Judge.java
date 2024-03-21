package com.nhnacademy.controller;

import com.nhnacademy.model.Player;
import com.nhnacademy.model.Turn;

public class Judge extends Thread {
    PlayerController player1;
    PlayerController player2;
    Turn turn;

    public Judge(PlayerController player1, PlayerController player2, Turn turn) {
        this.player1 = player1;
        this.player2 = player2;
        this.turn = turn;
    }

    @Override
    public void run() {
        System.out.println("* J U D G E");
        while (true) {
            if (player1.getLastMove() != null && player2.getLastMove() != null) {
                System.out.println("* [P #" + player1.player.getId() + "]: " + player1.getLastMove());
                System.out.println("* [P #" + player2.player.getId() + "]: " + player2.getLastMove());
                turn.setTurn();
            }
        }
    }
}
