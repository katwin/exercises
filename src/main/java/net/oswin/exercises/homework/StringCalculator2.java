package net.oswin.exercises.homework;

import java.util.Scanner;

/**
 * Строковой калькулятор, с учетом приоритетов * /
 */
public class StringCalculator2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите арифметическое выражение:");
        String ss = sc.nextLine();
        ss = removeExtraSymbols(ss);
        //получаем слагаемые, включая выражения с * и /
        String[] arrstr = getSummands(ss);
        //получаем знаки + или -
        String[] arrop = getOps(ss);
        calcMulti(arrstr);
        print(arrstr, arrop);
        //arrstr = [1,3,24]
        //вычисляем сложение и вычитание
        int sum = calcRes(arrstr, arrop);
        System.out.println("Ответ: " + sum);
    }

    public static String[] getSummands(String ss) {
        return ss.split("[+\\-]");
    }

    public static String[] getOps(String ss) {
        return ss.split("[0-9\\*/]+");
    }

    /**
     * Метод очищает строку от лишних символов
     * @param str
     * @return
     */
    public static String removeExtraSymbols(String str) {
        return str  .replaceAll("[^0-9+\\-\\*/]", " ")
                    .replaceAll("\\s+", "");
    }

    /**
     * Метод вычисляет результат
     * @param arrstr
     * @param arrop
     * @return
     */
    public static int calcRes(String[] arrstr, String[] arrop) {
        int sum = Integer.parseInt(arrstr[0]);
        for (int k = 1; k < arrstr.length; k++) {
            sum = calc(arrop[k], sum, arrstr[k]);
        }
        return sum;
    }

    /**
     * Метод выполняет приоритетные вычислительные операции и переписывает массив чисел
     * @param arrstr
     */
    public static void calcMulti(String[] arrstr) {
        for (int i = 0; i < arrstr.length; i++) {
            if (arrstr[i].contains("*") || arrstr[i].contains("/")) {
                //получаем множители и делители (только числа)
                String[] arrstr2 = arrstr[i].split("[\\*/]");//2,3,2
                //получаем знаки * или /
                String[] arrop2 = arrstr[i].split("[0-9]+");//,*,/
                int multi = calcRes(arrstr2, arrop2);
                //записываем результат в начальный массив
                arrstr[i] = String.valueOf(multi);//3
            }
        }
    }

    /**
     * выводим промежуточные результаты
     */
    public static void print(String[] arrstr, String[] arrop) {
        String midres = arrstr[0];
        for (int h = 1; h < arrstr.length; h++) {
            midres = midres + arrop[h] + arrstr[h];
        }
        System.out.println(midres);
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
