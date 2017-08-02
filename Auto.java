package test;

public class Auto implements Vehicle {

	@Override
	public int number_of_tyres() {
		// TODO Auto-generated method stub
		return 3;
	}

	@Override
	public String engine() {
		// TODO Auto-generated method stub
		return "Diesel";
	}

	@Override
	public int seating_capacity() {
		// TODO Auto-generated method stub
		return 4;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int no_of_tyres, capacity;
		String type;
		
		Auto auto = new Auto();
		no_of_tyres = auto.number_of_tyres();
		System.out.println("No of Tyres is " + no_of_tyres);
		
		type = auto.engine();
		System.out.println("Engine type is " + type);
		
		capacity = auto.seating_capacity();
		System.out.println("Seating Capacity is " + capacity);
		
	}

}
