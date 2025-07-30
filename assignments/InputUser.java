package assignments;


import java.util.Scanner;

public class InputUser {

	public static void main(String args[]) {
		
		Scanner s1 = new Scanner(System.in);
		System.out.println("Enter your name: ");
		String name = s1.nextLine();
		System.out.println("Enter your rollnumber: ");
		int roll_num = s1.nextInt();
		System.out.println("Enter your area of interest: ");
		String Area_of_interest = s1.nextLine();
		
		
		System.out.println("My name is "+name + "and my roll number is "+roll_num+ " .My Areas of interest are "+Area_of_interest);
		s1.close();	
	}
}
