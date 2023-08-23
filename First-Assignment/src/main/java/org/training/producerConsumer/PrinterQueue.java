package org.training.producerConsumer;

import java.util.LinkedList;
import java.util.Queue;

class PrinterQueue {
    private final Queue<Document> queue = new LinkedList<>();
    private final static int maxSize = 5;

    public synchronized void produce(Document document) throws InterruptedException {
        while (queue.size() >= maxSize) {
            wait();
        }
        queue.offer(document);
        System.out.println("Produced " + document);
        notify();
    }

    public synchronized Document consume() throws InterruptedException {
        while (queue.isEmpty()) {
            wait();
        }
        Document document = queue.poll();
        System.out.println("Consumed " + document);
        notify();
        return document;
    }
}
