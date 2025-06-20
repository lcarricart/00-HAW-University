package Ostrich;

import java.awt.Color;

public enum FeatherColorsInner {



	CYAN(Color.cyan),
	WHITE(Color.white),
	DARK_GRAY(Color.DARK_GRAY),
	ORANGE(Color.orange),
	PURPLE(new Color(72, 43, 147));
	
	private Color color;

    FeatherColorsInner(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return this.color;
    }

}