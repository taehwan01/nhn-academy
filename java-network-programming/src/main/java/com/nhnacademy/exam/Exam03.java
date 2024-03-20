package com.nhnacademy.exam;

import java.net.Socket;
import java.util.Scanner;

public class Exam03 {
    public static void main(String[] args) {
        String host = "localhost";
        int port = 1234;
        String input;
        int ch;
        Scanner sc = new Scanner(System.in);

        try (Socket socket = new Socket(host, port)) {
            System.out.println("서버에 연결되었습니다.");
            // input = sc.nextLine();
            // while (!input.equals("exit")) {
            // socket.getOutputStream().write(input.getBytes());
            // socket.getOutputStream().write('\n');
            // input = sc.nextLine();
            // }
            while ((ch = socket.getInputStream().read()) >= 0) {
                System.out.write(ch);
            }
            // socket.getOutputStream().write("Good Bye!\n".getBytes());
        } catch (Exception ignore) {
            System.err.println(host + ":" + port + "에 연결할 수 없습니다.");
        }
    }
}