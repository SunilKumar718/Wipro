package assignments;
import java.util.Scanner;

public class ThreeStudents {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int total = 0;
        int students = 3;

        for (int i = 1; i <= students; i++) {
            int mark = -1;

            while (mark < 0 || mark > 100) {
                System.out.print("Enter the mark (0-100) for student " + i + ": ");
                mark = sc.nextInt();

                if (mark < 0 || mark > 100) {
                    System.out.println("Invalid input, try again...");
                }
            }

            total += mark;
        }

        double average = (double) total / students;
        System.out.printf("The average is: %.2f\n", average);

        sc.close();
    }
}
