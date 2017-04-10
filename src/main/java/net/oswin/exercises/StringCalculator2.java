package net.oswin.exercises;

import java.util.Scanner;

/**
 * Строковой калькулятор, с учетом приоритетов * /
 */
public class StringCalculator2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите арифметическое выражение:");//10+ 4/2 -2*3
        //10+2-6
        //Ответ: 6
        String ss = sc.nextLine()//67+ asd 89  -23
                .replaceAll("[^0-9+\\-\\*/]", " ")//67+     89  -23
                .replaceAll("\\s+", "");//67+89-23
        //получаем слогаемые, включая выражения с * и /
        String[] arrstr = ss.split("[+\\-]");//1,2*3/2,4*6
        //получаем знаки + или -
        String[] arrop = ss.split("[0-9\\*/]+");//,+,-
        String num = "";

        for (int i = 0; i < arrstr.length; i++) {
            if (arrstr[i].contains("*") || arrstr[i].contains("/")) {
                //получаем множители и делители (только числа)
                String[] arrstr2 = arrstr[i].split("[\\*/]");//2,3,2
                //получаем знаки * или /
                String[] arrop2 = arrstr[i].split("[0-9]+");//,*,/
                int multi = Integer.parseInt(arrstr2[0]);
                //вычисляем умножения и деления
                for (int k = 1; k < arrstr2.length; k++) {
                    multi = calc(arrop2[k], multi, arrstr2[k]);
                }
                //записываем результат в начальный массив
                arrstr[i] = String.valueOf(multi);//3
            }
        }

        //выводим промежуточные результаты
        String midres = arrstr[0];
        for (int h = 1; h < arrstr.length; h++) {
            midres = midres + arrop[h] + arrstr[h];
        }
        System.out.println(midres);
        //arrstr = [1,3,24]
        //вычисляем сложение и вычитание
        String num2 = "";
        int sum = Integer.parseInt(arrstr[0]);
        for (int k = 1; k < arrstr.length; k++) {
            sum = calc(arrop[k], sum, arrstr[k]);
        }


        System.out.println("Ответ: " + sum);
    }

    /**
     * Метод выполняет операцию op над числом left и right
     * @param op знак умножения, деления, сложения или вычитания
     * @param left произведение, частное, сумма или разность
     * @param right множитель, делитель, слагаемое или вычитаемое
     * @return результат операции
     */
    public static int calc(String op, int left, String right) {
        int rightInt = Integer.parseInt(right);
        switch (op) {
            case "*": return left * rightInt;
            case "/": return left / rightInt;
            case "+": return left + rightInt;
            case "-": return left - rightInt;
            default: throw new UnsupportedOperationException(op);
        }
    }

}
