package com.nhnacademy.quiz;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

public class Quiz01 {
    public static void main(String[] args) {
        int start = Integer.parseInt(args[0]);
        int end = Integer.parseInt(args[1]);
        List<Integer> openPorts = new ArrayList<>();

        for (int port = start; port <= end; port++) {
            try (Socket socket = new Socket("localhost", port)) {
                openPorts.add(port);
            } catch (UnknownHostException e) {
                System.err.println("unknown host " + e.getMessage());
            } catch (IOException e) {
                System.err.println("socket connection invalid " + e.getMessage());
            }
        }

        System.out.print("Opened ports: ");
        for (Integer port : openPorts) {
            System.out.print(port + "\t");
        }
    }
}
