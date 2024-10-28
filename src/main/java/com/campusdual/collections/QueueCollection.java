package com.campusdual.collections;

import java.util.LinkedList;
import java.util.Queue;

public class QueueCollection {
    public static void main(String[] args) {
        Queue<String> instruments = new LinkedList<>();

        instruments.offer("Guitar");
        instruments.offer("Piano");
        instruments.offer("Drums");
        instruments.offer("Violin");

        System.out.println("Queue of musical instruments");
        for (String item : instruments){
            System.out.println(item);
        }

        String removedInstrument = instruments.poll();
        System.out.println("Removed: " + removedInstrument);

        System.out.println("\nQueue after removal: ");
        for (String item : instruments){
            System.out.println(item);
        }
    }
}
