package com.nhnacademy.quiz.quiz07;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class MQuiz07 {
    public static void main(String[] args) {
        // 받는 것을 쓰레드로 받으면 될 것이다.
        String host = "localhost";
        int port = 1234;

        try (Socket socket = new Socket(host, port)) {
            System.out.println("서버에 연결되었습니다.");

            Thread thread = new Thread(() -> {
                try {
                    String line;
                    BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    while (!(line = reader.readLine()).equals("exit")) {
                        System.out.println(line);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            thread.start();

            // while (!thread.isInterrupted())
            // ; // 이게 없으면 main 스레드가 닫히면서 소켓도 닫혀버림
            String line;
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            while (!(line = br.readLine()).equals("exit")) {
                writer.write(line);
                writer.write('\n');
                writer.flush();
            }
        } catch (Exception ignore) {
            System.err.println(host + ":" + port + "에 연결할 수 없습니다.");
        }
    }
}
