package pizza;

import extras.*;

public class QuattroFormaggi implements Pizza {
	private final Pizza pizza;
	
	public QuattroFormaggi() {
		this.pizza = new FontinaDecorator(new GorgonzolaDecorator(new MozzarellaDecorator(new ParmiggianoDecorator(new OreganoDecorator(new TomatoSauceDecorator(new BasePizza()))))));
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
