package setSlides7;

public abstract class Shape {
    private final String name;

    protected Shape(String name) { this.name = name; }

    /** Template method – common algorithm, never overridden */
    public final void report() {
        System.out.println(name + " area = " + area());
    }

    /** Hook — every concrete shape must supply its own formula */
    protected abstract double area();
}