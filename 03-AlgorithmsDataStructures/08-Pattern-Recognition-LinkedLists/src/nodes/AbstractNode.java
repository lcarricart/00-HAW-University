package nodes;

public abstract class AbstractNode {
	protected AbstractNode next;
	
	public void setNext(AbstractNode node) {
		this.next = node;
	}
	
	public AbstractNode getNext() {
		return next;
	}
	
	public abstract boolean isValid(char c);
}
