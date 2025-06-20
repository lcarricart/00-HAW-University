package extras;

import pizza.Pizza;

public class ParmiggianoDecorator extends ToppingDecorator {
	public ParmiggianoDecorator(Pizza wrappedPizza) {
		super(wrappedPizza);
	}
	
	@Override
	public double cost() {
		return super.cost() + 1.5;
	}
	
	@Override
	public String description() {
		return super.description() + ", parmeggiano";
	}
}
