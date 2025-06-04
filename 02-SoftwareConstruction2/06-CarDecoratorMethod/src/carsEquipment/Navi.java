package carsEquipment;

public class Navi extends Feature {
	public Navi(Component toBeDecorated) {
		super(toBeDecorated);
	}
	
	@Override
	public String description() {
		return BASIS.description() + "with navigation and AC";		
	}

	@Override
	public int getPrice() {
		return BASIS.getPrice() + 100;		
	}
}
