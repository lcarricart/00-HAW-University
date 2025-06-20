package extras;

import pizza.Pizza;

public class MozzarellaDecorator extends ToppingDecorator {
	public MozzarellaDecorator(Pizza wrappedPizza) {
		super(wrappedPizza);
	}
	
	@Override
	public double cost() {
		return super.cost() + 2;
	}
	
	@Override
	public String description() {
		return super.description() + ", mozzarella";
	}
}
