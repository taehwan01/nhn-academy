package com.nhnacademy;

import java.util.Random;

import com.nhnacademy.controller.GameController;

public class Main {
    public static void main(String[] args) {
        GameController game = new GameController(1234, 2, 5);
        game.start();
    }
}
// try {
// PlayerController currentPlayer;
// for (int i = 0; i < maxPlayers; i++) {
// synchronized (this) {
// currentPlayer = players[turn];
// BufferedWriter playerWriter = new BufferedWriter(
// new OutputStreamWriter(sockets[i].getOutputStream()));

// if (i == turn) {
// playerWriter.write("* 당신의 차례입니다.");
// System.out.println(players[turn].getLastMove());
// } else {
// playerWriter.write("* P #" + (turn + 1) + " " + "의 차례입니다.");
// }
// playerWriter.write("\n");
// playerWriter.flush();

// if (turn == maxPlayers - 1) {
// turn = 0;
// } else {
// turn++;
// }
// }
// }
// } catch (IOException e) {
// System.err.println(e.getMessage());
// }