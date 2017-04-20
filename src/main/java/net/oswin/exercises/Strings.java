package net.oswin.exercises;

import java.util.Arrays;

/**
 * Created by Kate on 22.03.2017.
 */
public class Strings {
    public static void main(String[] args) {
        String s = "12";
        Integer i = 1;
        Long l = 1L;
        Boolean b = true;//autoboxing

        s = s + "34";
        System.out.println(s);
        System.out.println(s.length());
        System.out.println(s.indexOf("23"));
        System.out.println(s.substring(1,3));
        System.out.println(s.substring(1));
        System.out.println(s.substring(s.indexOf("23")));
        System.out.println(s.equals("1234"));//true
        System.out.println(s == "1234"); //false
        String s2 = s;
        System.out.println(s == s2);//true
        System.out.println(s.equals(s2));//true
        System.out.println("1234" == "1234");//true ?!
        System.out.println("Hello".equals("hello"));//false
        System.out.println("Hello".equalsIgnoreCase("hello"));//true

        s = "12, 23,  3  ,   4";//parsing
        String[] a = s.split(", ");
        System.out.println(Arrays.asList(a));//[12,23,3,4]
        System.out.println(Integer.parseInt(" 21 ".trim()));
        for (int j = 0; j < a.length; j++) {
            a[j] = a[j].trim();
        }
        System.out.println(Arrays.asList(a));//[12,23,3,4]
        System.out.println("a1b2c3".replaceAll("\\d", ""));

        System.out.println("Hello, Oswin".contains("Oswin"));//true
    }
}
