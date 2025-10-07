package test;

public enum Article {
	BASS(1200),
	DRUMS(400),
	GUITAR(300),
	PIANO(3000);

	private int price;
	
	Article(int price) {
		this.price = price;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int value) {
		price = value;
	}
	
	
}
