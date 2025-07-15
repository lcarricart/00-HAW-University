package drawingTool;

public enum Size {
    SMALL(0.5),
    MEDIUM(0.8),
    LARGE(1.2);

    private final double scale;

    Size(double scale) {
        this.scale = scale;
    }

    public double getScale() {
        return scale;
    }
}
