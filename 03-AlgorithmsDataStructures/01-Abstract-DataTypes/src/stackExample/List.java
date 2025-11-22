package stackExample;

public class List {
	private Element head;
	private Element tail;
	private int numberOfElements = 0;
	
	public List() {
		head = null;
		tail = null;
	}
	
	public boolean isEmpty() {
		return head == null;
	}
	
	public void addToFront(String s) {
		Element e = new Element(s);
		e.setNext(head);
		
		head = e;
		if (this.isEmpty()) {
			tail = e;
		}
		
		numberOfElements++;
	}
	
	public void addToEnd(String s) {
		Element e = new Element(s);
		tail.setNext(e);
		
		tail = e;
		numberOfElements++;
	}
	
	public void emptyList() {
		// empty list
	}
	
	public void includeAt(int position, String s) {
		// include s at position
		Element newOne = new Element(s);
		Element current = getHead();
		int listPos = 1;
		
		if (position == 1) {
			newOne.setNext(current);
			head = newOne;
		} else {
			while (listPos != position-1) {
				current = current.getNext();
				listPos++;
			}
			
			Element oldNext = current.getNext();
			current.setNext(newOne);
			current.getNext().setNext(oldNext);
		}
		
		numberOfElements++;
	}
	
	public void removeAt(int position) {
		// removes element at position
		
		numberOfElements--;
	}
	
	public int lenght() {
		return numberOfElements;
	}
	
	public Element removeHead() {
		Element oldHead = head;
		head = head.getNext();
		numberOfElements--;
		return oldHead;
	}
	
	public Element getHead() {
		return head;
	}
	
	public Element getTail() {
		return tail;
	}
	
	public boolean search(String itemSearched) {
		Element current = getHead();
		boolean found = false;
		
		while(!found && current != null) {
			found = current.getContents() == itemSearched;
			current = current.getNext();
		}
		
		return found;
	}

	public void print() {
		Element current = getHead();
		String result = "";
		
		if (this.isEmpty()) {
			result = "List is empty";
		}
		
		while (current != null) {
			result += " --> " + current.getContents();
			current = current.getNext();
		}
		
		System.out.println(result);
	}
}
