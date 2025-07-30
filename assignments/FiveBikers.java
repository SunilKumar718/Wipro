package assignments;
import java.util.Scanner;

public class FiveBikers {
	 public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        double[] speeds = new double[5];  
	        double sum = 0;

	     
	        for (int i = 0; i < 5; i++) {
	            System.out.print("Enter speed of Biker " + (i + 1) + ": ");
	            speeds[i] = sc.nextDouble();
	            sum += speeds[i];
	        }
	        double average = sum / 5;
	        System.out.println("\nAverage Speed: " + average);
	        System.out.println("Qualifying racers (Speed > Average):");
	        for (int i = 0; i < 5; i++) {
	            if (speeds[i] > average) {
	                System.out.println("Biker " + (i + 1) + " with speed: " + speeds[i]);
	            }
	        }

	        sc.close();
	    }
	}



//Enter speed of Biker 1: 70
//Enter speed of Biker 2: 60
//Enter speed of Biker 3: 80
//Enter speed of Biker 4: 95
//Enter speed of Biker 5: 105
//
//Average Speed: 82.0
//Qualifying racers (Speed > Average):
//Biker 4 with speed: 95.0
//Biker 5 with speed: 105.0

