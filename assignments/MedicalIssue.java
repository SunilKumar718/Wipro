package assignments;
import java.util.Scanner;
public class MedicalIssue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Number of classes held: ");
		int classes = sc.nextInt();
		System.out.println("Enter the Number of classes Attended: ");
		int attended = sc.nextInt();
		sc.nextLine();
		System.out.println("Do you have any Medical Issue (Yes/No): ");
		String medical = sc.nextLine();

		
		double percentage = ((double)attended/classes)*100;
		System.out.println("Attendance Percentage is : "+percentage);
		
		if(percentage>70)
		{
			System.out.println("Student is allowed to sit in the Exam");
		}
		else if(medical.equals("Yes") ){
			System.out.println("Student is allowed to sit in the Exam");
		}
		else {
			System.out.println("Student is not allowed to sit in the Exam");
		}
		
		sc.close();

	}

}
