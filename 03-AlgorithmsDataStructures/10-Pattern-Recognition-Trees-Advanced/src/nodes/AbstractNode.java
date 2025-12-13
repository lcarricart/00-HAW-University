package nodes;

import java.util.ArrayList;
import java.util.List;

/* In computer science, a Tree is not usually a separate manager class; a Tree is simply a Node that happens to be at the top. Since your AbstractNode already manages 
 * a list of children, your AbstractNode IS a Tree structure. If I were to add a DefaultMutableTreeNode on top of it'd be like putting a box inside another identical 
 * box —it creates unnecessary work and confusion. 
 * 
 * Since I am dealing with a potentially complex structure (parsing/validating phone numbers), it is cleaner to create a separate Tree class to deal with algorithms
 * and tree management (How do I traverse from the top to find a match? How do I print the whole structure?)
*/
public abstract class AbstractNode {
	protected List<AbstractNode> children = new ArrayList<AbstractNode>();
	
	public void setChild(int position, AbstractNode child) {
		// No point to have this method delegating to the same method inside ArrayList, but it's cleaner for general implementations
		this.children.add(position, child);
	}
	
	public AbstractNode getChild(int position) {
		if (position < this.children.size()) {
			return this.children.get(position);
		} else {
			return null;
		}
		
		/* The following is considered bad practice, "Exception Programming" is expensive
		 * 
		try {
			return this.children.get(position);
		} catch (IndexOutOfBoundsException e) {
			return null;
		} */
		
		
	}
	
	// Return children array, rather empty (size 0) or with content
	public List<AbstractNode> getChildren() {
		return children;
	}
	
	public abstract boolean isValid(char c);
}
