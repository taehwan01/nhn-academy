package com.nhnacademy.quiz.snc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    int port = 1234;

    public Server(int port) {
        this.port = port;
    }

    public void connect() {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (!Thread.currentThread().isInterrupted()) { // Server thread 종료 방지 -> ServerSocket close 방지
                Socket socket = serverSocket.accept();
                System.out.println("[CLIENT] " + socket.getInetAddress().getHostAddress()
                        + socket.getInetAddress().getHostName() + " 접속했습니다.");

                Thread thread = new Thread(() -> {
                    try {
                        String messageFromClient;
                        BufferedReader clientReader = new BufferedReader(
                                new InputStreamReader(socket.getInputStream()));
                        BufferedWriter serverWriter = new BufferedWriter(new OutputStreamWriter(System.out));
                        while (!((messageFromClient = clientReader.readLine()).equals("exit"))) {
                            serverWriter.write("[CLIENT]: " + messageFromClient + "\n");
                            serverWriter.flush();
                        }
                        clientReader.close();
                        serverWriter.close();
                    } catch (IOException e) {
                        System.err.println(e.getMessage());
                    }
                });
                thread.start();

                String messageFromServer;
                BufferedReader serverReader = new BufferedReader(new InputStreamReader(System.in)); // 서버에서 입력 받음
                BufferedWriter clientWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())); // 클라이언트로출력보냄
                while (!((messageFromServer = serverReader.readLine()).equals("exit"))) {
                    clientWriter.write("[SERVER]: " + messageFromServer + "\n");
                    clientWriter.flush();
                }
                serverReader.close();
                clientWriter.close();
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
