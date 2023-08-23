package org.training.producerConsumer;

public class Printer {
    public static void main(String[] args) {
        PrinterQueue printerQueue = new PrinterQueue();

        Thread producerThread1 = new Thread(new Producer(printerQueue, 30));
        Thread producerThread2 = new Thread(new Producer(printerQueue, 30));
        Thread producerThread3 = new Thread(new Producer(printerQueue, 30));
        Thread consumerThread = new Thread(new Consumer(printerQueue, 90));

        producerThread1.start();
        producerThread2.start();
        producerThread3.start();
        consumerThread.start();
    }
}
