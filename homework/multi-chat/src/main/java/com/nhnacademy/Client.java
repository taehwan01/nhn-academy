package com.nhnacademy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Objects;
import java.util.UUID;

import org.json.JSONObject;

public class Client implements Runnable {
    static int count = 0;
    // int id = ++count;
    int id = 1;
    UUID clientId = UUID.randomUUID();
    Server server;
    InputStream localInputStream;
    OutputStream localOutputStream;
    InputStream remoteInputStream;
    OutputStream remoteOutputStream;

    public Client(Server server, InputStream localInputStream,
            OutputStream localOutputStream,
            InputStream remoteInputStream,
            OutputStream remoteOutputStream) {
        this.server = server;
        this.localInputStream = localInputStream;
        this.localOutputStream = localOutputStream;
        this.remoteInputStream = remoteInputStream;
        this.remoteOutputStream = remoteOutputStream;
    }

    public JSONObject getInfo() {
        // return String.format("{ \"id\" : %d, \"type\" : \"connect\", \"client_id\" :
        // \"%s\"}", id, clientId);
        return new JSONObject().put("id", id).put("type", "connect").put("client_id", clientId.toString());
    }

    @Override
    public boolean equals(Object otherClient) {
        if (otherClient instanceof Client) {
            return id == ((Client) otherClient).id;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
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
                        server.sendToAll(line);
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
        } catch (IOException | InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println(e.getMessage());
        }
    }
}
