package background;

import java.awt.Point;

public class Fence {
	private FenceRow fenceRowLow;
	private FenceRow fenceRowHigh;
	private FenceColumn fenceColumnLeft;
	private FenceColumn fenceColumnRight;
	
	public Fence(Point location, int width, int height) {
		setFenceRowLow(new FenceRow(new Point(location.x, location.y+height), width, height));
		setFenceRowHigh(new FenceRow(new Point(location.x, location.y), width, height));
		setFenceColumnLeft(new FenceColumn(new Point(location.x, location.y), width, height));
		setFenceColumnRight(new FenceColumn(new Point(location.x+width+20, location.y), width, height));
	}
	
	public void drawAt() {
		getFenceRowLow().drawAt();
		getFenceRowHigh().drawAt();
		getFenceColumnLeft().drawAtLeft();
		getFenceColumnRight().drawAtRight();
	}
	
	public void drawAt(int pillarsHor, int pillarsVer) {
		getFenceRowLow().drawAt(pillarsHor);
		getFenceRowHigh().drawAt(pillarsHor);
		getFenceColumnLeft().drawAtLeft(pillarsVer);
		getFenceColumnRight().drawAtRight(pillarsVer);
	}

	public FenceColumn getFenceColumnLeft() {
		return fenceColumnLeft;
	}

	public void setFenceColumnLeft(FenceColumn fenceColumnLeft) {
		this.fenceColumnLeft = fenceColumnLeft;
	}

	public FenceColumn getFenceColumnRight() {
		return fenceColumnRight;
	}

	public void setFenceColumnRight(FenceColumn fenceColumnRight) {
		this.fenceColumnRight = fenceColumnRight;
	}

	public FenceRow getFenceRowHigh() {
		return fenceRowHigh;
	}

	public void setFenceRowHigh(FenceRow fenceRowHigh) {
		this.fenceRowHigh = fenceRowHigh;
	}

	public FenceRow getFenceRowLow() {
		return fenceRowLow;
	}

	public void setFenceRowLow(FenceRow fenceRowLow) {
		this.fenceRowLow = fenceRowLow;
	}
}
