package drawingTool;

import java.util.ArrayList;
import java.awt.Color;

public class Scene {
    private static final int X_MIN = 100;
    private static final int X_MAX = 1000;
    private static final int Y_MIN = 200;
    private static final int Y_MAX = 700;
    private static final int MAX_ATTEMPTS = 10000;

    private int bearCount;
    private ArrayList<BearComponent> bears = new ArrayList<>();

    public Scene() {
        bearCount = RandomNumber.between(3, 7);
        initializeBearsSafely(Size.SMALL, BearColor.BROWN, Pose.NORMAL);
    }

    public void draw() {
        for (BearComponent bear : bears) bear.draw();
    }

    public void clearBears() {
        bears.clear();
    }

    public void addBear(BearComponent bear) {
        bears.add(bear);
    }

    public void setAllColors(BearColor color) {
        for (BearComponent bear : bears) bear.setBearColor(color);
    }

    public void setAllSizes(Size size) {
        ArrayList<BearComponent> newBears = new ArrayList<>();
        bearCount = bears.size();

        for (int attempt = 0; attempt < MAX_ATTEMPTS && newBears.size() < bearCount; attempt++) {
            int x = RandomNumber.between(X_MIN, X_MAX);
            int y = RandomNumber.between(Y_MIN, Y_MAX);
            BearComponent bear = new BrownBear(x, y, size, BearColor.BROWN, Pose.NORMAL);

            if (!hasIntersections(bear, newBears)) newBears.add(bear);
        }

        bears = newBears;
    }

    public void setAllPoses(Pose pose) {
        for (BearComponent bear : bears) bear.setPose(pose);
    }

    public void setMixedColors() {
        BearColor[] values = BearColor.values();
        for (BearComponent bear : bears)
            bear.setBearColor(values[RandomNumber.between(0, values.length - 1)]);
    }

    public void setMixedSizes() {
        Size[] sizes = Size.values();
        ArrayList<BearComponent> newBears = new ArrayList<>();
        bearCount = bears.size();

        for (int attempt = 0; attempt < MAX_ATTEMPTS && newBears.size() < bearCount; attempt++) {
            int x = RandomNumber.between(X_MIN, X_MAX);
            int y = RandomNumber.between(Y_MIN, Y_MAX);
            Size randomSize = sizes[RandomNumber.between(0, sizes.length - 1)];
            BearComponent bear = new BrownBear(x, y, randomSize, BearColor.BROWN, Pose.NORMAL);

            if (!hasIntersections(bear, newBears)) newBears.add(bear);
        }

        bears = newBears;
    }

    public void setMixedPoses() {
        Pose[] values = Pose.values();
        for (BearComponent bear : bears)
            bear.setPose(values[RandomNumber.between(0, values.length - 1)]);
    }

    public void setOriginalVariations() {
        bearCount = RandomNumber.between(3, 7);
        initializeBearsSafely(Size.SMALL, BearColor.BROWN, Pose.NORMAL);
    }

    private void initializeBearsSafely(Size size, BearColor color, Pose pose) {
        bears.clear();

        for (int attempt = 0; attempt < MAX_ATTEMPTS && bears.size() < bearCount; attempt++) {
            int x = RandomNumber.between(X_MIN, X_MAX);
            int y = RandomNumber.between(Y_MIN, Y_MAX);
            BearComponent candidate = new BrownBear(x, y, size, color, pose);

            if (!hasIntersections(candidate, bears)) bears.add(candidate);
        }
    }

    private boolean hasIntersections(BearComponent newBear, ArrayList<BearComponent> existingBears) {
        for (BearComponent bear : existingBears) {
            if (newBear.intersects(bear)) return true;
        }
        return false;
    }

    public void replaceBear(BearComponent oldBear, BearComponent newBear) {
        int index = bears.indexOf(oldBear);
        if (index != -1) bears.set(index, newBear);
    }

    public void setMixedDecorations() {
        Color[] eyeColors = {Color.BLUE, Color.GREEN, Color.RED, Color.YELLOW, Color.CYAN};
        Color[] headColors = {
            new Color(139, 69, 19),
            new Color(100, 50, 10),
            new Color(50, 30, 10),
            new Color(200, 150, 100),
            new Color(150, 100, 50)
        };

        for (int i = 0; i < bears.size(); i++) {
            BearComponent bear = bears.get(i);
            int choice = RandomNumber.between(0, 3);
            BearComponent decoratedBear = switch (choice) {
                case 0 -> new HatDecorator(bear);
                case 1 -> new WandDecorator(bear);
                case 2 -> new EyeColorDecorator(bear, eyeColors[RandomNumber.between(0, eyeColors.length - 1)]);
                case 3 -> new HeadColorDecorator(bear, headColors[RandomNumber.between(0, headColors.length - 1)]);
                default -> bear;
            };
            replaceBear(bear, decoratedBear);
        }
    }

    public ArrayList<BearComponent> getBears() {
        return bears;
    }
}
