package com.nhnacademy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.net.Socket;
import java.util.concurrent.atomic.AtomicReference;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.json.JSONObject;

public class Main {
    static final String VERSION = "HTTP/1.1";
    static final int PORT = 80;

    public static void main(String[] args) {
        Options options = new MyOptions().getMyOptions();

        CommandLineParser parser = new DefaultParser();
        String command = null;
        String location = null;
        String hostUrl = null;
        String header = null;
        // JSONObject data = null;
        String data = null;
        boolean showHeader = false;

        try {
            CommandLine line = parser.parse(options, args);
            if (line.hasOption("X")) {
                command = line.getOptionValue("X"); // GET
                location = "/" + command.toLowerCase(); // /get
            } else {
                // X는 없고 d만 있다면 default로 POST
                if (line.hasOption("d")) {
                    command = "POST";
                    location = "/" + command.toLowerCase();
                    data = line.getOptionValue("d");
                } else {
                    command = "GET"; // 아무것도 명시되어있지 않을 때
                }
            }
            if (line.hasOption("d")) {
                data = line.getOptionValue("d");
            }
            if (line.hasOption("H")) {
                header = line.getOptionValue("H");
            }
            if (line.hasOption("v")) {
                showHeader = true;
            }

            hostUrl = line.getArgs()[0];
            if (line.hasOption("L")) {
                location = hostUrl.substring(hostUrl.indexOf("/"));
                hostUrl = hostUrl.split("/")[0];
            }

            // try with resource 안에 try with resource 사용 시 2번째 try가 종료되면 첫번째 호출자의 자원도 반납됨
            do {
                location = connect(hostUrl, PORT, command, location, header, data, showHeader);
            } while (!location.equals("/get"));
            connect(hostUrl, PORT, command, location, header, data, showHeader);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private static String connect(String hostUrl, int port, String command, String location, String header, String data,
            boolean showHeader) {
        try (Socket socket = new Socket(hostUrl, PORT)) {
            sendRequest(socket, command, location, hostUrl, header, data);

            System.out.println("\nResponse from \"" + hostUrl + "\":");

            location = getResponse(socket, showHeader);
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
        return location;
    }

    private static void sendRequest(
            Socket socket, String command, String location, String hostUrl, String header, String data)
            throws IOException {
        PrintStream writer = new PrintStream(socket.getOutputStream());
        writer.printf("%s %s %s%n", command, location, VERSION);
        writer.printf("Host: %s%n", hostUrl);
        if (data != null) {
            writer.printf("Content-Length: %d%n", data.length());
        }
        if (header != null) {
            writer.printf("%s%n", header);
        }
        writer.printf("Connection: close%n");
        writer.printf("%n");

        if (data != null) {
            writer.printf(data);
        }
    }

    private static String getResponse(Socket socket, boolean showHeader) throws InterruptedException {
        AtomicReference<String> location = new AtomicReference<>("/get");
        final boolean finalShowHeader = showHeader;
        Thread receiver = new Thread(() -> {
            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String input;
                String output = "";
                while ((input = br.readLine()) != null) {
                    if (input.startsWith("location:")) {
                        location.set(input.split(" ")[1]);
                    }
                    output += input + "\n";
                }
                if (finalShowHeader) {
                    System.out.println(output);
                } else {
                    System.out.println(output.split("\n\n")[1]);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        receiver.start();
        receiver.join();
        return location.get();
    }
}