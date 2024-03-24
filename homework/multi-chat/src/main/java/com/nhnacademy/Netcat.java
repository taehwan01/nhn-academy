package com.nhnacademy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class Netcat implements Runnable {
    InputStream localInputStream;
    OutputStream localOutputStream;
    InputStream remoteInputStream;
    OutputStream remoteOutputStream;

    public Netcat(InputStream localInputStream,
            OutputStream localOutputStream,
            InputStream remoteInputStream,
            OutputStream remoteOutputStream) {
        this.localInputStream = localInputStream;
        this.localOutputStream = localOutputStream;
        this.remoteInputStream = remoteInputStream;
        this.remoteOutputStream = remoteOutputStream;
    }

    public void run() {
        try (
                BufferedReader localReader = new BufferedReader(new InputStreamReader(localInputStream));
                BufferedWriter localWriter = new BufferedWriter(new OutputStreamWriter(localOutputStream));
                BufferedReader remoteReader = new BufferedReader(new InputStreamReader(remoteInputStream));
                BufferedWriter remoteWriter = new BufferedWriter(new OutputStreamWriter(remoteOutputStream))) {

            Thread receiver = new Thread(() -> {
                try {
                    String line;
                    while ((line = remoteReader.readLine()) != null) {
                        localWriter.write(line);
                        localWriter.write("\n");
                        localWriter.flush();
                    }
                } catch (IOException e) {
                    System.err.println(e.getMessage());
                }
            });

            Thread sender = new Thread(() -> {
                try {
                    String line;
                    while ((line = localReader.readLine()) != null) {
                        remoteWriter.write(line);
                        remoteWriter.write("\n");
                        remoteWriter.flush();
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
        }
    }
}
