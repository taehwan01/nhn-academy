package com.nhnacademy.quiz.snc;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

public class SNC {
    public static void main(String[] args) {
        Options options = new Options();
        CommandLineParser parser = new DefaultParser();
        Option help = new Option("h", "help", false, "Help");
        Option listen = new Option("l", true, "server로 동작시 입력 받은 port로 listen");

        options.addOption(help);
        options.addOption(listen);

        try {
            CommandLine cmd = parser.parse(options, args);

            isValidArguments(args, options);
            helpCommand(cmd, help, options);

            if (cmd.hasOption(listen)) {
                connectServer(args);
            } else {
                clientCommand(args);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.exit(1); // 0일 때는 정상 종료, 1일 때는 비정상 종료
        }
    }

    public static void isValidArguments(String[] args, Options options) {
        if (args.length > 2) {
            System.err.println("* 인자 입력이 너무 많습니다. 사용법을 다시 확인해주세요.");
            new HelpFormatter().printHelp("snc [option] [hostname] [port]\nOptions:\n", options);
            System.exit(1);
        }
    }

    public static void helpCommand(CommandLine cmd, Option help, Options options) {
        if (cmd.hasOption(help)) {
            new HelpFormatter().printHelp("snc [option] [hostname] [port]\nOptions:\n", options);
            System.exit(0);
        }
    }

    public static void connectServer(String[] args) {
        System.out.println("--- Server가 Client의 연결을 기다리고 있습니다. ---");
        int port = Integer.parseInt(args[1]);
        Server server = new Server(port);
        server.connect();
    }

    public static void clientCommand(String[] args) {
        System.out.println("--- Client가 Server로 연결을 시도합니다. ---");
        String host = args[0];
        int port = Integer.parseInt(args[1]);
        Client client = new Client(host, port);
        client.connect();
    }
}
