package setSlides05;

public interface Resizable {
    int getWidth();
    int getHeight();
    void resize(int factor);        // multiplies both dimensions

    /** Returns true if this object can fit entirely inside other. */
    default boolean fitsInside(Resizable other) {
        return (this.getWidth()  <= other.getWidth()) && (this.getHeight() <= other.getHeight());
    }
}
