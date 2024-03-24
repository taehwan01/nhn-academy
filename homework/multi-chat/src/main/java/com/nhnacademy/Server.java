package com.nhnacademy;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.json.JSONObject;

public class Server {
    int id = 0;
    // List<Socket> socketList;
    List<Thread> threadList;
    // List<Client> clientList;
    Map<Client, Socket> clientSocketMap;

    public Server() {
        // socketList = new ArrayList<>();
        threadList = new ArrayList<>();
        // clientList = new ArrayList<>();
        clientSocketMap = new HashMap<>();
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
                Client newClient = new Client(this, System.in, System.out, socket.getInputStream(),
                        socket.getOutputStream());
                addClient(newClient, socket);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
        }
    }

    Client getClient(String clientId) {
        // clientSocketMap iterator
        for (Map.Entry<Client, Socket> entry : clientSocketMap.entrySet()) {
            if (entry.getKey().getClientId().equals(clientId)) {
                return entry.getKey();
            }
        }
        return null;
    }

    void getCommand(String clientId, String command) {
        JSONObject jsonCommand = new JSONObject(command);
        String type = jsonCommand.getString("type");
        if (type.equals("message")) {
            String targetId = jsonCommand.getString("target_id");
            String message = jsonCommand.getString("message");
            Client sender = getClient(clientId);
            Client receiver = getClient(targetId);
            sendDirectMessage(message, sender, receiver);
        }
    }

    void addClient(Client newClient, Socket socket) {
        clientSocketMap.put(newClient, socket);

        JSONObject info = newClient.getInfo();
        id++;
        String type = info.getString("type");
        String clientId = info.getString("client_id");
        JSONObject response = new JSONObject().put("id", id).put("type", type);
        response.put("client_id", clientId);

        if (isExistingClient(newClient)) {
            denyClient(socket, response);
            return;
        } else {
            acceptClient(socket, newClient, response, id);
        }

        Thread thread = new Thread(newClient);
        threadList.add(thread);
        thread.start();
    }

    public boolean isExistingClient(Client newClient) {
        String newClientId = newClient.getClientId().toString();
        if (getClient(newClientId) != null) {
            return true;
        }
        return false;
    }

    public void denyClient(Socket socket, JSONObject response) {
        try {
            response.put("response", "deny");
            socket.getOutputStream().write(response.toString().getBytes());
            socket.getOutputStream().write("\n".getBytes());
            socket.getOutputStream().flush();
            socket.close();
            clientSocketMap.remove(clientSocketMap.size() - 1);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public void acceptClient(Socket socket, Client newClient, JSONObject response, int id) {
        try {
            response.put("response", "ok");
            socket.getOutputStream().write(response.toString().getBytes());
            socket.getOutputStream().write("\n".getBytes());
            socket.getOutputStream().flush();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    void sendToAll(String message) {
        // for (Socket socket : socketList) {
        // try {
        // socket.getOutputStream().write(message.getBytes());
        // socket.getOutputStream().write("\n".getBytes());
        // socket.getOutputStream().flush();
        // } catch (IOException e) {
        // System.err.println(e.getMessage());
        // }
        // }
    }

    void sendDirectMessage(String Message, Client sender, Client receiver) {

    }
}