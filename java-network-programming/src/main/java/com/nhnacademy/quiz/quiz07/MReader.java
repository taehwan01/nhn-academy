package com.nhnacademy.quiz.quiz07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

public class MReader extends BufferedReader implements Runnable {
    private String line;

    public MReader(Reader in) {
        super(in);
    }

    @Override
    public void run() {
        try {
            while (!((line = readLine()).equals("exit"))) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getLine() {
        return line;
    }
}
