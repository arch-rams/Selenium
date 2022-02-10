package week3.Day1;

public class MyVehicle {

	public static void main(String[] args) {
		Vehicle v = new Vehicle();
		Car car = new Car();
		
		Audi audi = new Audi();
		
		v.applyBrake();
		v.soundHorn();
		
		car.applyBrake();
		car.openDoor();
		
		audi.applyBrake();
		audi.autoPark();
		audi.soundHorn();
	}
}
