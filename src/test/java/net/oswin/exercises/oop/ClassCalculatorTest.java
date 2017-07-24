package net.oswin.exercises.oop;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Kate on 18.07.2017.
 */
public class ClassCalculatorTest {
    @Test
    public void test() throws Exception {
        ClassCalculator calculator = new ClassCalculator();
        calculator.number(2);
        calculator.plus();
        calculator.number(5);
        calculator.ce();
        calculator.number(4);
        Assert.assertEquals((long)6, (long)calculator.eq());
        Assert.assertEquals((long)10, (long)calculator.eq());
        calculator.div();
        calculator.number(2);
        Assert.assertEquals((long)5, (long)calculator.eq());
        calculator.number(1);
        calculator.multi();
        calculator.number(5);
        calculator.c();
        calculator.number(14);
        calculator.multi();
        calculator.number(5);
        calculator.div();
        calculator.number(10);
        Assert.assertEquals((long)7, (long)calculator.eq());
    }

    @Test
    public void testMinus() {
        ClassCalculator calculator = new ClassCalculator();
        calculator.number(5);
        calculator.minus();
        calculator.number(4);
        Assert.assertEquals((long)1, (long)calculator.eq());
    }

    @Test
    public void testCE() {
        ClassCalculator calculator = new ClassCalculator();
        calculator.number(7);
        calculator.ce();
        Assert.assertEquals(0, calculator.eq(), 0);
    }
}

