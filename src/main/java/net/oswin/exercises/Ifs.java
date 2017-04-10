package net.oswin.exercises;

/**
 * Условные операторы
 */
public class Ifs {
    public static void main(String[] args) {
        int v = ((int) (Math.random() * 1000)) % 3;
        //if-else
        if (v == 0) {
            System.out.println(v + "=0");
        } else if (v == 1) {
            System.out.println(v + "=1");
        } else {
            System.out.println(v + "=?");
        }

        //switch
        switch (v) {
            case 0: {
                System.out.println(v + "=0");
            }
            break;
            case 1: {
                System.out.println(v + "=1");
            }
            break;
            default: {
                System.out.println(v + "=?");
            }
        }

        switch (v) {
            case 0:
                System.out.println(v + "=0");
                break;
            case 1:
                System.out.println(v + "=1");
                break;
            default:
                System.out.println(v + "=?");
        }

        switch (v) {
            case 0:
            case 1: {
                System.out.println(v + "=0 или =1");
            }
            break;
            default: {
                System.out.println(v + "=?");
            }
        }

        String s = "a";
        switch (s) {
            case "a":
                System.out.println(s + "=a");
                break;
            default:
                System.out.println(s + "=?");
        }

        //elvis bool ? then : else
        System.out.println(v == 1 ? v + "=1" : v + "=?" );
        System.out.println(v == 1 ? v + "=1" : v == 0 ? v + "=0" : v + "=?" );
    }
}
