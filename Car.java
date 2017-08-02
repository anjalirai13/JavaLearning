package test;

public class Car implements Vehicle {

	@Override
	public int number_of_tyres() {
		// TODO Auto-generated method stub
		return 4;
	}

	@Override
	public String engine() {
		// TODO Auto-generated method stub
		return "Petrol";
	}

	@Override
	public int seating_capacity() {
		// TODO Auto-generated method stub
		return 5;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int no_of_tyres, capacity;
		String type;
		
		Car car = new Car();
		no_of_tyres = car.number_of_tyres();
		System.out.println("No of Tyres is " + no_of_tyres);
		
		type = car.engine();
		System.out.println("Engine type is " + type);
		
		capacity = car.seating_capacity();
		System.out.println("Seating Capacity is " + capacity);
	}

}
