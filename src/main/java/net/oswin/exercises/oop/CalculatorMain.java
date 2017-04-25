package net.oswin.exercises.oop;

/**
 * Created by Kate on 25.04.2017.
 */
public class CalculatorMain {
    public static void main(String[] args) {
        ClassCalculator calculator = new ClassCalculator();
        calculator.number(2);
        calculator.plus();
        calculator.number(5);
        calculator.ce();
        calculator.number(4);
        System.out.println(calculator.eq());//6
        System.out.println(calculator.eq());//10
        calculator.div();
        calculator.number(2);
        System.out.println(calculator.eq());//5
        calculator.number(1);
        calculator.multi();
        calculator.number(5);
        calculator.c();
        calculator.number(14);
        calculator.multi();
        calculator.number(5);
        calculator.div();//70
        calculator.number(10);
        System.out.println(calculator.eq());//7
    }
}
