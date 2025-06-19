package giraffe;

import java.awt.Color;

public enum ColorSkinPatterns {
	
	ORIGINAL(Color.decode("#5F2209")),
	CHOCOLATE(Color.decode("#2A1503")),
	PECAN(Color.decode("#4C2512")),
	TAWNY(Color.decode("#7B481C")),
	WOOD(Color.decode("#916A2F")),
	WALNUT(Color.decode("#452711")),
	BRUNETTE(Color.decode("#3C1E08")),
	MOCHA(Color.decode("#3D280D")),
	COFFEE(Color.decode("#4B371A")),
	TORTILLA(Color.decode("#9A7B4D")),
	CINNAMON(Color.decode("#632A0F")),
	PEANUT(Color.decode("#785C33")),
	CARAMEL(Color.decode("#66350F")),
	SYRUP(Color.decode("#45200D")),
	CEDAR(Color.decode("#493729")),
	GINGERBREAD(Color.decode("#5C2D0F")),
	CAROB(Color.decode("#7E5C33")),
	HICKORY(Color.decode("#351D11")),
	PENNY(Color.decode("#552A19")),
	UMBER(Color.decode("#342214")),
	RUSSET(Color.decode("#80461A"));

    private Color color;

    ColorSkinPatterns(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}

