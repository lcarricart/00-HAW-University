package extras;

import pizza.Pizza;

public class TomatoSauceDecorator extends ToppingDecorator {

	public TomatoSauceDecorator(Pizza wrappedPizza) {
		super(wrappedPizza);
	}

	@Override
	public double cost() {
		return super.cost() + 0.5;
	}
	
	@Override
	public String description() {
		return super.description() + ", tomato sauce";
	}
}
