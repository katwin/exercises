package net.oswin.exercises.homework.tictactoe;

import net.oswin.exercises.homework.tictactoe.TicTacToe;

import java.util.Scanner;

/**
 * Процесс игры "Крестики-нолики".
 * Добавлена функция многоразовой игры.
 * Основной процесс игры перенесен в методы.
 * Итерация внутреннего цикла отвечает за один ход.
 */
public class TicTacToeMain {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean nextgame = true;
        System.out.println("Игра <<Крестики-нолики 3х3>>.");
        GameBoy gameBoy = new GameBoy();
        do {
            gameBoy.startGame();
            do {
                if (gameBoy.whoPlay() == 'X') {
                    System.out.println("Ходят крестики:");
                } else System.out.println("Ходят нолики:");
                String[] xx = sc.nextLine().split(" ");
                int x = Integer.parseInt(xx[0]);
                int y = Integer.parseInt(xx[1]);
                gameBoy.turn(x,y);
                System.out.println(gameBoy.toString());
            } while (!gameBoy.isEnd());
            if (gameBoy.whoWin() == 'X') {
                System.out.println("Крестики победили.");
            } else if (gameBoy.whoWin() == 'O') {
                System.out.println("Нолики победили.");
            } else System.out.println("Ничья.");
            System.out.println("Количество побед крестиков: " + gameBoy.getStatistics()[1]);
            System.out.println("Количество побед ноликов: " + gameBoy.getStatistics()[0]);
            System.out.println("Хотите продолжить? Введите + или -.");
            String answer = sc.next();
            if (answer.equals("+")) {
                nextgame = true;
            } else if (answer.equals("-")) {
                nextgame = false;
            } else throw new IllegalArgumentException("Некорректный ответ.");
        } while (nextgame);
    }


}
