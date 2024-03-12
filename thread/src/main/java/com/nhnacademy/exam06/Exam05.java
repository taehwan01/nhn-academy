package com.nhnacademy.exam06;

import com.nhnacademy.Data;

public class Exam05 {
    public static void main(String[] args) {
        Data data = new Data();
        Thread sender = new Thread(new Sender(data));
        Thread receiver = new Thread(new Receiver(data));

        sender.start();
        receiver.start();
    }
}