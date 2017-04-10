package net.oswin.exercises;

import java.util.Scanner;

/**
 * Строковой калькулятор, без учета приоритета
 */
public class StringCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите арифметическое выражение:");
        String s = sc.nextLine();
        sc = new Scanner(s);
        int sum = 0;
        int b = 0;
        String c = null;
        int a = 0;
        do {
            b = sc.nextInt();
            if (c != null) {
                if (c.equals("+"))
                    a = a + b;
                else if (c.equals("-"))
                    a = a - b;
                else if (c.equals("*"))
                    a = a * b;
                else  if (c.equals("/"))
                    a = a / b;
                else
                    throw new UnsupportedOperationException("Операция \"" + c + "\" некорректна.");
            } else
                a = b;
            c = sc.next();
        } while (!c.equals("="));
        System.out.println("Ответ:            " + a);
    }
}
