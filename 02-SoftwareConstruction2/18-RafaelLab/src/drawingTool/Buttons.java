package drawingTool;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Buttons {
    private static final int PANEL_ROWS = 30;
    private static final int SLIDER_MIN = 0;
    private static final int SLIDER_MAX = 2;
    private static final int SLIDER_INIT = 0;

    // === Buttons ===
    private JButton nextColorButton = new JButton("Next Color");
    private JButton mixedColorButton = new JButton("Mixed Colors");
    private JButton applyColorButton = new JButton("Apply Color");
    private JButton nextSizeButton = new JButton("Next Size");
    private JButton mixedSizeButton = new JButton("Mixed Sizes");
    private JButton nextPoseButton = new JButton("Next Pose");
    private JButton mixedPoseButton = new JButton("Mixed Poses");
    private JButton resetButton = new JButton("Reset");
    private JButton hatButton = new JButton("Add Hat");
    private JButton wandButton = new JButton("Add Wand");
    private JButton blueEyesButton = new JButton("Random Eyes");
    private JButton headColorButton = new JButton("Random Head Color");
    private JButton mixedDecorButton = new JButton("Mixed Decorations");
    private JButton mixedHeadColorsButton = new JButton("Mixed Head Colors");

    private JSlider colorSlider = new JSlider(SLIDER_MIN, SLIDER_MAX, SLIDER_INIT);

    // === Action Listener Binding ===
    public void addActionListener(ActionListener listener) {
        nextColorButton.addActionListener(listener);
        mixedColorButton.addActionListener(listener);
        applyColorButton.addActionListener(listener);
        nextSizeButton.addActionListener(listener);
        mixedSizeButton.addActionListener(listener);
        nextPoseButton.addActionListener(listener);
        mixedPoseButton.addActionListener(listener);
        resetButton.addActionListener(listener);
        hatButton.addActionListener(listener);
        wandButton.addActionListener(listener);
        blueEyesButton.addActionListener(listener);
        headColorButton.addActionListener(listener);
        mixedDecorButton.addActionListener(listener);
        mixedHeadColorsButton.addActionListener(listener);
    }

    // === UI Layout ===
    public void addButtonsToPanel(JFrame frame) {
        JPanel menu = new JPanel();
        menu.setLayout(new GridLayout(PANEL_ROWS, 1));

        addSection(menu, "=== Colors ===", nextColorButton, mixedColorButton);
        addSection(menu, "=== Color Slider ===", colorSlider, applyColorButton);
        addSection(menu, "=== Sizes ===", nextSizeButton, mixedSizeButton);
        addSection(menu, "=== Poses ===", nextPoseButton, mixedPoseButton);
        addSection(menu, "=== Decorations ===",
                hatButton,
                wandButton,
                blueEyesButton,
                headColorButton,
                mixedDecorButton,
                mixedHeadColorsButton);
        addSection(menu, "=== Reset ===", resetButton);

        frame.add(menu, BorderLayout.WEST);
    }

    private void addSection(JPanel panel, String labelText, JComponent... components) {
        panel.add(new JLabel(labelText));
        for (JComponent component : components) {
            panel.add(component);
        }
    }

    // === Getters ===
    public JButton getNextColorButton() {
        return nextColorButton;
    }

    public JButton getMixedColorButton() {
        return mixedColorButton;
    }

    public JButton getApplyColorButton() {
        return applyColorButton;
    }

    public JButton getNextSizeButton() {
        return nextSizeButton;
    }

    public JButton getMixedSizeButton() {
        return mixedSizeButton;
    }

    public JButton getNextPoseButton() {
        return nextPoseButton;
    }

    public JButton getMixedPoseButton() {
        return mixedPoseButton;
    }

    public JButton getResetButton() {
        return resetButton;
    }

    public JButton getHatButton() {
        return hatButton;
    }

    public JButton getWandButton() {
        return wandButton;
    }

    public JButton getBlueEyesButton() {
        return blueEyesButton;
    }

    public JButton getHeadColorButton() {
        return headColorButton;
    }

    public JButton getMixedDecorButton() {
        return mixedDecorButton;
    }

    public JButton getMixedHeadColorsButton() {
        return mixedHeadColorsButton;
    }

    public JSlider getColorSlider() {
        return colorSlider;
    }
}
