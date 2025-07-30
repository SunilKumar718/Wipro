package assignments;

abstract class MyVehicle{
	
	abstract void startengine();
	
	abstract void stopengine();

	
}

class MyCar extends MyVehicle{
	
	 void startengine() {
		System.out.println("Car Engine Started....");

	}
	
	 void stopengine() {
		System.out.println("Car Engine Stopped...");

	}
	
}


class MyMotorCycle extends MyVehicle{
	
	void startengine() {
		System.out.println("Bike Engine Started....");

	}
	
    void stopengine() {
		System.out.println("Bike Engine Stopped.....");

	}
	
}

public class AbstractVehicle {

	public static void main(String[] args) {
		
		MyVehicle mc = new MyMotorCycle();
		mc.startengine();
		mc.stopengine();
		
		MyVehicle c= new MyCar();
		c.startengine();
		c.stopengine();
		// TODO Auto-generated method stub

	}

}




//Bike Engine Started....
//Bike Engine Stopped.....
//Car Engine Started....
//Car Engine Stopped...

