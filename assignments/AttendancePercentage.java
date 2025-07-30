package assignments;
import java.util.Scanner;
public class AttendancePercentage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Number of classes held: ");
		int classes = sc.nextInt();
		System.out.println("Enter the Number of classes Attended ");
		int attended = sc.nextInt();
		double percentage = ((double)attended/classes)*100;
		System.out.println("Attendance Percentage is : "+percentage);
		
		if(percentage>70)
		{
			System.out.println("Student is allowed to sit in the Exam");
		}
		else {
			System.out.println("Student is not allowed to sit in the Exam");
		}
		
		
        sc.close();
	}

}
