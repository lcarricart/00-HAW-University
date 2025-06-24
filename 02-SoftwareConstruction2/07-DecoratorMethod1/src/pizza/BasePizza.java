package pizza;

public class BasePizza implements Pizza {
	private double doughCost = 2;
	private double productionCost = 2;
	
	public BasePizza() { }
	
	@Override
	public double cost() {
		return doughCost + productionCost;
	}

	@Override
	public String description() {
		return "plain base pizza";
	}
}
