package setSlides1;

public class Money {
	private int euroCents;
	
	public Money(int euroCents) { 
		if (euroCents < 0) {
			System.out.println("Exception: Negative balance isn't valid");
			// Exceptions is a topic of the last slides sets. Please do not mix yet
		    this.euroCents = 0;
		} else {
			this.euroCents = euroCents;
		}
	}
	
	public void add(int cents) {
		euroCents += cents;
	}
	
	public void subtract(int cents) {
		if (cents > euroCents) {
			System.out.println("Exception: Insufficient balance");
		} else {
			euroCents -= cents;
		}
	}
	
	public String toString() {
		int euros = euroCents / 100;
		int cents = euroCents % 100;
		return "€" + euros + "." + String.format("%02d", cents);
	}
}
