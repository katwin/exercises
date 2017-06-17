package net.oswin.exercises;

import java.util.Scanner;

/**
 * #Самое длинное слово в тексте
 * Нужно найти самое длинное слово в тексте. Словом считать все, что отделено пробелом или знаком препинания.
 */
public class LongestWord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите текст:");
        int maxLength = 0;
        String longestWord = null;
        String text[] = sc.nextLine().replaceAll("\\s+", " ").split(" ");
        for (int i = 0; i < text.length; i++) {
            String str = text[i];
            int length = str.length();
            if (length > maxLength) {
                maxLength = length;
                longestWord = str;
            }
        }
        System.out.println("Самое длинное слово в тексте: " + longestWord);
    }
}
