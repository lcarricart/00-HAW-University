package nodes;

public class ParenthesisClosedNode extends AbstractNode {
	public ParenthesisClosedNode() {
		
	}
	
	@Override
	public boolean isValid(char c) {
		return ((c == 41) ? true : false);
	}
}
