package net.oswin.exercises;

import java.util.Scanner;

/**
 * Игра в палочки.
 */
public class MatchesGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Игра палочки.");
        int n = 20;
        int k = 0;
        int g = 0;
        do {
            System.out.println("Осталось " + n + " палочек.");
            k++;
            if (k % 2 == 1) {
                System.out.print("Ваш ход: ");
                g = sc.nextInt();
                if ((g < 1) || (g > 3))
                    throw new IllegalArgumentException("Можно взять только 1, 2 или 3 палочки.");
            } else {
                if (n <= 4) {
                    g = n - 1;
                } else {
                    double r = Math.random();//0..1
                    g = (int)(Math.round(r * 100) % 3) + 1;
                }
                System.out.println("Оппонент взял: " + g);
            }
            n = n - g;
        } while (n > 1);
        System.out.println("Осталось " + n + " палочек.");
        if (k % 2 == 1)
            System.out.println("Вы победили :)");
        else
            System.out.println("Вы проиграли :(");
    }
}
