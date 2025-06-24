
public enum Lights {
	RED_YELLOW (),
	RED (RED_YELLOW),
	YELLOW (RED),
	GREEN (YELLOW);
	
	private Lights successor;
	
	private Lights() {
		successor = null;
	}
	
	private Lights(Lights successor) {
		this.successor = successor;
	}
	
	private Lights getSuccessor() {
		return successor;
	}
}
