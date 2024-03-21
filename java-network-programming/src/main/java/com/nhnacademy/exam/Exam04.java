package com.nhnacademy.exam;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Exam04 {
    public static void main(String[] args) {
        String host = "localhost";
        int port = 1234;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (!Thread.currentThread().isInterrupted()) {
                Socket socket = serverSocket.accept();

                System.out.println("Connected: " + socket.getInetAddress().getHostName());
                socket.getOutputStream().write("Hello, world!".getBytes());
                socket.getOutputStream().flush();
                socket.close();
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
