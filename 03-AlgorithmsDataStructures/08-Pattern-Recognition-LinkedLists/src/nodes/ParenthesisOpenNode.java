package nodes;

public class ParenthesisOpenNode extends AbstractNode {
	public ParenthesisOpenNode() {
		
	}
	
	@Override
	public boolean isValid(char c) {
		return ((c == 40) ? true : false);
	}
}
