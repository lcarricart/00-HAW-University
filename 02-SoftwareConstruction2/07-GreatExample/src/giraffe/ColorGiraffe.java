package giraffe;

import java.awt.Color;

public enum ColorGiraffe {
	
	ORIGINAL(Color.decode("#F0A22E")),
	CHERRY(Color.decode("#B40000")),
	RASPBERRY(Color.decode("#D32375")),
	MANDARIN(Color.decode("#F78C18")),
	GRAPE(Color.decode("#9618B1")),
	KIWI(Color.decode("#91D863")),
	AVOCADO(Color.decode("#66B52A")),
	BANANA(Color.decode("#F4F644")),
	POMELO(Color.decode("#E07B60")),
	APPLE(Color.decode("#18F710")),
	PLUM(Color.decode("#440B34")),
	MANGO(Color.decode("#F4D320")),
	TAMARIND(Color.decode("#76561D")),
	BLUEBERRY(Color.decode("#522DDD")),
	PAPAYA(Color.decode("#F1653C")),
	APRICOT(Color.decode("#FBCEB1"));

    private Color color;

    ColorGiraffe(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}
