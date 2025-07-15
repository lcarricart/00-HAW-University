package drawingTools;

public class RandomNumber {     //I dont use this
    public static int between(int min, int max) {
        return (int) (Math.random() * ((max - min) + 1) + min);
    }
}
