package test;

import java.util.ArrayList;

public class Customer extends Human {
	private int price = 0;
	private ArrayList<Article> customerCart = new ArrayList<>();
	
	public Customer(String name) { 
		super(name);
	}
	
	public void addToCart(Article a) { 
		// add article a to the cart of the customer
		customerCart.add(a);
	}
	
	public int totalAmountToPay() { 
		// returns the total amount the customer has to pay depending on the contents of his cart
		for (Article myArticle : customerCart) {
			price += myArticle.getPrice();
		}
		
		return price;
	}
}
