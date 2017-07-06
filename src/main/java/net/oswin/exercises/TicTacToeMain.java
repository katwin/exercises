package net.oswin.exercises;

import java.util.Scanner;

/**
 * Created by Kate on 04.07.2017.
 */
public class TicTacToeMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TicTacToe tictactoe = new TicTacToe();
        System.out.println("Игра <<Крестики-нолики 3х3>>.");
        while (true) { //true тут временно, просто чтобы работало, потом подправлю
            //Метод checkDraw
            System.out.println("Ходят крестики:");
            String[] xx = sc.nextLine().split(",");
            int x = Integer.parseInt(xx[0]);
            int y = Integer.parseInt(xx[1]);
            tictactoe.turnX(x, y);
            System.out.println(tictactoe.toString());
            if (tictactoe.isWinX()) {
                System.out.println("Крестики победили");
                break;
            }
            System.out.println("Ходят нолики:");
            String[] oo = sc.nextLine().split(",");
            x = Integer.parseInt(oo[0]);
            y = Integer.parseInt(oo[1]);
            tictactoe.turnO(x, y);
            System.out.println(tictactoe.toString());
            if (tictactoe.isWinO()) {
                System.out.println("Нолики победили");
                break;
            }
        }
    }
}
