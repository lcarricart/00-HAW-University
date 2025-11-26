package nodes;

public class PlusNode extends AbstractNode {
	public PlusNode() {
		
	}

	@Override
	public boolean isValid(char c) {
		return ((c == 43) ? true : false);
	}
}
