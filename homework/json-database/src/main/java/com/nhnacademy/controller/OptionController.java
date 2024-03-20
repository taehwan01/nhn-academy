package com.nhnacademy.controller;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class OptionController {
    Options options = new Options();
    CommandLineParser parser = new DefaultParser();
    Option helpOption;
    Option addOperation;
    Option deleteOperation;
    Option typeOption;
    Option idOption;
    Option nameOption;
    Option listOperation;
    Option countOption;
    Option winOption;
    Option energyOption;
    Option attackOption;
    Option defenceOption;
    Option movingSpeedOption;
    Option attackSpeedOption;
    Option historyOption;
    Option dbFileOption;

    public OptionController() {
        helpOption = new Option("h", false, "Help");
        helpOption.setLongOpt("help");

        addOperation = new Option("a", true, "Add Operation");
        addOperation.setLongOpt("add");

        deleteOperation = new Option("del", true, "Delete Operation");
        deleteOperation.setLongOpt("delete");

        typeOption = new Option("t", true, "Type Option");
        typeOption.setLongOpt("type");

        idOption = new Option("i", true, "ID Option");
        idOption.setLongOpt("id");

        nameOption = new Option("n", true, "Name Option");
        nameOption.setLongOpt("name");

        listOperation = new Option("l", false, "List Operation");
        listOperation.setLongOpt("list");

        countOption = new Option("c", true, "Count Option");
        countOption.setLongOpt("count");

        winOption = new Option("W", true, "Win Option");
        winOption.setLongOpt("win");

        energyOption = new Option("e", true, "Energy Option");
        energyOption.setLongOpt("energy");

        attackOption = new Option("a", true, "Attack Option");
        attackOption.setLongOpt("attack");

        defenceOption = new Option("d", true, "Defence Option");
        defenceOption.setLongOpt("defence");

        movingSpeedOption = new Option("m", true, "Moving Speed Option");
        movingSpeedOption.setLongOpt("moving-speed");

        attackSpeedOption = new Option("A", true, "Attack Speed Option");
        attackSpeedOption.setLongOpt("attack-speed");

        historyOption = new Option("L", true, "History Option");
        historyOption.setLongOpt("history");

        dbFileOption = new Option("f", true, "DB File Option");
        dbFileOption.setLongOpt("db-file");

        options.addOption(helpOption);
        options.addOption(addOperation);
        options.addOption(deleteOperation);
        options.addOption(typeOption);
        options.addOption(idOption);
        options.addOption(nameOption);
        options.addOption(listOperation);
        options.addOption(countOption);
        options.addOption(winOption);
        options.addOption(energyOption);
        options.addOption(attackOption);
        options.addOption(defenceOption);
        options.addOption(movingSpeedOption);
        options.addOption(attackSpeedOption);
        options.addOption(historyOption);
        options.addOption(dbFileOption);
    }

    public void checkType(String[] args) throws ParseException {
        CommandLine commandLine = parser.parse(options, args);

        if (!commandLine.hasOption(typeOption.getOpt())) {
            throw new ParseException("Type 옵션이 없습니다.");
        }

        String type = commandLine.getOptionValue(typeOption.getOpt());
        if (type.equals("user")) {
            try {
                isUserOptionValid(args);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            UserController userController = new UserController();
            if (commandLine.hasOption(addOperation.getOpt())) {
                String id = commandLine.getOptionValue(idOption.getOpt());
                String name = commandLine.getOptionValue(nameOption.getOpt());
                if (id == null || name == null) {
                    throw new ParseException("추가할 User의 id나 name이 없습니다.");
                }
                userController.addUser(id, name);
            } else if (commandLine.hasOption(deleteOperation.getOpt())) {
                String id = commandLine.getOptionValue(idOption.getOpt());
                if (id == null) {
                    throw new ParseException("삭제 대상 id가 없습니다.");
                }
                userController.deleteUser(id);
            } else if (commandLine.hasOption(listOperation.getOpt())) {
                userController.listUser();
            }
        } /*
           * else if (type.equals("item")) {
           * } else if (type.equals("record")) {
           * }
           */
    }

    public void isUserOptionValid(String[] args) throws ParseException {
        CommandLine commandLine = parser.parse(options, args);

        if (commandLine.hasOption(countOption.getOpt())) {
            throw new ParseException("User 명령어는 대전 횟수 옵션이 없습니다.");
        }
        if (commandLine.hasOption(winOption.getOpt())) {
            throw new ParseException("User 명령어는 승리 횟수 옵션이 없습니다.");
        }
        if (commandLine.hasOption(energyOption.getOpt())) {
            throw new ParseException("User 명령어는 에너지 옵션이 없습니다.");
        }
        if (commandLine.hasOption(attackOption.getOpt())) {
            throw new ParseException("User 명령어는 공격력 옵션이 없습니다.");
        }
        if (commandLine.hasOption(defenceOption.getOpt())) {
            throw new ParseException("User 명령어는 방어력 옵션이 없습니다.");
        }
        if (commandLine.hasOption(movingSpeedOption.getOpt())) {
            throw new ParseException("User 명령어는 이동 속도 옵션이 없습니다.");
        }
        if (commandLine.hasOption(attackSpeedOption.getOpt())) {
            throw new ParseException("User 명령어는 공격 속도 옵션이 없습니다.");
        }
    }
}
