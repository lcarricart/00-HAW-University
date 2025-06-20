package extras;

import pizza.Pizza;

public class BasilDecorator extends ToppingDecorator {

	public BasilDecorator(Pizza wrappedPizza) {
		super(wrappedPizza);
	}
	
	@Override
	public double cost() {
		return super.cost() + 1;
	}
	
	@Override
	public String description() {
		return super.description() + ", basil";
	}
}
