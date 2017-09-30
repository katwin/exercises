package net.oswin.exercises.homework.tictactoe;

import java.util.Scanner;

/**
 * Процесс игры "Крестики-нолики".
 */
public class TicTacToeMain {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean nextgame = true;
        System.out.println("Игра <<Крестики-нолики 3х3>>.");
        System.out.println("Выберите тип игры (0 - человек/человек, 1 - человек/компьютер, 2 - компьютер/компьютер):");
        String mode = sc.nextLine();
        System.out.println("Выберите уровень сложности: ");
        String level = sc.nextLine();
        GameBoy gameBoy = new GameBoy();
        do {
            TicTacToe tictactoe = new TicTacToe();
            TicTacToeAI ai = null;
            switch (mode) {
                case "2":
                    break;
                case "1":

                    break;
                case "0":

                    break;
            }
            switch (level) {
                case "3":
                    ai = new TicTacToeAI3(tictactoe, new GameRandomizer());
                    break;
                case "2":
                    ai = new TicTacToeAI2(tictactoe, new GameRandomizer());
                    break;
                case "1":
                    ai = new TicTacToeAI1(tictactoe, new GameRandomizer());
            }
            gameBoy.setAi(ai);
            gameBoy.startGame(tictactoe);
            System.out.println(gameBoy.toString());
            do {
                if (gameBoy.whoPlay() == 'X') {
                    System.out.println("Ходят крестики:");
                } else System.out.println("Ходят нолики:");
                String[] xx = sc.nextLine().split(" ");
                int x = Integer.parseInt(xx[0]) - 1;
                int y = Integer.parseInt(xx[1]) - 1;
                gameBoy.turn(x,y);//gameBoy.next();
                System.out.println(gameBoy.toString());
            } while (!gameBoy.isEnd());
            if (gameBoy.whoWin() == 'X') {
                System.out.println("Крестики победили.");
            } else if (gameBoy.whoWin() == 'O') {
                System.out.println("Нолики победили.");
            } else System.out.println("Ничья.");
            System.out.println("Количество побед пользователя: " + gameBoy.getStatistics()[1]);
            System.out.println("Количество побед компьютера: " + gameBoy.getStatistics()[0]);
            System.out.println("Хотите продолжить? Введите + или -.");
            String answer = sc.nextLine();
            if (answer.equals("+")) {
                nextgame = true;
            } else if (answer.equals("-")) {
                nextgame = false;
            } else throw new IllegalArgumentException("Некорректный ответ.");
        } while (nextgame);
    }


}
