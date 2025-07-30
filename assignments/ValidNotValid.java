package assignments;

import java.util.Scanner;
import java.util.NoSuchElementException;

public class ValidNotValid {
	
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        try {
	            System.out.print("Enter Register Number: ");
	            String regNo = sc.nextLine();

	            System.out.print("Enter Mobile Number: ");
	            String mobile = sc.nextLine();

	            if (regNo.length() != 9 || mobile.length() != 10) {
	                throw new IllegalArgumentException("Length issue");
	            }
	            
	            if (!mobile.matches("\\d+")) {
	                throw new NumberFormatException("Mobile number must contain only digits.");
	            }

	            if (!regNo.matches("[a-zA-Z0-9]+")) {
	                throw new NoSuchElementException("Register number must contain only alphabets and digits.");
	            }
	            System.out.println("valid");
	            

	        } catch (Exception e) {
	            System.out.println("invalid");  
	        }
	    }
	}



//Enter Register Number: 1234567890
//Enter Mobile Number: 987653451728
//invalid

//Enter Register Number: 123456789
//Enter Mobile Number: ahbdi1234
//invalid



