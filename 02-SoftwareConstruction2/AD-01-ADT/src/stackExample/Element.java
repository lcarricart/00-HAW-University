package stackExample;

public class Element {
	private String element;
	private Element next;
	
	public Element(String element) {
		this.element = element;
		next = null;
	}
	
	public void setNext(Element nextOne) {
		next = nextOne;
	}
	
	public Element getNext() {
		return next;
	}
	
	public String getContents() {
		return element;
	}
}
