package net.oswin.exercises;

import java.util.Scanner;

/**
 * Процесс игры "Крестики-нолики".
 * домашнее задание 6 июля к 10 июля: попытаться создать счетчик побед крестиков и ноликов.
 * upd: Домашнее задание сделано, но не учтено, что в run играется всего одна игра. Будет исправлено.
 */
public class TicTacToeMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int victoriesX = 0;
        int victoriesO = 0;
        System.out.println("Игра <<Крестики-нолики 3х3>>.");
        boolean nextgame = true;
        do {
            TicTacToe tictactoe = new TicTacToe();
            while (true) {
                System.out.println("Ходят крестики:");
                String[] xx = sc.nextLine().split(" ");
                int x = Integer.parseInt(xx[0]);
                int y = Integer.parseInt(xx[1]);
                tictactoe.turnX(x, y);
                System.out.println(tictactoe.toString());
                if (tictactoe.isWinX()) {
                    System.out.println("Крестики победили.");
                    victoriesX++;
                    System.out.println("Количество побед крестиков: " + victoriesX);
                    System.out.println("Количество побед ноликов: " + victoriesO);
                    break;
                }
                if (tictactoe.isDraw()) {
                    System.out.println("Ничья.");
                    break;
                }
                System.out.println("Ходят нолики:");
                xx = sc.nextLine().split(" ");
                x = Integer.parseInt(xx[0]);
                y = Integer.parseInt(xx[1]);
                tictactoe.turnO(x, y);
                System.out.println(tictactoe.toString());
                if (tictactoe.isWinO()) {
                    System.out.println("Нолики победили.");
                    victoriesO++;
                    System.out.println("Количество побед крестиков: " + victoriesX);
                    System.out.println("Количество побед ноликов: " + victoriesO);
                    break;
                }
            }
            System.out.println("Хотите продолжить?");
            String answer = sc.nextLine();
            if (answer.equals("Да")) {
                nextgame = true;
            } else
            if (answer.equals("Нет")) {
                nextgame = false;
            } else {
                throw new IllegalArgumentException("Некорректный ответ.");
            }
        } while (nextgame);
    }
}
