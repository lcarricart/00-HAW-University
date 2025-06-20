package carsEquipment;

public class AirCon extends Feature {
	public AirCon(Component toBeDecorated) {
		super(toBeDecorated);
	}
	
	@Override
	public String description() {
		return BASIS.description() + " with air condition";
	}
	
	@Override
	public int getPrice() {
		return BASIS.getPrice() + 100; 
	}
	

}
