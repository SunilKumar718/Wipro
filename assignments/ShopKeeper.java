package assignments;
import java.util.Scanner;

public class ShopKeeper {
	public static void main(String args[]) {
		double total = 0;
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			
			System.out.print("Enter the Product Number (1-3) or 0 to Exit: ");
			int product = sc.nextInt();
			
			
			if (product==0) {
				break;
			}
			
			System.out.print("enter the Quantity: ");			
			int quantity= sc.nextInt();
			  
			double price=0.0;
			
			
			switch(product) {
			case 1:
				price=22.50;
				break;
			case 2 :
				 price= 44.50;
				break;
			case 3:
		price =9.98;
				break;
			default:
				System.out.println("Invalid Product Number");
				continue;
			}
			total=total+price*quantity;
		}
		System.out.println("Total Retail Value is: "+total);
		sc.close();
		}
		
	}


