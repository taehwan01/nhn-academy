package com.nhnacademy.exam;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Exam01 {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 12345)) {
            System.out.println("successfully connected to the server");
        } catch (UnknownHostException e) {
            System.err.println("unknown host " + e.getMessage());
        } catch (IOException e) {
            System.err.println("socket 생성 exception" + e.getMessage());
        }
    }
}
