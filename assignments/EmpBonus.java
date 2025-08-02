package assignments;

import java.util.Scanner;

public class EmpBonus {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      Scanner sc = new Scanner(System.in);
      System.out.println("Enter Your Salary : ");
      int salary = sc.nextInt();
      System.out.println("Enter No. of Service years: ");
      int years = sc.nextInt();
      
      if (years>6) 
      {
    	 int new_salary= (int)(salary*1.1);
    	  System.out.println("Your salary is incremented to "+new_salary);
      }else {
    	  System.out.println("No change in salary");
      }
      sc.close();
      
	}
	

}
