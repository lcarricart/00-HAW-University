package carsEquipment;

public class ModelB implements Component {

	@Override
	public String description() {
		return "ModelB ";
	}
	
	@Override
	public int getPrice() {
		return 2000;
	}
}