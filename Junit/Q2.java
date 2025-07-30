// File: StringUtilTest.java
package Junit;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Q2 {

    public static String reverse(String input) {
        if (input == null) {
            throw new IllegalArgumentException("Input cannot be null");
        }
        return new StringBuilder(input).reverse().toString();
    }

    @Test
    public void testReverseRegularString() {
        assertEquals("olleh", reverse("hello")); 
        assertEquals("avaJ", reverse("Java"));  
    }

    @Test
    public void testReverseEmptyString() {
        assertEquals("", reverse(""));     
    }

    @Test
    public void testReverseNullInput() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            reverse(null);                      
        });
        assertEquals("Input cannot be null", exception.getMessage());
    }
}
