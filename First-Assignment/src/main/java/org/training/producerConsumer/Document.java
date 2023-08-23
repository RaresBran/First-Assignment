package org.training.producerConsumer;

class Document {
    private static int counter = 0;
    private final int id;

    public Document() {
        this.id = ++counter;
    }

    @Override
    public String toString() {
        return "Document #" + id;
    }
}
