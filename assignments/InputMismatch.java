package assignments;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputMismatch{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter a number: ");
            int number = sc.nextInt();  
            System.out.println("You entered: " + number);
        } catch (InputMismatchException e) {
            System.out.println("Invalid integer");
        }

        sc.nextLine();

        try {
            System.out.print("Enter a string: ");
            String str = sc.nextLine();

            System.out.print("Enter index: ");
            int index = sc.nextInt();

            char ch = str.charAt(index);
            System.out.println("Character at index " + index + ": " + ch);

        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Invalid index for the string.");
        }

    
    }
}

//
//Enter a number: sun
//Invalid integer
//Enter a string: moon
//Enter index: 6
//Invalid index for the string.
