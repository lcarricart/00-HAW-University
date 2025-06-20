package pizza;

public interface Pizza {
	// Interfaces define no instance state to initialize, so there’s nothing for a constructor to do.
	// All initialization must happen in the implementing classes (or in an abstract base class they extend).
	
	public abstract double cost();
	public abstract String description();
}
