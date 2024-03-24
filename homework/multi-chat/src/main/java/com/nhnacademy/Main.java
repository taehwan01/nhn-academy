package com.nhnacademy;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;

public class Main {
    static List<Socket> socketList = new ArrayList<>();
    static List<Thread> clientList = new ArrayList<>();

    public static void main(String[] args) {
        startServer(portOption(args));
    }

    static int portOption(String[] args) {
        int port = 1234;
        Options options = new Options();
        CommandLineParser parser = new DefaultParser();
        try {
            CommandLine commandLine = parser.parse(options, args);
            if (commandLine.hasOption("p")) {
                port = Integer.parseInt(commandLine.getOptionValue("p"));
            }
        } catch (org.apache.commons.cli.ParseException e) {
            System.err.println(e.getMessage());
        }
        return port;
    }

    static void startServer(int port) {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server started.");

            while (true) {
                Socket socket = serverSocket.accept();
                addClient(socket);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    static void addClient(Socket socket) {
        try {
            socketList.add(socket);
            Thread thread = new Thread(
                    new Netcat(System.in, System.out, socket.getInputStream(), socket.getOutputStream()));
            clientList.add(thread);
            thread.start();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}