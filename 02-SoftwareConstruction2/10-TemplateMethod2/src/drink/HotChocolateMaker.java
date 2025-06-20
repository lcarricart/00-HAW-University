package drink;

public class HotChocolateMaker extends HotDrinkPreparer {
	public HotChocolateMaker() {
		super();
	}
	
	@Override
	protected void preparation() {
		System.out.println("Milk is boiled");
	};
	
	@Override
	protected void brewDrink() {
		System.out.println("Boiled milk added to the cup");
		System.out.println("Chocolate bar added to the cup");
	}

	@Override
	protected void addCondiments() {
		System.out.println("Topped with whipped cream");
		System.out.println("Topped with chocolate powder");
	};
}
