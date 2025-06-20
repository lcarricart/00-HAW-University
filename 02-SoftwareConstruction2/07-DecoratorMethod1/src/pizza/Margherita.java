package pizza;

import extras.*;

public class Margherita implements Pizza {
	private final Pizza pizza;
	
	public Margherita() {
		this.pizza = new OreganoDecorator(new BasilDecorator(new MozzarellaDecorator(new TomatoSauceDecorator(new BasePizza()))));
	}
	
	@Override
	public double cost() {
		return pizza.cost();
	}

	@Override
	public String description() {
		return pizza.description();
	}
}
