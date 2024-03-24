package com.nhnacademy;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.json.JSONObject;

public class Server {
    List<Socket> socketList;
    List<Thread> threadList;
    List<Integer> clientList;

    public Server() {
        socketList = new ArrayList<>();
        threadList = new ArrayList<>();
        clientList = new ArrayList<>();
    }

    int portOption(String[] args) {
        int port = 1234;
        Options options = new Options();
        CommandLineParser parser = new DefaultParser();
        try {
            CommandLine commandLine = parser.parse(options, args);
            if (commandLine.hasOption("p")) {
                port = Integer.parseInt(commandLine.getOptionValue("p"));
            }
        } catch (ParseException e) {
            System.err.println(e.getMessage());
        }
        return port;
    }

    void startServer(int port) {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server started.");

            // Server는 종료하지 않는다.
            while (true) {
                Socket socket = serverSocket.accept();
                addClient(socket);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
        }
    }

    void addClient(Socket socket) {
        try {
            socketList.add(socket);
            Client newClient = new Client(this, System.in, System.out, socket.getInputStream(),
                    socket.getOutputStream());

            JSONObject info = newClient.getInfo();
            int id = info.getInt("id");
            String type = info.getString("type");
            String clientId = info.getString("client_id");
            JSONObject response = new JSONObject().put("id", id).put("type", type);
            response.put("client_id", clientId);

            if (isExistingClient(newClient)) {
                response.put("response", "deny");
                socket.getOutputStream().write(response.toString().getBytes());
                socket.getOutputStream().write("\n".getBytes());
                socket.getOutputStream().flush();
                return;
            } else {
                response.put("response", "ok");
                socket.getOutputStream().write(response.toString().getBytes());
                socket.getOutputStream().write("\n".getBytes());
                socket.getOutputStream().flush();
                clientList.add(newClient.id);
            }

            Thread thread = new Thread(newClient);
            threadList.add(thread);
            thread.start();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public boolean isExistingClient(Client newClient) {
        for (int id : clientList) {
            if (newClient.id == id) {
                return true;
            }
        }
        return false;
    }

    void sendToAll(String message) {
        for (Socket socket : socketList) {
            try {
                socket.getOutputStream().write(message.getBytes());
                socket.getOutputStream().write("\n".getBytes());
                socket.getOutputStream().flush();
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }
    }
}