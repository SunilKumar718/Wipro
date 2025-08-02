package assignments;



abstract class Person{
	abstract void eat();
	abstract void exercise();
}

class Athlete extends Person{
	void eat() {
		System.out.println("Eats Nutritious Food..");
	}
	
	void exercise() {
		System.out.println("Exercises Daily..");
	}
}

class LazyPerson extends Person{
	void eat() {
		System.out.println("Eats Normal Food..");
	}
	
	void exercise() {
		System.out.println("Exercises Once in a While..");
	}
}
public class AbstractPerson {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         Person a=new Athlete();
         a.eat();
         a.exercise();
         
         Person l=new LazyPerson();
         l.eat();
         l.exercise();
         
	}

}


//Eats Nutritious Food..
//Exercises Daily..
//Eats Normal Food..
//Exercises Once in a While..

