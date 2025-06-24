package animal;

import java.awt.Color;
import drawingTool.Drawing;

public class Claw {
    private double size;

    public Claw(double size) {
        this.size = size;
    }

    public void drawAt(double left, double bottom) {
        double xShiftClaw = size / 5;
        double widthClaw = size / 4;
        double heightClaw = size / 3;

        Drawing.getPen().setColor(Color.BLACK);
        Drawing.getPen().fillArc((int) (left - xShiftClaw), (int) bottom, (int) widthClaw, (int) heightClaw, 0, 180);
    }
}
