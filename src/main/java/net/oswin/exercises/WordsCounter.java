package net.oswin.exercises;

import java.util.Scanner;

/**
 * # Количество слов в тексте
 * Нужно подсчитать количество слов в тексте.  Словом считать все, что отделено пробелом или знаком препинания.
 */
public class WordsCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите текст:");
        String[] text = sc.nextLine().replaceAll("\\s+", " ").split(" ");
        System.out.println("Количество слов в тексте: " + text.length);
    }
}
