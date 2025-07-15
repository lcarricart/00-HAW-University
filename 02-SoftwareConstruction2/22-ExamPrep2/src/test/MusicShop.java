package test;

import java.util.ArrayList;

public class MusicShop implements Shop {
	private ArrayList<Article> articles = new ArrayList<>();
	private ArrayList<Customer> customers = new ArrayList<>();
	
	public MusicShop() { }
	
	public void buy(Customer c, Article a) {
		 // customer c is to be added to the list of customers of the shop
		customers.add(c);
		 // article a is to be added to the cart of customer c, if article a is still available in the shop
		if (articleExists(a)) {
			c.addToCart(a);
		}
		 // article a is to be removed from the shop, if article was still available
		articles.remove(a);
	}
	
	public int count(Article a) {
		// returns the number of articles of type a, available in the shop
		int i = 0;
		
		for (Article myArticle : articles) {
			if (myArticle == a) {
				i++;
			}
		}
		
		return i;
	}
	
	public int totalAsset() {
		// returns the total value of all articles (the sum of their prices)
		int totalPrice = 0;
		
		for (Article myArticle : articles) {
			totalPrice += myArticle.getPrice();
		}
		
		return totalPrice;
	}
	
	private boolean articleExists(Article a) {
		// returns true if the article a is (at least once) available in the shop
		if (articles.contains(a)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void add(Article a) {
		articles.add(a);
		
	}

	@Override
	public void printAllArticles() {
		for (Article myArticle : articles) {
			System.out.print(myArticle + " ");
		}
		System.out.println();
	}
}
