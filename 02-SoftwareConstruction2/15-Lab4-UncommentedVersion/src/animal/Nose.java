package animal;

import java.awt.Color;
import drawingTool.Drawing;

public class Nose {
    private double size;
    private NoseWhole noseWhole1, noseWhole2;	//composite

    public Nose(double size) {
        this.size = size;
        double WholeSize = size / 4;
        
        noseWhole1 = new NoseWhole(WholeSize);
        noseWhole2 = new NoseWhole(WholeSize);
    }

    public void drawAt(double left, double bottom) {
        double widthNose = size * 2.2;
        double heightNose = size;

        double xShiftWhole2 = size / 2.2;
        
        double yShiftWhole = size / 3.2;

        Drawing.getPen().setColor(Color.BLACK);
        Drawing.getPen().drawOval((int) left, (int) bottom, (int) widthNose, (int) heightNose);
        Drawing.getPen().fillOval((int) left, (int) bottom, (int) widthNose, (int) heightNose);

        noseWhole1.drawAt((left + xShiftWhole2), bottom + yShiftWhole);
        noseWhole2.drawAt((left + xShiftWhole2 * 3), bottom + yShiftWhole);
    }
}
