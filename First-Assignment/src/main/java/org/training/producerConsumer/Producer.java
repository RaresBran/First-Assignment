package org.training.producerConsumer;

import java.util.Random;

class Producer implements Runnable {
    private final PrinterQueue printerQueue;
    private final int noOfDocuments;

    public Producer(PrinterQueue printerQueue, int noOfDocuments) {
        this.printerQueue = printerQueue;
        this.noOfDocuments = noOfDocuments;
    }

    @Override
    public void run() {
        Random random = new Random();
        for (int i = 0; i < noOfDocuments; i++) {
            Document document = new Document();
            try {
                printerQueue.produce(document);
                // Simulate device requesting printing by sleeping
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
