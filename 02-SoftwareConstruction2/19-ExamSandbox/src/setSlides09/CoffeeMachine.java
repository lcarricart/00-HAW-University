package setSlides09;

public class CoffeeMachine implements AutoCloseable {
	private int waterLeft, coffeeLeft;
	
	public CoffeeMachine(int waterLeft, int coffeeLeft) {
		this.waterLeft = waterLeft;
		this.coffeeLeft = coffeeLeft;
	}
	
	public void brew(CoffeeType ct) throws OutOfIngredientException {
		if (waterLeft < ct.getWater() || coffeeLeft < ct.getCoffee()) {
			throw new OutOfIngredientException("Not enough water or coffee");
		}
		
		waterLeft -= ct.getWater();
		coffeeLeft -= ct.getCoffee();
		
		System.out.println("Serving " + ct + " (" + ct.getWater() + " ml water, " + ct.getCoffee() + "g coffee)");
	}

	@Override
	public void close() {
		System.out.println("Cleaning... done");
	}
}
