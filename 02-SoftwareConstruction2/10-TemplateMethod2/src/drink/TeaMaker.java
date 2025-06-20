package drink;

public class TeaMaker extends HotDrinkPreparer {
	public TeaMaker() {
		super();
	}
	
	@Override
	protected void brewDrink() {
		System.out.println("Tea bag placed into the cup");
	}

}
