package assignments;

class Vehicle{
	String color;
	int wheels;
	String model;
	
	Vehicle(String color,int wheels, String model){
		this.color=color;
		this.wheels=wheels;
		this.model=model;
	}
	public void display() {
			System.out.println("Model: "+model);
			System.out.println("color: "+color);
			System.out.println("wheels: "+wheels);
	}
}
	
class Truck extends Vehicle{
	 Truck(String color, int wheels, String model) {
	        super(color, wheels, model);
	
}
	 public void load() {
		 System.out.println("Loading the Logs");
	 }
	}
class Car extends Vehicle{
	Car(String color,int wheels, String model){
		super(color,wheels,model);
	}
	public void music() {
		System.out.println("Music is Playing....");
	}
}

class Bus extends Vehicle{
	Bus(String color,int wheels, String model){
		super(color,wheels,model);
	}
	public void transport() {
		System.out.println("Transporting Passengers..");
	}
}
public class Road {
	public static void main(String[] args) {
		 Truck t1= new Truck("Red", 6, "Tata");
		 t1.display();
		 t1.load();
		 
		 Car c1 = new Car("Blue", 4, "Maruti Swift");
	        c1.display();
	        c1.music();
		 
	        
        Bus b1= new Bus("Yellow", 6, "Volvo");
        b1.display();
        b1.transport();
		
	}

}






//Model: Tata
//color: Red
//wheels: 6
//Loading the Logs
//Model: Maruti Swift
//color: Blue
//wheels: 4
//Music is Playing....
//Model: Volvo
//color: Yellow
//wheels: 6
//Transporting Passengers..

