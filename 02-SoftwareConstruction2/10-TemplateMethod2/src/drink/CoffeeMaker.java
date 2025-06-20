package drink;

public class CoffeeMaker extends HotDrinkPreparer {
	public CoffeeMaker() {
		super();
	}
	
	@Override
	protected void preparation() {
		System.out.println("Grinding coffee");
		System.out.println("Smashing");
	};
	
	@Override
	protected void brewDrink() {
		System.out.println("Brewing coffee");
	}

}
