package com.nhnacademy.exam04;

import org.apache.commons.cli.Option;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class Exam04 {
    public static void main(String[] args) throws ParseException {
        Options options = new Options();

        // Builder classPathBuilder = Option.builder("class-path");
        // classPathBuilder.hasArg();
        // classPathBuilder.desc("Class Path");
        // Option classPath = classPathBuilder.build();

        Option classPath = Option.builder("classpath")
                .longOpt("class-path") // short 옵션과 long 옵션을 동시에 사용할 수 있도록 설정. 없으면 short 옵션만 사용 가능
                .hasArg()
                .desc("Class Path")
                .build();
        options.addOption(classPath);

        Option module = Option.builder("m")
                .longOpt("module")
                .hasArg()
                .desc("Module")
                .build();
        options.addOption(module);

        Option group = Option.builder("g")
                .desc("Global")
                .build();
        options.addOption(group);

        Option version = Option.builder("v")
                .longOpt("version")
                .hasArg()
                .desc("Version")
                .build();
        options.addOption(version);

        Option help = Option.builder("h")
                .longOpt("help")
                .desc("Help")
                .build();
        options.addOption(help);

        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = parser.parse(options, args);

        if (cmd.hasOption("h")) {
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp("Exam04", options);
            System.exit(0);
        }
        if (cmd.hasOption(version.getOpt())) { // if(cmd.hasOption("v"))
            System.out.println("Version : 1.0.0");
            System.exit(0);
        }
        if (cmd.hasOption(classPath.getOpt())) {
            // String classPathValue = cmd.getOptionValue(classPath.getOpt());
            String[] classPathValue = cmd.getOptionValues(classPath.getOpt());
            System.out.println("Class Path : " + classPathValue[0] + ", ");
        }
        if (cmd.hasOption(module.getOpt())) {
            System.out.println("Module : ");
        }
        if (cmd.hasOption(group.getOpt())) {
            System.out.println("Global : ");
        }

        System.out.println(cmd.getArgList());
    }
}
