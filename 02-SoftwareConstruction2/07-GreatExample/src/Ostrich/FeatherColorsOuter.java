package Ostrich;

import java.awt.Color;

public enum FeatherColorsOuter {


	BLACK(Color.BLACK), 
	GRAY(Color.GRAY),
	BLUE(Color.BLUE),
	RED(Color.RED);
//	YELLOW(Color.YELLOW);
	
	private Color color;

    FeatherColorsOuter(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return this.color;
    }

}