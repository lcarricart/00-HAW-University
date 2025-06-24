package objects;

public abstract class Hat {
    protected final double size;

    protected Hat(double size) {
        this.size = size;
    }

    public abstract void drawAt(int left, int bottom);
    
    public abstract int getHeight();
}
