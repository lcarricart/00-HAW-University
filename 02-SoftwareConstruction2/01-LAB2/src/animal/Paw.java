package animal;

import java.awt.Color;
import drawingTool.Drawing;

public class Paw {
    private double size;
    private static final Color LIGHT_BROWN = new Color(255, 202, 153);
    private Claw claw1, claw2, claw3;	//composite

    public Paw(double size) {
        this.size = size;
        claw1 = new Claw(size);
        claw2 = new Claw(size);
        claw3 = new Claw(size);
    }

    public void drawAt(double left, double bottom) {
        double xShiftPad  = size / 2;
        double yShiftPad  = size / 3;
        double widthPad   = size * 1.5;
        double heightPad  = size / 1.5;

        double xShiftClaw1 = size / 4;
        double xShiftClaw3 = size / 4;

        Drawing.getPen().setColor(LIGHT_BROWN);
        Drawing.getPen().drawOval((int) (left - xShiftPad), (int) (bottom - yShiftPad), (int) widthPad, (int) heightPad);
        Drawing.getPen().fillOval((int) (left - xShiftPad), (int) (bottom - yShiftPad), (int) widthPad, (int) heightPad);

        claw1.drawAt(left - xShiftClaw1, bottom);
        claw2.drawAt(left, bottom);
        claw3.drawAt(left + xShiftClaw3, bottom);
    }
}
