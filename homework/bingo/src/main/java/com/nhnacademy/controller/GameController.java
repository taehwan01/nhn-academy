package com.nhnacademy.controller;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

import com.nhnacademy.model.Turn;

public class GameController {
    private int port = 1234;
    private int maxPlayers = 2;
    private int squares;
    private int playerCount = 0;
    private Socket[] sockets;
    private PlayerController[] players;
    private Turn turn;

    public GameController(int port, int squares) {
        this(port, 2, squares);
    }

    public GameController(int port, int maxPlayers, int squares) {
        this.port = port;
        this.maxPlayers = maxPlayers;
        this.squares = squares;
        this.sockets = new Socket[maxPlayers];
        this.players = new PlayerController[maxPlayers];
        turn = new Turn(maxPlayers);
    }

    public void start() {
        System.out.println("* S T A R T");
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            Socket socket1 = serverSocket.accept();
            Socket socket2 = serverSocket.accept();
            PlayerController player1 = new PlayerController(socket1, socket2, squares, turn);
            PlayerController player2 = new PlayerController(socket2, socket1, squares, turn);
            Judge judge = new Judge(player1, player2, turn);

            alertGameStart(socket1, socket2);

            player1.start();
            player2.start();
            judge.start();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public void alertGameStart(Socket socket1, Socket socket2) {
        try {
            BufferedWriter player1Writer = new BufferedWriter(new OutputStreamWriter(socket1.getOutputStream()));
            BufferedWriter player2Writer = new BufferedWriter(new OutputStreamWriter(socket2.getOutputStream()));
            player1Writer.write("* 총 " + maxPlayers + "명의 참가자가 모두 들어왔습니다! 게임을 시작합니다!");
            player1Writer.write("\n");
            player1Writer.flush();
            player2Writer.write("* 총 " + maxPlayers + "명의 참가자가 모두 들어왔습니다! 게임을 시작합니다!");
            player2Writer.write("\n");
            player2Writer.flush();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
