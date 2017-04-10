package net.oswin.exercises;

import java.util.Scanner;

/**
 * Количество слов в тексте
 */
public class NumberOfWordsInText {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите текст, чтобы узнать количество слов в нём:");
        String[] str = sc.nextLine().replaceAll("[^А-ЯA-Zа-яa-z0-9]", " ").replaceAll("\\s+", " ").split(" ");
        System.out.println("Количество слов в данном тексте - " + str.length);
     }
}
