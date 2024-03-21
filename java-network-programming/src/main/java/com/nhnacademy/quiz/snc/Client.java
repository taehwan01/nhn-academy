package com.nhnacademy.quiz.snc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
    private String host = "localhost";
    private int port = 1234;

    public Client(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void connect() {
        try (Socket socket = new Socket(host, port)) {
            System.out.println("Server에 연결되었습니다.");

            // Server 메시지 받는 쓰레드
            Thread thread = new Thread(() -> {
                try {
                    String messageFromServer;
                    BufferedReader serverReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    BufferedWriter clientWriter = new BufferedWriter(new OutputStreamWriter(System.out));
                    while (!(messageFromServer = serverReader.readLine()).equals("exit")) {
                        clientWriter.write("[SERVER]: " + messageFromServer + "\n");
                        clientWriter.flush();
                    }
                    serverReader.close();
                    clientWriter.close();
                } catch (IOException e) {
                    System.err.println(e.getMessage());
                } catch (Exception e) {
                    System.err.println(e.getMessage()); // null?
                }
            });

            thread.start();

            // Client 메시지 전송자
            String messageFromClient;
            BufferedReader clientReader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter serverWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            while (!(messageFromClient = clientReader.readLine()).equals("exit")) {
                serverWriter.write("[CLIENT]: " + messageFromClient + "\n");
                serverWriter.flush();
            }

            serverWriter.close();
            clientReader.close();
        } catch (UnknownHostException e) {
            // System.err.println("* 알 수 없는 host 연결 시도 / " + e.getMessage());
            System.err.println(e.getMessage());
        } catch (IOException e) {
            // System.err.println("* 유효하지 않은 소켓 연결 시도 / " + e.getMessage());
            System.err.println(e.getMessage());
        }
    }
}
