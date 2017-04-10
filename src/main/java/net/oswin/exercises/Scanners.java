package net.oswin.exercises;

import java.util.Scanner;

/**
 * Класс сканер
 */
public class Scanners {

    public Scanners(String s) {

    }

    public static void main(String[] args) {
//        String s = "Привет\nКатя\nИгорь";
        String s = "Привет, Катя. Меня      зовут Игорь!";
        Scanner scanner = new Scanner(s);
        int k = 0;
        while (scanner.hasNext()) {
            k++;
            scanner.next();
        }
        System.out.println("Количество слов в данном тексте - " + k);
    }
}
