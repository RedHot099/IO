package put.io.testing.junit;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {

    private Calculator calculator;

    /**
    3.1 Tak, testy przestałyby działać, ponieważ zmienna calculator byłaby
    przypisana tylko raz - przy wywołaniu klasy, przez co w dalszych testach
    używalibyśmy tej samej zmiennej co mogłoby wpłynąć na niezależność testów
    */

    @Before
    public void setUp() {
        calculator = new Calculator();
    }


    @Test
    public void testAdd() {
        assertEquals(2, calculator.add(1,1), 0);
        assertEquals(2, calculator.add(3, -1), 0);
        assertEquals(-5, calculator.add(-2, -3), 0);
    }

    @Test
    public void testMultiply() {
        assertEquals(2, calculator.multiply(1, 2), 0);
        assertEquals(-3, calculator.multiply(3, -1), 0);
        assertEquals(0, calculator.multiply(214786, 0), 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddPositiveNumberts() {
        assertEquals(2, calculator.addPositiveNumbers(3,-1), 0);

    }
}