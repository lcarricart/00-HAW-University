package drawingTool;

import java.awt.Point;

public interface LocatedRectangle {
	public Point getAddress();
	public int getWidth();
	public int getHeight();
	public void draw();

	public default boolean intersects(LocatedRectangle other) {
		return !doesNotIntersect(other, 0);
	}	
	
	public default boolean intersects(LocatedRectangle other, int margin) {
		return !doesNotIntersect(other, margin);
	}
	
	private boolean doesNotIntersect(LocatedRectangle other, int margin) {
		return 	leftOf(other, margin) || rightOf(other, margin) || 
				above(other, margin) || below(other, margin);
	}
	
	public default boolean leftOf(LocatedRectangle other, int margin){
		return this.getAddress().x + this.getWidth() + margin < other.getAddress().x;
	}
	
	public default boolean rightOf(LocatedRectangle other, int margin){
		return this.getAddress().x > other.getAddress().x + other.getWidth() + margin;
	}
	
	private boolean above(LocatedRectangle other, int margin) {
		return this.getAddress().y + this.getHeight() + margin <= other.getAddress().y;
	}
	
	private boolean below(LocatedRectangle other, int margin) {
		return this.getAddress().y >= other.getAddress().y + other.getHeight() + margin;
	}
}