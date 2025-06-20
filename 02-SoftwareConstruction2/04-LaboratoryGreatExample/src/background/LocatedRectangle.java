package background;
import java.awt.Color;
import java.awt.Point;

import scene.Drawing;

public interface LocatedRectangle {
	
	/**
	 * An interface for rectangular objects.
	 * 
	 * @author Björn Gottfried
	 * @version 1.0
	 */
		public Point address();
		public Point direction();
		public int width();
		public int height();
		public void draw();
		public void setAddress(Point location);
		public void setWidth(int width);
		public void setHeight(int height);
		public void setDirection(Point direction);
		public void setSpeed(Point speed);
		public Point getSpeed();
		
		public default void hitBoxVisible(LocatedRectangle other) {
			Drawing.pen().setColor(Color.black);
			Drawing.pen().drawRect(other.address().x, other.address().y, other.width(), other.height());
		}

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
			return this.address().x + this.width() + margin < other.address().x;
		}
		
		public default boolean rightOf(LocatedRectangle other, int margin){
			return this.address().x > other.address().x + other.width() + margin;
		}
		
		public default boolean above(LocatedRectangle other, int margin) {
			return this.address().y + this.height() + margin <= other.address().y;
		}
		
		public default boolean below(LocatedRectangle other, int margin) {
			return this.address().y >= other.address().y + other.height() + margin;
		}
}
