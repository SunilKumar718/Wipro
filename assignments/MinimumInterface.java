package assignments;

import java.util.Scanner;

@FunctionalInterface
interface MinThree {
	    float find(float a, float b, float c);
	}

public class MinimumInterface{

	    public static float getMin(float a, float b, float c) {
	        return Math.min(a, Math.min(b, c));
	    }

	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);

	        System.out.print("Enter first number: ");
	        float num1 = sc.nextFloat();

	        System.out.print("Enter second number: ");
	        float num2 = sc.nextFloat();

	        System.out.print("Enter third number: ");
	        float num3 = sc.nextFloat();

	        MinThree minRef = MinimumInterface::getMin;

	        float result = minRef.find(num1, num2, num3);
	        System.out.println("The smallest number is: " + result);
	        sc.close();	    
}
}



//Enter first number: 35
//Enter second number: 40
//Enter third number: 58
//The smallest number is: 35.0
