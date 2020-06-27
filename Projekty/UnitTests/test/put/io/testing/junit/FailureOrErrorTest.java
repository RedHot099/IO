package put.io.testing.junit;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FailureOrErrorTest {

    private Calculator calculator;

    @Before
    public void setUp() {
        calculator = new Calculator();
    }

    /**
     * 4.1
     * metoda test1 zostanie uznana jako Failure, ponieważ próba porównania
     * wyników zakończy się niepowodzeniem
     * Natomiast test2 zostanie określony jako Error, ponieważ podajemy
     * niepoprawne wartości do funkcji
     *
     * 4.2
     *Oczekuje na obiekt Failure typu description który zawiera opis testu,
     * który się nie powiódł oraz wyjątek rzucony przez test
     */

    @Test
    public void test1() {
        assertEquals(2, calculator.add(1,3), 0);
        assertEquals(2, calculator.multiply(2,2), 0);
    }

    @Test
    public void test2() {
        assertEquals(2, calculator.addPositiveNumbers(3,-1), 0);
    }

    @Test
    public void test3() {
        try{
            assertEquals(2, calculator.multiply(2,2), 0);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}