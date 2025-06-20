package carsEquipment;

public class Test {

	public static void main(String[] args) {
		ModelA myCar = new  ModelA();
		AirCon withAirCon = new AirCon(myCar);
		Navi withNaviAndAirCon = new Navi(withAirCon);
		Leather withAll = new Leather(withAirCon);
		System.out.println("My car is " + myCar.description());
		System.out.println("It costs " + myCar.getPrice() + " EUR");

		AirCon aCar = new AirCon(new Navi(new ModelB()));
		System.out.println("A car is " + aCar.description());
		System.out.println("It costs " + aCar.description());

	}

}
