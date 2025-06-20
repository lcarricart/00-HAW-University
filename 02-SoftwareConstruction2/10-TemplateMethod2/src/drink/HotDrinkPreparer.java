package drink;

public abstract class HotDrinkPreparer {
	
	// Backbone, public template
	public final void makeDrink() {
		boilWater();
		preparation();
		brewDrink();
		pourIntoCup();
		addCondiments();
	}
	
	protected final void boilWater() {
		System.out.println("Water is boiled");
	}
	
	// Optional
	protected void preparation() { };
	
	// Must be implemented
	protected abstract void brewDrink();
	
	protected final void pourIntoCup() {
		System.out.println("Drink is poured into the cup");
	}
	
	// Optional
	protected void addCondiments() { };
}
