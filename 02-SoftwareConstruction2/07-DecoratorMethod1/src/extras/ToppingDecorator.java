package extras;

import pizza.Pizza;

// This abstract class implements Pizza, this is one key of the Decorator Pattern
public abstract class ToppingDecorator implements Pizza {
	private Pizza wrappedPizza;
	
	public ToppingDecorator(Pizza wrappedPizza) {
		this.wrappedPizza = wrappedPizza;
	}
	
	@Override
	public double cost() {
		return wrappedPizza.cost();
	}
	
	@Override
	public String description() {
		return wrappedPizza.description();
	}
}
