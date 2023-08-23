package org.training.producerConsumer;

class Consumer implements Runnable {
    private final PrinterQueue printerQueue;
    private final int noOfDocuments;

    public Consumer(PrinterQueue printerQueue, int noOfDocuments) {
        this.printerQueue = printerQueue;
        this.noOfDocuments = noOfDocuments;
    }

    @Override
    public void run() {
        for (int i = 0; i < noOfDocuments; i++) {
            try {
                printerQueue.consume();
                // Simulate printing by sleeping
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
