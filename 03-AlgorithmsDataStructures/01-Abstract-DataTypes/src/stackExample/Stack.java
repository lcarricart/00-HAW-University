package stackExample;

public class Stack {
	private List names;
	
	public Stack() {
		names = new List();
	}
	
	public boolean empty() {
		return names.empty();
	}
	
	public void push(String s) {
		names.addToFront(s);
	}
	
	public String top() {
		if (names.getHead() != null) {
			return names.getHead().getContents();
		} else {
			return "No element on stack";
		}
	}
	
	public String pop() {
		return names.removeHead().getContents();
	}
}

