package com.nhnacademy.quiz;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.net.Socket;
import java.util.Scanner;

public class Quiz05 {
    public static void main(String[] args) {
        String host = "localhost";
        int port = 1234;

        try (Socket socket = new Socket(host, port)) {
            System.out.println("서버에 연결되었습니다.");

            String line;
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            while (!(line = reader.readLine()).equals("exit")) {
                System.out.println(line);
                writer.write(line);
                writer.write('\n');
                writer.flush();
            }

        } catch (Exception ignore) {
            System.err.println(host + ":" + port + "에 연결할 수 없습니다.");
        }
    }
}