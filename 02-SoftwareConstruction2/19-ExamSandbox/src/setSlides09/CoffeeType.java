package setSlides09;

public enum CoffeeType {
    ESPRESSO   (30,  18),
    AMERICANO  (150, 18),
    LATTE      (200, 18);

    private final int waterMl;
    private final int coffeeGram;

    CoffeeType(int waterMl, int coffeeGram) {
        this.waterMl   = waterMl;
        this.coffeeGram = coffeeGram;
    }
    public int water()  { return waterMl; }
    public int coffee() { return coffeeGram; }
    
    public int getWater() {
    	return waterMl;
    }
    
    public int getCoffee() {
    	return coffeeGram;
    }
}
