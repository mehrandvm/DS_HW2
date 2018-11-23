package org.ds.morteza;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

public class Producer implements Runnable {
    private ArrayBlockingQueue<Integer> resource;
    private List<Integer> rndNums;

    public Producer(ArrayBlockingQueue<Integer> resource) {
        this.resource = resource;
        rndNums = new ArrayList<>();

        for (int i = 1; i < 11; i++) {
            rndNums.add(i);
        }

        Collections.shuffle(rndNums);
    }


    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(100);
                resource.put(rndNums.get(i));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
