package carsEquipment;

public class Leather extends Feature {

	public Leather(Component toBeDecorated) {
		super(toBeDecorated);
	}
	
	@Override
	public String description() {
		return BASIS.description() + " with leather seats";
	}
	
	@Override
	public int getPrice() {
		return BASIS.getPrice() + 7;
	}
}

