package main;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    Main main;
    final static double EPS = 1e-9;

    @BeforeEach
    void setUp() {
        main = new Main();
    }

    @Test
    void testCountA() {
        int expected = 5;
        int res = main.countA("abracadabra");
        assertEquals(expected, res, "count A is incorrect");
    }

    @Test
    void testSum() {
        double a = 1.0;
        double b = -0.8;
        double expected = 0.2;
        double res = main.sum(a, b);
        assertEquals(expected, res, EPS);
    }
}