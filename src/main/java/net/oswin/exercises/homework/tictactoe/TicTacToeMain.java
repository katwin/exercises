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
        int[] victories = new int[2];
        System.out.println("Игра <<Крестики-нолики 3х3>>.");
        boolean nextgame = true;
        do {
            TicTacToe tictactoe = new TicTacToe();
            byte player = 0;
            do {
                player = (byte) Math.abs(player - 1);
                doTurn(player, tictactoe);
            } while (!hasWinner(victories, tictactoe, player) && !hasDraw(tictactoe));
            System.out.println("Хотите продолжить? Выберите + или -");
            String answer = sc.next();
            if (answer.equals("+")) {
                nextgame = true;
            } else
            if (answer.equals("-")) {
                nextgame = false;
            } else {
                throw new IllegalArgumentException("Некорректный ответ.");
            }
        } while (nextgame);
    }

    private static boolean hasDraw(TicTacToe tictactoe) {
        if (tictactoe.isDraw()) {
            System.out.println("Ничья.");
            return true;
        }
        return false;
    }

    /**
     * Преобразует игрока byte в переменную String для правильного вывода текста.
     * @param player
     * @return Возвращает имя игрока.
     */
    private static String getType(byte player) {
        String type = null;
        if (player == 1) {
            type = "крестики";
        } else {
            type = "нолики";
        }
        return type;
    }

    /**
     * Ищет победителя и объявляет его при его наличии.
     * @param victories
     * @param tictactoe
     * @param player
     * @return Возвращает ответ, есть ли победитель.
     */
    private static boolean hasWinner(int[] victories, TicTacToe tictactoe, byte player) {
        if (tictactoe.isWin(player)) {
            System.out.println("Победили " + getType(player) + ".");
            victories[player]++;
            System.out.println("Количество побед крестиков: " + victories[1]);
            System.out.println("Количество побед ноликов: " + victories[0]);
            return true;
        }
        return false;
    }

    /**
     * Ход Х или О
     * @param player
     * @param tictactoe
     */
    private static void doTurn(byte player, TicTacToe tictactoe) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ходят " + getType(player) + ":");
        String[] xx = sc.nextLine().split(" ");
        int x = Integer.parseInt(xx[0]);
        int y = Integer.parseInt(xx[1]);
        tictactoe.turn(x, y, player);
        System.out.println(tictactoe.toString());
    }
}
