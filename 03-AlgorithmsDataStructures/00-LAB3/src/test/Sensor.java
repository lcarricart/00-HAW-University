package test;

public class Sensor extends Node { // Integer is my value
	private String id; // Name of something
	
	public Sensor(String id, int value) {
		super(value);
		this.id = id;
	}
	
	// The implementation of the copy constructor inherited from the abstract class
	public Sensor(Sensor toBeCopied) {
		super(toBeCopied);
		this.id = toBeCopied.getId();
	}
	
	public String getId() {
		return id;
	}
}
