package net.oswin.exercises;

import java.util.Scanner;

/**
 * Палиндрометр.
 */
public class Palindrom {
    public static void main(String[] args) {
        boolean palindrom = true;
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите предложение:");
        String s = sc.nextLine();
        s = s.toLowerCase().replace(" ", "");
        char[] a = s.toCharArray();
        for (int i = 0; i < a.length / 2; i++) {
            if (a[i] != a[a.length - i - 1]) {
                palindrom = false;
                break;
            }
        }
        if (palindrom) {
            System.out.println("Это палиндром!");
        } else
            System.out.println("Это не палиндром.");
    }
}
