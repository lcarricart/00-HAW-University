package animal;

import drawingTool.Drawing;
import java.awt.Color;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

public class Fur {
	private double sizeFur, step;
	private final Color CHROME = new Color (219,226,233);

	public Fur() {
		
	}
	
	// Normal case
	public void draw(int left, int bottom, double width, double height, int shape) {
		if (shape == 0) {			//oval
			sizeFur = ((width + height) / 2) / 50;
			step = ((width + height) / 2) / 12;
			
			List<Point2D.Double> pts = Fur.pointsInOval(left, bottom, width, height, step); 		//x, y, width, height, step
			
			for (Point2D.Double p : pts) {
				Drawing.getPen().setColor(Color.BLACK);
				Drawing.getPen().drawOval((int) p.x, (int) p.y, (int) sizeFur, (int) sizeFur);
				Drawing.getPen().setColor(CHROME);
				Drawing.getPen().fillOval((int) p.x, (int) p.y, (int) sizeFur, (int) sizeFur);
			}
		} else if (shape == 1) {	//rectangle
	        List<Point2D.Double> pts = Fur.pointsInRectangle(left, bottom, width, height, 10);
	        
			for (Point2D.Double p : pts) {
				Drawing.getPen().setColor(Color.BLACK);
				Drawing.getPen().drawOval((int) p.x, (int) p.y, (int) sizeFur, (int) sizeFur);
				Drawing.getPen().setColor(CHROME);
				Drawing.getPen().fillOval((int) p.x, (int) p.y, (int) sizeFur, (int) sizeFur);
			}
		}
	}
	
	// Different color case
	public void draw(int left, int bottom, double width, double height, Color chosenColor, int shape) {
		if (shape == 0) {
			sizeFur = ((width + height) / 2) / 70;
			step = ((width + height) / 2) / 3;
			
			List<Point2D.Double> pts2 = Fur.pointsInOval(left, bottom, width, height, step); 		//x, y, width, height, step
			
			for (Point2D.Double p : pts2) {
				Drawing.getPen().setColor(Color.BLACK);
				Drawing.getPen().drawOval((int) p.x, (int) p.y, (int) sizeFur, (int) sizeFur);
				Drawing.getPen().setColor(chosenColor);
				Drawing.getPen().fillOval((int) p.x, (int) p.y, (int) sizeFur, (int) sizeFur);
			}
		}
	}
	
    public static List<Point2D.Double> pointsInOval(double x, double y, double width, double height, double step) {
        List<Point2D.Double> points = new ArrayList<>();

        double centerX = x + width  / 2.0;
        double centerY = y + height / 2.0;
        double widthEllipse = width  / 2.0;         
        double heightEllipse = height / 2.0;

        for (double i = x; i <= x + width;  i += step) {
            double dx2 = Math.pow((i - centerX) / widthEllipse, 2); 		 // (...x)^2 in the ellipse formula
            
            for (double j = y; j <= y + height ; j += step) {
                double dy2 = Math.pow((j - centerY) / heightEllipse, 2);	// (...y)^2 in the ellipse formula
                
                if (insideEllipseBorder(dx2, dy2)) {
                    points.add(new Point2D.Double(i, j));
                }
            }
        }
        return points;
    }
    
    public static boolean insideEllipseBorder(double dx2, double dy2) {
    	return dx2 + dy2 <= 1.0;
    }
    
	public static List<Point2D.Double> pointsInRectangle(double x, double y, double width, double height, double step) {
        List<Point2D.Double> points = new ArrayList<>();

        for (double i = x; i <= x + width; i += step) {
            for (double j = y; j <= y + height; j += step) {
                points.add(new Point2D.Double(i, j));
            }
        }
        return points;
    }
}
