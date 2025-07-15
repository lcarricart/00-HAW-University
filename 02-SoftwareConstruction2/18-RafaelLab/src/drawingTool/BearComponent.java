package drawingTool;

public interface BearComponent extends LocatedRectangle {
    void draw();

    void drawAt(int left, int bottom);

    BearColor getBearColor();

    void setBearColor(BearColor color);

    Pose getPose();

    void setPose(Pose pose);

    Size getSize();
}
