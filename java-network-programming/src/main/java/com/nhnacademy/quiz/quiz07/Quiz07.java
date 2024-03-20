package com.nhnacademy.quiz.quiz07;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Quiz07 {
    public static void main(String[] args) {
        // 받는 것을 쓰레드로 받으면 될 것이다.
        String host = "localhost";
        int port = 1234;

        try (Socket socket = new Socket(host, port)) {
            System.out.println("서버에 연결되었습니다.");

            // MReader reader = new MReader(new InputStreamReader(socket.getInputStream()));
            ReaderRunner readerRunner = new ReaderRunner(socket);
            Thread readerThread = new Thread(readerRunner);
            readerThread.start();

            String input;
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            while (!(input = br.readLine()).equals("exit")) {
                writer.write(input);
                writer.write('\n');
                writer.flush();
            }

        } catch (Exception ignore) {
            System.err.println(host + ":" + port + "에 연결할 수 없습니다.");
        }
    }
}
