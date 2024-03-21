package com.nhnacademy.quiz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Quiz10 {
    public static void main(String[] args) {
        String host = "localhost";
        int port = 1234;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (!Thread.currentThread().isInterrupted()) {
                Socket socket = serverSocket.accept();
                System.out.println("Connected: " + socket.getInetAddress().getHostName());

                BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String input;
                while (!(input = br.readLine()).equals("exit")) {
                    socket.getOutputStream().write(input.getBytes());
                    socket.getOutputStream().write('\n');
                    socket.getOutputStream().flush();
                }

                System.out.println("Connection closed: " + socket.getInetAddress().getHostName());
                br.close();
                socket.close();
                serverSocket.close();
            }
        } catch (IOException e) {
            System.err.print("[ E ]");
            System.err.println(e.getMessage());
        }

        System.out.println("S H U T D O W N");
    }
}
