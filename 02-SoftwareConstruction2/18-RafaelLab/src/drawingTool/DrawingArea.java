package drawingTool;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;

public class DrawingArea extends JPanel {
    private static final long serialVersionUID = 1L;
    private static final Color BACKGROUND_COLOR = Color.WHITE;

    private Scene scene = new Scene();

    public DrawingArea() {
        setBackground(BACKGROUND_COLOR);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Drawing.set(g);
        scene.draw();
    }

    public Scene getScene() {
        return scene;
    }
}
