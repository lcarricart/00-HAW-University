package nodes;



public class DigitNode extends AbstractNode {
	public DigitNode() {
		
	}
	
	@Override
	public boolean isValid(char c) {
		return Character.isDigit(c);
	}
}
