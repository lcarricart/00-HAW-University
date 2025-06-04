package animal;

import java.awt.Color;
import drawingTool.Drawing;

public class Nose {
    private double size;
    private static Color lightBrown = new Color(255, 202, 153);
    private NoseWhole noseWhole1, noseWhole2;

    public Nose(double size) {
        this.size = size;
        double noseSize = size / 4;
        
        noseWhole1 = new NoseWhole(noseSize);
        noseWhole2 = new NoseWhole(noseSize);
    }

    public void drawAt(double left, double bottom) {
        double widthNose = size;
        double heightNose = size * 2;

        double xShiftWhole2 = size / 1.5;
        double yShiftWhole = size;

        Drawing.getPen().setColor(lightBrown);
        Drawing.getPen().drawOval((int) left, (int) bottom, (int) widthNose, (int) heightNose);
        Drawing.getPen().fillOval((int) left, (int) bottom, (int) widthNose, (int) heightNose);

        noseWhole1.drawAt(left, bottom + yShiftWhole);
        noseWhole2.drawAt(left + xShiftWhole2, bottom + yShiftWhole);
    }
}
