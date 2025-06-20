package carsEquipment;

public abstract class Feature implements Component {
	protected final Component BASIS;
	
	public Feature(Component toBeDecorated) {
		this.BASIS = toBeDecorated;
	}

}
