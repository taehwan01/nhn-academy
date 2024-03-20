package com.nhnacademy.quiz.quiz07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ReaderRunner implements Runnable {
    Socket socket;
    String line;
    BufferedReader reader;

    public ReaderRunner(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while (!(line = reader.readLine()).equals("exit")) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
