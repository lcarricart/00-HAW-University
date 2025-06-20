package extras;

import pizza.Pizza;

public class OreganoDecorator extends ToppingDecorator{
	public OreganoDecorator(Pizza wrappedPizza) {
		super(wrappedPizza);
	}
	
	@Override
	public double cost() {
		return super.cost() + 0.5;
	}
	
	@Override
	public String description() {
		return super.description() + ", oregano";
	}
}
