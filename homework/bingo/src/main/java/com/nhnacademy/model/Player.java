package com.nhnacademy.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Player {
    static int count = 0;
    int id = ++count;
    int squares;
    List<Integer> randomNumbers;
    int[][] board;

    public Player(int squares) {
        this.squares = squares;
        this.board = new int[squares][squares]; // board 배열 초기화
        randomNumbers = new ArrayList<>();
        for (int i = 1; i <= squares * squares; i++) {
            randomNumbers.add(i);
        }

        Collections.shuffle(randomNumbers);

        Iterator<Integer> iterator = randomNumbers.iterator();
        for (int i = 0; i < squares; i++) {
            for (int j = 0; j < squares; j++) {
                board[i][j] = iterator.next();
            }
        }
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < squares; i++) {
            for (int j = 0; j < squares; j++) {
                result += board[i][j] + "\t";
            }
            if (i < squares - 1) {
                result += "\n\n";
            }
        }
        return result;
    }
}
