package stackExample;

import java.util.Iterator;

// Defines the way you want to iterate (small to high, first to last, or anything)
public class ListIterator implements Iterator<Element>{
	private List myList;
	private Element nextElement;
	
	public ListIterator(List myList) {
		this.myList = myList;
		this.nextElement = myList.getHead();
	}
	
	@Override
	public boolean hasNext() {
		if (nextElement != null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Element next() {
		if (this.hasNext()) {
			Element current = nextElement;
			nextElement = nextElement.getNext();
			return current;
		} else {
			return null;
		}
	}
}
