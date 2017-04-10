package net.oswin.exercises;

import java.util.Arrays;

/**
 * Циклы.
 */
public class Cycles {
    public static void main(String[] args) {
        int k = 1;
        while ((int)(Math.random() * 100) % 6 != 0) {//пока true циклимся
            k++;
        }
        System.out.println("Угадал с"  + k + " раза.");
        k = 0;
        do {
            k++;
        } while ((int)(Math.random() * 100) % 6 != 0); //пока true циклимся
        System.out.println("Угадал с " + k + " раза.");

        for (int i = 0; i < 5; i++) {//fori
            System.out.print(i);
        }
        System.out.println();
        for (int i = 5; i > 0; i--) {//fori inverse
            System.out.print(i);
        }
        System.out.println();
        for (String s : Arrays.asList("a","b","c","d","e")) {
            System.out.print(s);
        }
        //lambdas
        System.out.println();
        Arrays.asList("a","b","c","d","e").forEach(s -> {
            System.out.print(s);
        });
        System.out.println();
        Arrays.asList("a","b","c","d","e").forEach(s -> System.out.print(s));
        System.out.println();
        Arrays.asList("a","b","c","d","e").forEach(System.out::print);
    }
}
