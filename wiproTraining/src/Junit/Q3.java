package Junit;

//File: LoginTest.java

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Q3{
	
 static class LoginValidator {
     public static boolean validateLogin(String username, String password) {
         if (username == null || password == null)
             throw new IllegalArgumentException("Username or password cannot be null");

         if (username.isEmpty() || password.isEmpty())
             throw new IllegalArgumentException("Username or password cannot be empty");

         return username.equals("admin") && password.equals("1234");
     }
 }

 @Test
 public void testValidLogin() {
     assertTrue(LoginValidator.validateLogin("admin", "1234"));
 }

 @Test
 public void testInvalidUsername() {
     assertFalse(LoginValidator.validateLogin("user", "1234"));
 }

 @Test
 public void testInvalidPassword() {
     assertFalse(LoginValidator.validateLogin("admin", "wrong"));
 }

 @Test
 public void testNullUsername() {
     Exception ex = assertThrows(IllegalArgumentException.class, () ->
         LoginValidator.validateLogin(null, "1234")
     );
     assertEquals("Username or password cannot be null", ex.getMessage());
 }

 @Test
 public void testNullPassword() {
     Exception ex = assertThrows(IllegalArgumentException.class, () ->
         LoginValidator.validateLogin("admin", null)
     );
     assertEquals("Username or password cannot be null", ex.getMessage());
 }

 @Test
 public void testEmptyUsername() {
     Exception ex = assertThrows(IllegalArgumentException.class, () ->
         LoginValidator.validateLogin("", "1234")
     );
     assertEquals("Username or password cannot be empty", ex.getMessage());
 }

 @Test
 public void testEmptyPassword() {
     Exception ex = assertThrows(IllegalArgumentException.class, () ->
         LoginValidator.validateLogin("admin", "")
     );
     assertEquals("Username or password cannot be empty", ex.getMessage());
 }
}
