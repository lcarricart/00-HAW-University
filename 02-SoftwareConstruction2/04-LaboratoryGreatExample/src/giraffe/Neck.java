package giraffe;

import java.awt.Color;

import scene.Drawing;

public class Neck {

	private int width;
	private int height;
	private Color color;
	private NeckPatterns neckbottomleftpattern;
	private NeckPatterns neckbottomrightpattern;
	private NeckPatterns necksecondbottomleftpattern;
	private NeckPatterns necksecondbottomrightpattern;
	private NeckPatterns neckmiddleleftpattern;
	private NeckPatterns neckmiddlerightpattern;
	private NeckPatterns necksecondtopleftpattern;
	private NeckPatterns necksecondtoprightpattern;
	private NeckPatterns necktopleftpattern;
	private NeckPatterns necktoprightpattern;
	
	public Neck(int width, int height, Color color) {
		this.width = width;
		this.height = height;
		this.color = color;
		neckbottomleftpattern = new NeckPatterns(width, height, color);
		neckbottomrightpattern = new NeckPatterns(width, height, color);
		necksecondbottomleftpattern= new NeckPatterns(width, height, color);
		necksecondbottomrightpattern = new NeckPatterns(width, height, color);
		neckmiddleleftpattern = new NeckPatterns(width, height, color);
		neckmiddlerightpattern = new NeckPatterns(width, height, color);
		necksecondtopleftpattern = new NeckPatterns(width, height, color);
		necksecondtoprightpattern = new NeckPatterns(width, height, color);
		necktopleftpattern = new NeckPatterns(width, height, color);
		necktoprightpattern = new NeckPatterns(width, height, color);
		
	}
	
	public void drawAt(int left, int bottom) {
		int leftPatternIndention = 31 * width/2;
		int rightPatternIndention = 16 * width;
		Drawing.pen().setColor(color);
		Drawing.pen().fillRect(left + 14 * width, bottom + 3 * height, width * 350/100, height * 2100/100);
		neckbottomleftpattern.drawAt(left + leftPatternIndention, bottom + 20 * height);
		neckbottomrightpattern.drawAt(left + rightPatternIndention, bottom + 37 * height/2);
		necksecondbottomleftpattern.drawAt(left + leftPatternIndention, bottom + 17 * height);
		necksecondbottomrightpattern.drawAt(left + rightPatternIndention, bottom + 31 * height/2);
		neckmiddleleftpattern.drawAt(left + leftPatternIndention, bottom + 14 * height);
		neckmiddlerightpattern.drawAt(left + rightPatternIndention, bottom + 25 * height/2);
		necksecondtopleftpattern.drawAt(left + leftPatternIndention, bottom + 11 * height);
		necksecondtoprightpattern.drawAt(left + rightPatternIndention, bottom + 19 * height/2);
		necktopleftpattern.drawAt(left + leftPatternIndention, bottom + 8 * height);
		necktoprightpattern.drawAt(left + rightPatternIndention, bottom + 13 * height/2);
	}
	
	public int getHeight() {
	    return (21 * height - 3 * height);
	}
	
	public int getWidth() {
	    return width;
	}

}
