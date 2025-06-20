package Ostrich;

import java.awt.Color;

public enum SkinColors {

	DEFAULT(Color.decode("#c2a9bd")),
	BROWN(new Color(139, 69, 19)), 
	PINK(new Color(255, 192, 203)); 
	
	
	private Color color;

    SkinColors(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return this.color;
    }

}