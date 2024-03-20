package com.nhnacademy.quiz;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

public class Quiz03 {
    public static void main(String[] args) {
        String localAddress;
        int localPort;
        String remoteAddress;
        int remotePort;
        int port = 12345;

        try (Socket socket = new Socket("localhost", port)) {
            localAddress = socket.getLocalAddress().getHostAddress();
            remoteAddress = socket.getInetAddress().getHostAddress();
            localPort = socket.getLocalPort();
            remotePort = socket.getPort();
            System.out.println("서버에 연결되었습니다.");
            System.out.println("Local address: " + localAddress);
            System.out.println("Local port: " + localPort);
            System.out.println("Remote address: " + remoteAddress);
            System.out.println("Remote port: " + remotePort);
        } catch (UnknownHostException e) {
            System.err.println("unknown host " + e.getMessage());
        } catch (IOException e) {
            System.err.println("socket connection invalid " + e.getMessage());
        }

    }
}
