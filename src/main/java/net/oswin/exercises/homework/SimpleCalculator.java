package net.oswin.exercises.homework;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Учимся основам Java. Типы данных, логические и арифметические операции, циклы.
 */
public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Здесь вы можете что-нибудь посчитать.");
        Double a = null;
        double b = 0;
        String c = "";
        do {
            System.out.print("Введите число:    ");
            b = sc.nextInt();
            if (a != null) {
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
            System.out.print("Введите операцию: ");
            c = sc.next();
        } while (!c.equals("="));
        System.out.println("Ответ:            " + a);
    }
}