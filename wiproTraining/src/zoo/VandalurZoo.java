package zoo;

import org.animals.*;

public class VandalurZoo {
	
	 public static void main(String[] args) {

	        Lion l = new Lion();
	        System.out.println("Lion: " + l.sound() + ", Vegetarian? " + l.isVegetarian() + ", Can Climb? " + l.canClimb());

	        Tiger t = new Tiger();
	        System.out.println("Tiger: " + t.sound() + ", Vegetarian? " + t.isVegetarian() + ", Can Climb? " + t.canClimb());

	        Deer d = new Deer();
	        System.out.println("Deer: " + d.sound() + ", Vegetarian? " + d.isVegetarian() + ", Can Climb? " + d.canClimb());

	        Monkey m = new Monkey();
	        System.out.println("Monkey: " + m.sound() + ", Vegetarian? " + m.isVegetarian() + ", Can Climb? " + m.canClimb());

	        Elephant e = new Elephant();
	        System.out.println("Elephant: " + e.sound() + ", Vegetarian? " + e.isVegetarian() + ", Can Climb? " + e.canClimb());

	        Girafee g = new Girafee();
	        System.out.println("Giraffe: " + g.sound() + ", Vegetarian? " + g.isVegetarian() + ", Can Climb? " + g.canClimb());
	    }	
	
}


//Lion: Roar, Vegetarian? false, Can Climb? false
//Tiger: Growl, Vegetarian? false, Can Climb? true
//Deer: Bleat, Vegetarian? true, Can Climb? false
//Monkey: Chatter, Vegetarian? true, Can Climb? true
//Elephant: Trumpet, Vegetarian? true, Can Climb? false
//Giraffe: Hum, Vegetarian? true, Can Climb? false

