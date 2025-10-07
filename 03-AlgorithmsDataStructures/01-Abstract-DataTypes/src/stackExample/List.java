package stackExample;

public class List {
	private Element head;
	
	public List() {
		head = null;
	}
	
	public boolean empty() {
		return head == null;
	}
	
	public void append(String s) {
		Element e = new Element(s);
		e.setNext(head);
		head = e;
	}
	
	public Element removeHead() {
		Element oldHead = head;
		head = head.getNext();
		return oldHead;
	}
	
	public Element getHead() {
		return head;
	}
}
