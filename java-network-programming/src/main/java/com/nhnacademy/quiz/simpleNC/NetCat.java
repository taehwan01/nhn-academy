package com.nhnacademy.quiz.simpleNC;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class NetCat implements Runnable {
    InputStream inputRemoteStream;
    OutputStream outputRemoteStream;
    InputStream inputLocalStream;
    OutputStream outputLocalStream;

    public NetCat(InputStream inputLocalStream,
            OutputStream outputLocalStream,
            InputStream inputRemoteStream,
            OutputStream outputRemoteStream) {
        this.inputLocalStream = inputLocalStream;
        this.outputLocalStream = outputLocalStream;
        this.inputRemoteStream = inputRemoteStream;
        this.outputRemoteStream = outputRemoteStream;
    }

    public void run() {
        try (BufferedReader inputLocal = new BufferedReader(new InputStreamReader(inputLocalStream));
                BufferedWriter outputLocal = new BufferedWriter(new OutputStreamWriter(outputLocalStream));
                BufferedReader inputRemote = new BufferedReader(new InputStreamReader(inputRemoteStream));
                BufferedWriter outputRemote = new BufferedWriter(new OutputStreamWriter(outputRemoteStream))) {

            Thread receiver = new Thread(() -> {
                try {
                    String line;
                    while ((line = inputRemote.readLine()) != null) {
                        outputLocal.write(line);
                        outputLocal.write("\n");
                        outputLocal.flush();
                    }
                } catch (IOException e) {
                    System.err.println(e.getMessage());
                }
            });

            Thread sender = new Thread(() -> {
                try {
                    String line;
                    while ((line = inputLocal.readLine()) != null) {
                        outputRemote.write(line);
                        outputRemote.write("\n");
                        outputRemote.flush();
                    }
                } catch (IOException e) {
                    System.err.println(e.getMessage());
                }
            });

            receiver.start();
            sender.start();

            receiver.join();
            sender.join();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
        }
    }
}
