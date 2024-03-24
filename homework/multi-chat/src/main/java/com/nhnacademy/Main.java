package com.nhnacademy;

public class Main {
    public static void main(String[] args) {
        Server server = new Server();
        int port = server.portOption(args);
        server.startServer(port);
    }
}
