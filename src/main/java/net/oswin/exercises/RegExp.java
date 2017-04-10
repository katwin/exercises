package net.oswin.exercises;

/**
 * Регулярные выражения
 */
public class RegExp {
    public static void main(String[] args) {
        String s = "Привет, Катя";
        System.out.println(s.replaceAll("[аяие]", "_"));//Пр_в_т, К_т_
        System.out.println(s.replaceAll("[а-я]", "_"));//П_____, К___
        System.out.println(s.replaceAll("[А-я]", "_"));//______, ____
        System.out.println(s.replaceAll("[а-я,А-Я]", "_"));//______, ____
        System.out.println(s.replaceAll("[^А-ЯA-Zа-яa-z0-9]", "_"));
        System.out.println("удаляет   лишние     пробелы".replaceAll("\\s+", " "));
    }
}