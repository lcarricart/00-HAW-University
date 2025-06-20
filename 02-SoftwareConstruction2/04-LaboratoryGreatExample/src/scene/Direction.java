package scene;

import java.awt.Point;
import java.awt.event.KeyEvent;

public enum Direction {
	LEFT,
	RIGHT,
	DOWN,
	UP,
	UP_RIGHT,
	UP_LEFT,
	DOWN_RIGHT,
	DOWN_LEFT;
	
	public static Direction getDirection(Point direction) {
		switch(direction.x) {
			case -1: return LEFT;
			case 1: return RIGHT;
			default: break;
		}
		switch(direction.y) {
			case -1: return UP;
			case 1: return DOWN;
			default: break;
		}
		return null;
	}
	
	public static Point keyToPoint(int key, Point lastKey) {
		switch(key) {
		case KeyEvent.VK_LEFT:
			return new Point(-1,0);

		case KeyEvent.VK_RIGHT:
			return new Point(1,0);
			
		case KeyEvent.VK_UP:
			return new Point(0,-1);
			
		case KeyEvent.VK_DOWN:
			return new Point(0,1);
		default:
			return lastKey;
		}
	}
	
}
