package nodes;

public class SpaceNode extends AbstractNode {
	public SpaceNode() {
		
	}

	@Override
	public boolean isValid(char c) {
		return ((c == 32) ? true : false);
	}
}
