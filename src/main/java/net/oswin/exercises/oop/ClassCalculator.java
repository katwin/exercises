package net.oswin.exercises.oop;

/**
 * Класс Калькулятор.
 */
public class ClassCalculator {
    private char op = '=';
    private double left = 0;
    private double right = 0;
    private boolean wasEq = false;

    public void plus() {
        if (!wasEq)
            eq();
        op = '+';
    }
    public void minus() {
        if (!wasEq)
            eq();
        op = '-';
    }
    public void multi() {
        if (!wasEq)
            eq();
        op = '*';
    }
    public void div() {
        if (!wasEq)
            eq();
        op = '/';
    }

    public double eq() {
        wasEq = true;
        double res = left;
        switch (op) {
            case '+': res = left + right;
                break;
            case '-': res = left - right;
                break;
            case '*': res = left * right;
                break;
            case '/': res = left / right;
                break;
        }
        left = res;
//        right = 0;
//        op = '=';
        return res;
    }

    public void number(double n) {
        wasEq = false;
        if (op == '=')
            left = n;
        else
            right = n;
    }

    public void c() {
        left = 0;
        right = 0;
        op = '=';
        wasEq = false;
    }
    public void ce() {
        if (op == '=')
            left = 0;
        else
            right = 0;
    }
}
