package assignments;

import java.util.Scanner;

public class Triangle {
	
	public static double area(double a, double b, double c) {
        double s = perimeter(a, b, c) / 2; 
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
	}
        
        public static double perimeter(double a, double b, double c) {
            return a + b + c;
        }
	
	public static boolean isValid(double a, double b, double c) {
        return (a + b > c) && (a + c > b) && (b + c > a);
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("Enter side a (enter -1 to exit): ");
            double a = sc.nextDouble();

            if (a == -1) {
                System.out.println("Bye");
                break;
            }

            System.out.print("Enter side b: ");
            double b = sc.nextDouble();

            System.out.print("Enter side c: ");
            double c = sc.nextDouble();

            if (isValid(a, b, c)) {
                double peri = perimeter(a, b, c);
                double ar = area(a, b, c);
                System.out.printf("Perimeter: %.2f\n", peri);
                System.out.printf("Area: %.2f\n", ar);
            } else {
                System.out.println("The input is invalid.");
            }

            System.out.println(); 
        }

        sc.close();
    }

}


//Enter side a (enter -1 to exit): 8
//Enter side b: 9
//Enter side c: 10
//Perimeter: 27.00
//Area: 34.20
//
//Enter side a (enter -1 to exit): 
//-1
//Bye

