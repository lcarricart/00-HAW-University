package farmer;

import java.awt.Color;

import chick.Eye;
import scene.RandomNumGenerator;

public class ColorEye extends Eye{

	static int colorR = RandomNumGenerator.between(0, 255);
	static int colorG = RandomNumGenerator.between(0, 255);
	static int colorB = RandomNumGenerator.between(0, 255);
	static int colorA = RandomNumGenerator.between(250, 255);
	
		public ColorEye(int width, int height) {
			super(width, height, colorChoser());
		}
		
		private static Color colorChoser(){ 
			int random = RandomNumGenerator.between(1, 3);
			switch(random) {
			  case 1:
				 return Color.green;
			  case 2:
				return Color.blue;
			  case 3:
				  return Color.cyan;
			  default:
				  return Color.black;
			}
		}
}
