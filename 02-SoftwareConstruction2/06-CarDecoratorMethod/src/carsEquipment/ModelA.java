package carsEquipment;

public class ModelA implements Component {

	@Override
	public String description() {
		return "ModelA ";
	}
	
	@Override
	public int getPrice() {
		return 1000;
	}
}
