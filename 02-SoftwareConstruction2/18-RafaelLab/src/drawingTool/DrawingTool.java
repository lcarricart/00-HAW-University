package drawingTool;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DrawingTool extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;

    private static final String WINDOW_TITLE = "My Bear Scene";
    private static final int SIZE_SMALL_INDEX = 0;
    private static final int COLOR_SLIDER_BROWN = 0;
    private static final int COLOR_SLIDER_DARK_BROWN = 1;

    private final Size[] sizes = { Size.SMALL, Size.MEDIUM, Size.LARGE };

    private DrawingArea drawing;
    private Buttons buttons = new Buttons();

    private boolean isDancing = false;
    private int currentSizeIndex = SIZE_SMALL_INDEX;

    public DrawingTool(String title) {
        super(title);
        initializeUI();
    }

    private void initializeUI() {
        setLayout(new BorderLayout());
        setupButtons();
        setupDrawingArea();
        configureWindow();
    }

    private void setupButtons() {
        buttons.addButtonsToPanel(this);
        buttons.addActionListener(this);
    }

    private void setupDrawingArea() {
        drawing = new DrawingArea();
        add(drawing, BorderLayout.CENTER);
    }

    private void configureWindow() {
        Dimension screenSize = getToolkit().getScreenSize();
        setBounds(0, 0, screenSize.width, screenSize.height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void refreshDrawingArea() {
        drawing.revalidate();
        drawing.repaint();
    }

    // === Handle Button Actions ===
    @Override
    public void actionPerformed(ActionEvent e) {
        Scene scene = drawing.getScene();
        refreshDrawingArea();

        if (e.getSource() == buttons.getNextColorButton()) {
            handleRandomColor(scene);
        } else if (e.getSource() == buttons.getMixedColorButton()) {
            scene.setMixedColors();
        } else if (e.getSource() == buttons.getNextSizeButton()) {
            cycleSize(scene);
        } else if (e.getSource() == buttons.getMixedSizeButton()) {
            scene.setMixedSizes();
        } else if (e.getSource() == buttons.getNextPoseButton()) {
            togglePose(scene);
        } else if (e.getSource() == buttons.getMixedPoseButton()) {
            scene.setMixedPoses();
        } else if (e.getSource() == buttons.getApplyColorButton()) {
            applySelectedColor(scene);
        } else if (e.getSource() == buttons.getResetButton()) {
            resetScene(scene);
        } else if (e.getSource() == buttons.getHatButton()) {
            addHatToRandomBear(scene);
        } else if (e.getSource() == buttons.getWandButton()) {
            addWandToRandomBear(scene);
        } else if (e.getSource() == buttons.getBlueEyesButton()) {
            setRandomEyeColors(scene);
        } else if (e.getSource() == buttons.getMixedDecorButton()) {
            scene.setMixedDecorations();
        } else if (e.getSource() == buttons.getHeadColorButton()) {
            setRandomHeadColor(scene);
        } else if (e.getSource() == buttons.getMixedHeadColorsButton()) {
            setRandomHeadColors(scene);
        }

        repaint();
    }

    // === Color Logic ===
    private void handleRandomColor(Scene scene) {
        BearColor[] values = BearColor.values();
        BearColor random = values[RandomNumber.between(0, values.length - 1)];
        scene.setAllColors(random);
    }

    private void applySelectedColor(Scene scene) {
        int value = buttons.getColorSlider().getValue();
        BearColor selectedColor = switch (value) {
            case COLOR_SLIDER_BROWN -> BearColor.BROWN;
            case COLOR_SLIDER_DARK_BROWN -> BearColor.DARK_BROWN;
            default -> BearColor.BLACK;
        };
        scene.setAllColors(selectedColor);
    }

    // === Size and Pose Logic ===
    private void cycleSize(Scene scene) {
        currentSizeIndex = (currentSizeIndex + 1) % sizes.length;
        scene.setAllSizes(sizes[currentSizeIndex]);
    }

    private void togglePose(Scene scene) {
        Pose nextPose = isDancing ? Pose.NORMAL : Pose.DANCING;
        scene.setAllPoses(nextPose);
        isDancing = !isDancing;
    }

    // === Reset ===
    private void resetScene(Scene scene) {
        isDancing = false;
        currentSizeIndex = SIZE_SMALL_INDEX;
        scene.setOriginalVariations();
    }

    // === Decoration Methods ===
    private void addHatToRandomBear(Scene scene) {
        if (!scene.getBears().isEmpty()) {
            BearComponent randomBear = getRandomBear(scene);
            scene.replaceBear(randomBear, new HatDecorator(randomBear));
        }
    }

    private void addWandToRandomBear(Scene scene) {
        if (!scene.getBears().isEmpty()) {
            BearComponent randomBear = getRandomBear(scene);
            scene.replaceBear(randomBear, new WandDecorator(randomBear));
        }
    }

    private void setRandomEyeColors(Scene scene) {
        if (!scene.getBears().isEmpty()) {
            Color[] eyeColors = {
                Color.BLUE, Color.GREEN, Color.RED,
                Color.YELLOW, Color.CYAN
            };
            BearComponent randomBear = getRandomBear(scene);
            Color randomColor = eyeColors[RandomNumber.between(0, eyeColors.length - 1)];
            scene.replaceBear(randomBear, new EyeColorDecorator(randomBear, randomColor));
        }
    }

    private void setRandomHeadColor(Scene scene) {
        if (!scene.getBears().isEmpty()) {
            Color[] headColors = {
                new Color(139, 69, 19),
                new Color(100, 50, 10),
                new Color(50, 30, 10),
                new Color(200, 150, 100),
                new Color(150, 100, 50)
            };
            BearComponent randomBear = getRandomBear(scene);
            Color randomColor = headColors[RandomNumber.between(0, headColors.length - 1)];
            scene.replaceBear(randomBear, new HeadColorDecorator(randomBear, randomColor));
        }
    }

    private void setRandomHeadColors(Scene scene) {
        Color[] headColors = {
            new Color(139, 69, 19),
            new Color(100, 50, 10),
            new Color(50, 30, 10),
            new Color(200, 150, 100),
            new Color(150, 100, 50)
        };

        for (BearComponent bear : scene.getBears()) {
            Color randomColor = headColors[RandomNumber.between(0, headColors.length - 1)];
            scene.replaceBear(bear, new HeadColorDecorator(bear, randomColor));
        }
    }

    // === Random Bear Selection Helper ===
    private BearComponent getRandomBear(Scene scene) {
        java.util.List<BearComponent> bears = scene.getBears();
        return bears.get(RandomNumber.between(0, bears.size() - 1));
    }

    public static void main(String[] args) {
        new DrawingTool(WINDOW_TITLE);
    }
}
