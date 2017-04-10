package net.oswin.exercises;


/**
 * Методы
 */
public class Methods {

    public static void main(String[] args) {
        //sayHello(); //wrong!
        printHello("Arnold");
        printHello("Oswin");
        String whatDoesHeSay = sayHello("Irina");
        System.out.println(whatDoesHeSay);
        String whatDoesHeSay2 = sayHello("Konstantin", 6);
        System.out.println(whatDoesHeSay2);
        System.out.println(sayHello("Arnold"));
        System.out.println(sayHelloAndAge("Oswin", 16));
        System.out.println(sayHelloAndAge("Igor", 33));
        printHelloAndAge("Oswin", 16);
    }

    static String sayHello(String name) {
        if (name.startsWith("A"))  {
            return "Goodbye, " + name;
        }
        return "Hello, " + name;
    }

    static String sayHello(String name, int age) {
        return sayHelloAndAge(name, age);
    }

    private static void printHello(String name) {
        if (name.startsWith("A"))  {
            return;
        }
        System.out.println("Hello, " + name);
    }

    public static String sayHelloAndAge(String name, int age) {
        return "Hello, my name is " + name + ". I'm " + age + " years old.";
    }

    public static void printHelloAndAge(String name, int age) {
        String whatDoesHeSay = sayHelloAndAge(name, age);
        System.out.println(whatDoesHeSay);
    }


}