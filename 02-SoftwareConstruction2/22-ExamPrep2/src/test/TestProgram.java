package test;

public class TestProgram {
	private MusicShop m;
	
	public static void main(String[] args) {
		new TestProgram().run();
	}
	
	public void run() {
		 // generate a shop
		m = new MusicShop();
		 // generate in a loop randomly k=12 musical instruments and add them to the shop
		int index;
		int min = 0;
		int max = Article.values().length - 1;
		
		for (int i = 0; i < 12; i++) {
			index = this.between(min, max);
			m.add(Article.values()[index]);
		}
		 // call the functions you implemented in classes Shop and Customer in order to test them:
		 // 1. print all available instruments on the console and print the total asset of the shop
		m.printAllArticles();
		System.out.println("The total assets of the shop are worth $" + m.totalAsset());
		
		 // 2. print the number of instruments on the console
		int totalNumber =  m.count(Article.BASS) + m.count(Article.DRUMS) + m.count(Article.GUITAR) + m.count(Article.PIANO);
		System.out.println("The total number of available instruments is " + totalNumber);
				
		 // 3. consider at least one customer who buys a musical instrument.
		Customer benito = new Customer("Benito");
		Customer apu = new Customer("APU");
		
		m.buy(benito, Article.BASS);
		m.buy(benito, Article.DRUMS);
		m.buy(benito, Article.PIANO);
		
		m.buy(apu, Article.PIANO);
		
		 // 4. print the amount the customer has to pay
		System.out.println(benito.getName() + " needs to pay " + benito.totalAmountToPay());
		System.out.println(apu.getName() + " needs to pay " + apu.totalAmountToPay());
		System.out.println();
		
		 // 5. print again all available instruments on the console and the shops asset
		m.printAllArticles();
		totalNumber =  m.count(Article.BASS) + m.count(Article.DRUMS) + m.count(Article.GUITAR) + m.count(Article.PIANO);
		System.out.println("The total number of available instruments is " + totalNumber);
		System.out.println("The total assets of the shop are worth $" + m.totalAsset());
	}
	
	private int between(int min, int max) { 
		return (int) (Math.random() * ((max - min) + 1) + min);
	}
}