package com.nhnacademy;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalTime;
import java.util.StringTokenizer;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import com.nhnacademy.model.Log;
import com.nhnacademy.model.User;

public class Main {
    public static void main(String[] args) throws IOException {
        OptionOperator optionOperator = new OptionOperator();

        CommandLineParser parser = new DefaultParser();
        for (Option option : optionOperator) {
            System.out.println(option.getOpt());
        }

        try {
            CommandLine commandLine = parser.parse(options, args);
            if (commandLine.hasOption(helpOption.getOpt())) {
                HelpFormatter formatter = new HelpFormatter();
                formatter.printHelp("recoder", options);
            }
        } catch (ParseException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }

        JSONTokener tokener;
        JSONObject data;

        try {
            FileReader file = new FileReader("data.json");
            tokener = new JSONTokener(file);
            data = new JSONObject(tokener);
            file.close();
        } catch (IOException | JSONException e) {
            data = new JSONObject();
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("명령어 입력: ");
        StringTokenizer command = new StringTokenizer(br.readLine(), " ");

        JSONArray users;
        JSONArray logs;
        if (!data.has("user")) {
            users = new JSONArray();
            data.put("user", users);
        } else {
            users = data.getJSONArray("user");
        }
        if (!data.has("log")) {
            logs = new JSONArray();
            data.put("log", logs);
        } else {
            logs = data.getJSONArray("log");
        }

        String classType;
        while (!(classType = command.nextToken()).equals("exit")) {
            String operational = command.nextToken();
            String logMessage = "유효하지 않은 명령어가 입력되었습니다.";

            if (classType.equals("user")) {
                if (operational.equals("add")) {
                    String id = command.nextToken();
                    String nickname = command.nextToken();
                    User user = new User(id, nickname);
                    JSONObject userObject = new JSONObject(user);
                    users.put(userObject);
                    logMessage = String.format("User #%s %s 생성되었습니다.", user.getId(), user.getName());
                } else if (operational.equals("delete")) {
                    String id = command.nextToken();
                    for (int i = 0; i < users.length(); i++) {
                        JSONObject user = (JSONObject) users.get(i);
                        String userId = (String) user.get("id");
                        if (id.equals(userId)) {
                            logMessage = String.format("User #%s %s 삭제되었습니다.", user.get("id"), user.get("nickname"));
                            users.remove(i);
                        }
                    }
                } else if (operational.equals("list")) {
                    System.out.println("ID\tNAME");
                    for (int i = 0; i < users.length(); i++) {
                        JSONObject user = (JSONObject) users.get(i);
                        System.out.println(user.get("id") + "\t" + user.get("nickname"));
                    }
                    logMessage = "User 목록을 조회했습니다.";
                }

                String currentTime = LocalTime.now().toString().substring(0, 8);
                Log log = new Log(currentTime, logMessage);
                JSONObject logObject = new JSONObject(log);
                logs.put(logObject);
            }

            try {
                JSONObject total = new JSONObject();
                total.put("user", users);
                total.put("log", logs);
                FileWriter file = new FileWriter("data.json");
                file.write(total.toString());
                file.flush();
                file.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("명령어 입력: ");
            command = new StringTokenizer(br.readLine(), " ");
        }
    }
}
