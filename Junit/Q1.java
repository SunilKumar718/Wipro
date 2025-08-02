package Junit;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Q1 {

    public static int factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Negative numbers are not allowed");
        }
        int result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    @Test
    public void testFactorialValidInputs() {
        assertEquals(1, Q1.factorial(0));  
        assertEquals(1, Q1.factorial(1));   
        assertEquals(720, Q1.factorial(6)); 
    }

    @Test
    public void testFactorialNegativeInput() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Q1.factorial(-3);
        });
        assertEquals("Negative numbers are not allowed", exception.getMessage());
    }
}
