package com.nhnacademy.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

import com.nhnacademy.model.Player;
import com.nhnacademy.model.Turn;

public class PlayerController extends Thread {
    Socket socket;
    Socket other;
    Player player;
    String lastMove;
    boolean hasMoved;
    int squares;
    Turn turn;

    public PlayerController(Socket socket, Socket other, int squares, Turn turn) {
        this.socket = socket;
        this.other = other;
        this.player = new Player(squares);
        this.squares = squares;
        this.turn = turn;
    }

    public String toString() {
        return player.toString();
    }

    public String getLastMove() {
        return lastMove;
    }

    @Override
    public void run() {
        try {
            while (!socket.isClosed()) {
                String input;
                BufferedReader playerReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                BufferedWriter playerWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                BufferedWriter otherWriter = new BufferedWriter(new OutputStreamWriter(other.getOutputStream()));

                playerWriter.write(player.toString());
                playerWriter.write("\n");
                playerWriter.flush();

                input = playerReader.readLine();

                lastMove = input;
                playerWriter.write(player.toString());
                playerWriter.write("\n-------------------------------------------------\n");
                playerWriter.flush();
                otherWriter.write("* [P #" + player.getId() + "]: " + lastMove);
                otherWriter.write("\n");
                otherWriter.flush();
                turn.setTurn();

                // playerReader에 남아있는 데이터를 모두 버림
                while (playerReader.ready()) {
                    playerReader.readLine();
                }
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
