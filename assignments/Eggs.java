package assignments;
import java.util.Scanner;

public class Eggs {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		System.out.print("Enter the Number of eggs: " );
//		int N_eggs = Integer.parseInt(args[0]);
		int N_eggs= sc.nextInt();
		int gross = N_eggs/144;
		int remaining= N_eggs%144;
		int dozen = remaining/12;
		int leftOver= remaining%12;		
		System.out.println("Your Number of eggs is "+gross+" Gross, "+dozen+" dozen, and "+leftOver+" remaining.");
	     
		sc.close();
		 
	}

}
