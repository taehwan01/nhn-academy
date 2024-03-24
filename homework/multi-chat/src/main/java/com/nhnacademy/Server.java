package com.nhnacademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

public class Server {
    int id = 0;
    // List<Socket> socketList;
    List<Thread> threadList;
    // List<Client> clientList;
    Map<Client, Socket> clientSocketMap;
    Logger logger = LogManager.getLogger(this.getClass().getSimpleName());

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
            logger.error(e.getMessage());
        }
        return port;
    }

    void startServer(int port) {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            logger.trace("Server started.");

            Thread host = new Thread(() -> {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                while (true) {
                    try {
                        String hostCommand = reader.readLine();
                        JSONObject jsonCommand = new JSONObject(hostCommand);
                        String command = jsonCommand.getString(Constants.TYPE);
                        getHostCommand(command);
                    } catch (IOException e) {
                        logger.error(e.getMessage());
                    }
                }
            });
            host.start();

            // Server는 종료하지 않는다.
            do {
                Socket socket = serverSocket.accept();
                Client newClient = new Client(this, System.in, System.out, socket.getInputStream(),
                        socket.getOutputStream());
                addClient(newClient, socket);
            } while (clientSocketMap.size() > 0); // Server가 왜 종료 안 하지...

            logger.trace(Constants.SHUT_DOWN);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    Client getClient(String clientId) {
        // clientSocketMap iterator
        for (Map.Entry<Client, Socket> entry : clientSocketMap.entrySet()) {
            if (entry.getKey().getClientId().toString().equals(clientId)) {
                return entry.getKey();
            }
        }
        return null;
    }

    void getHostCommand(String command) {
        JSONObject response = new JSONObject();
        if (command.contains("send_off")) {
            StringTokenizer st = new StringTokenizer(command);
            st.nextToken();
            String clientId = st.nextToken();
            Client client = getClient(clientId);
            Socket clientSocket = clientSocketMap.get(client);
            try {
                logger.trace(String.format("Client %s를 강퇴시켰습니다.", clientId));
                clientSocketMap.remove(client);
                clientSocket.close();
            } catch (IOException e) {
                logger.error(e.getMessage());
            }
        } else {
            if (command.contains(Constants.CLIENT_LIST)) {
                JSONArray clientList = new JSONArray();
                for (Map.Entry<Client, Socket> entry : clientSocketMap.entrySet()) {
                    clientList.put(entry.getKey().getClientId());
                }
                response.put(Constants.ID, id).put(Constants.CMD, Constants.CLIENT_LIST).put(Constants.CLIENT_ID,
                        clientList);
                logger.trace(response);
            }
        }
    }

    void getCommand(String clientId, String command) {
        JSONObject jsonCommand = new JSONObject(command);
        String type = jsonCommand.getString(Constants.TYPE);
        if (type.equals(Constants.MESSAGE)) {
            String targetId = jsonCommand.getString(Constants.TARGET_ID);
            String message = jsonCommand.getString(Constants.MESSAGE);
            Client sender = getClient(clientId);
            Client receiver = getClient(targetId);
            // System.out.println(sender.getClientId());
            // System.out.println(receiver.getClientId());
            sendDirectMessage(message, sender, receiver);
        }
    }

    void addClient(Client newClient, Socket socket) {

        JSONObject info = newClient.getInfo();
        id++;
        String type = info.getString(Constants.TYPE);
        String clientId = info.getString(Constants.CLIENT_ID);
        JSONObject response = new JSONObject().put(Constants.ID, id).put(Constants.TYPE, type);
        response.put(Constants.CLIENT_ID, clientId);

        if (isExistingClient(newClient)) {
            denyClient(socket, response);
            return;
        } else {
            acceptClient(socket, newClient, response);
        }

        Thread thread = new Thread(newClient);
        threadList.add(thread);
        thread.start();
    }

    public boolean isExistingClient(Client newClient) {
        String newClientId = newClient.getClientId().toString();
        return getClient(newClientId) != null;
    }

    public void denyClient(Socket socket, JSONObject response) {
        try {
            response.put(Constants.RESPONSE, Constants.DENY);
            socket.getOutputStream().write(response.toString().getBytes());
            socket.getOutputStream().write("\n".getBytes());
            socket.getOutputStream().flush();
            socket.close();
            Client deniedClient = getClient(response.getString(Constants.CLIENT_ID));
            clientSocketMap.remove(deniedClient);
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }

    public void acceptClient(Socket socket, Client newClient, JSONObject response) {
        try {
            response.put(Constants.RESPONSE, Constants.OK);
            socket.getOutputStream().write(response.toString().getBytes());
            socket.getOutputStream().write("\n".getBytes());
            socket.getOutputStream().flush();
            clientSocketMap.put(newClient, socket);
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }

    void sendDirectMessage(String message, Client sender, Client receiver) {
        String senderId = sender.getClientId().toString();
        Socket receiverSocket = clientSocketMap.get(receiver);
        JSONObject jsonMessage = new JSONObject().put(Constants.ID, id).put(Constants.TYPE, Constants.MESSAGE)
                .put(Constants.CLIENT_ID, senderId)
                .put(Constants.MESSAGE, message);
        try {
            receiverSocket.getOutputStream().write(jsonMessage.toString().getBytes());
            receiverSocket.getOutputStream().write("\n".getBytes());
            receiverSocket.getOutputStream().flush();
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }
}