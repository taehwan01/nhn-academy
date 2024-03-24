package com.nhnacademy.quiz.simpleNC;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.ParseException;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;

public class SimpleNC {
    public static void main(String[] args) {
        Options options = new Options();

        options.addOption("l", true, "Listen");

        CommandLineParser parser = new DefaultParser();
        try {
            CommandLine commandLine = parser.parse(options, args);

            if (commandLine.hasOption("l")) {
                List<Thread> clientHandlerList = new LinkedList<>();

                ServerSocket serverSocket = new ServerSocket(1234);
                while (!Thread.currentThread().isInterrupted()) {
                    Socket socket = serverSocket.accept();
                    try {
                        Thread thread = new Thread(
                                new NetCat(socket.getInputStream(),
                                        socket.getOutputStream(),
                                        socket.getInputStream(),
                                        socket.getOutputStream()));
                        thread.start();
                        clientHandlerList.add(thread);
                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                    }
                }
                serverSocket.close();
            } else {
                try (Socket socket = new Socket("localhost", 1234)) {
                    Thread thread = new Thread(
                            new NetCat(System.in, System.out, socket.getInputStream(), socket.getOutputStream()));
                    thread.start();
                    thread.join();
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }
            }
        } catch (org.apache.commons.cli.ParseException | IOException e) {
        }
    }
}