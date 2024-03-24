// package com.nhnacademy.ex1;

// public class Ex1 {
// public static void main(String[] args) {
// Thread1 thread1 = new Thread1();
// Thread2 thread2 = new Thread2();
// thread1.start();
// thread2.start();

// try {
// // thread1.sleep(2000);
// // sleep
// // 현재 실행중인 스레드를 2초간 멈춤
// Thread.sleep(2000);
// } catch (InterruptedException e) {
// e.printStackTrace();
// }

// System.out.println("main 종료");
// }
// }

// class Thread1 extends Thread {
// public void run() {
// for (int i = 0; i < 300; i++) {
// System.out.println("-");
// }
// System.out.println("Thread1 종료");
// }
// }

// class Thread2 extends Thread {
// public void run() {
// for (int i = 0; i < 300; i++) {
// System.out.println("|");
// }
// System.out.println("Thread2 종료");
// }
// }
