package org.ds.morteza;

import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;

public class Consumer implements Runnable {
    private ArrayBlockingQueue<Integer> resource;
    private Stack<Integer> util;
    private Stack<Integer> sorted;

    public Consumer(ArrayBlockingQueue<Integer> resource) {
        this.resource = resource;
        util = new Stack<>();
        sorted = new Stack<>();
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(200);
                Integer item = resource.take();
                System.out.println(item);
                sort(item);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(sorted);
    }

    private void sort(Integer item) {
        printStacks();
        while (!sorted.empty() && item > sorted.peek()) {
            util.push(sorted.pop());
            printStacks();
        }

        sorted.push(item);
        printStacks();

        while (!util.empty()) {
            sorted.push(util.pop());
            printStacks();
        }

        System.out.println("--------------------------");
    }

    private void printStacks() {
        System.out.println("Sorted: " +sorted);
        System.out.println("Util: " +util);
        System.out.println();
    }

}
