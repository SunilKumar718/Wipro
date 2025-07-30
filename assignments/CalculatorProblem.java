package assignments;


class  Calculator{
	
	
	void add(int num1,int num2) {
		System.out.println("Sum is: "+ (num1+num2));
	}
	void diff(int num1,int num2) {
		System.out.println("diff is: "+ (num1-num2));
		
	}
	void mul(int num1,int num2) {
		System.out.println("Mul is: "+ num1*num2);
		
	}
	void div(int num1,int num2) {
		System.out.println("Div is: "+ num1/num2);
		
	}
}
public class CalculatorProblem {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		Calculator obj= new Calculator();
		
		int a= 50;
		int b= 20;
		obj.add(a,b);
		obj.diff(a,b);
		obj.mul(a,b);
		obj.div(a,b);
		

	}

}
