package scene;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;

import cow.SceneCow;
import farmer.Farmer;

public class SceneGenerator{
	
	private Scene scene;
	private SceneCow sceneCow;
	private SceneSec sceneSec;
	private Farmer farmer;
	private ArrayList<Scenes> scenes = new ArrayList<Scenes>();
	
	
	public SceneGenerator(Farmer farmer) {
		this.farmer=farmer;
		
	}
	
	public ArrayList<Scenes> generate(){
			for(int i=0;i<25;i++) {
				switch(i) {
				case 12:
					scenes.add(new SceneOstrich(
							i,
							new Point(100, 100),
							6*TestDrawingTool.screenSize().width/10, 8*TestDrawingTool.screenSize().height/10,
							farmer));
					break;
				case 6:
					scenes.add((new Scene(i,farmer,false)));
					break;
				case 7:
					scenes.add(new SceneCow(
							i,
							new Point(200, 50),
							8*TestDrawingTool.screenSize().width/10, 6*TestDrawingTool.screenSize().height/10,
							farmer));
					break;
				case 5,10,15:
					scenes.add(new SceneBeach(
							i,
							new Rectangle(
									new Point(0,0),
									new Dimension(
											5*TestDrawingTool.screenSize().width/10,
											11*TestDrawingTool.screenSize().height/10)),
							farmer));
					break;
				case 9,14,19:
					scenes.add(new SceneBeach(
							i, 
							new Rectangle(
									new Point(
											TestDrawingTool.screenSize().width-5*TestDrawingTool.screenSize().width/10,
											0),
									new Dimension(
											5*TestDrawingTool.screenSize().width/10,
											10*TestDrawingTool.screenSize().height/10)),
							farmer));
					break;
				case 1,2,3:
					scenes.add(new SceneBeach(
							i,
							new Rectangle(
									new Point(0,0),
									new Dimension(
											10*TestDrawingTool.screenSize().width/10,
											5*TestDrawingTool.screenSize().height/10)),
							farmer));
					break;
				case 21,22,23:
					scenes.add(new SceneBeach(
							i,
							new Rectangle(
									new Point(0,5*TestDrawingTool.screenSize().height/10),
									new Dimension(
											10*TestDrawingTool.screenSize().width/10,
											5*TestDrawingTool.screenSize().height/10)),
							farmer));
					break;
				case 0 : scenes.add(new SceneBeach(
						i, 
						new Rectangle(
								new Point(0,0),
								new Dimension(
										10*TestDrawingTool.screenSize().width/10,
										5*TestDrawingTool.screenSize().height/10)),
						new Rectangle(
								new Point(0,5*TestDrawingTool.screenSize().height/10),
								new Dimension(
										5*TestDrawingTool.screenSize().width/10,
										10*TestDrawingTool.screenSize().height/10)),
						
						farmer,
						Direction.UP_LEFT));
					break;
				case 4: scenes.add(new SceneBeach(
								i, 
								new Rectangle(
										new Point(0,0),
										new Dimension(
												10*TestDrawingTool.screenSize().width/10,
												5*TestDrawingTool.screenSize().height/10)),
								new Rectangle(
										new Point(5*TestDrawingTool.screenSize().width/10,5*TestDrawingTool.screenSize().height/10),
										new Dimension(
												5*TestDrawingTool.screenSize().width/10,
												10*TestDrawingTool.screenSize().height/10)),
								
								farmer,
								Direction.UP_RIGHT));
						break;
				case 20: scenes.add(new SceneBeach(
						i, 
						new Rectangle(
								new Point(0,5*TestDrawingTool.screenSize().height/10),
								new Dimension(
										10*TestDrawingTool.screenSize().width/10,
										5*TestDrawingTool.screenSize().height/10)),
						new Rectangle(
								new Point(0,0),
								new Dimension(
										5*TestDrawingTool.screenSize().width/10,
										5*TestDrawingTool.screenSize().height/10)),
						
						farmer,
						Direction.DOWN_LEFT));
					break;
				case 24: scenes.add(new SceneBeach(
						i, 
						new Rectangle(
								new Point(0,5*TestDrawingTool.screenSize().height/10),
								new Dimension(
										10*TestDrawingTool.screenSize().width/10,
										5*TestDrawingTool.screenSize().height/10)),
						new Rectangle(
								new Point(5*TestDrawingTool.screenSize().width/10,0),
								new Dimension(
										5*TestDrawingTool.screenSize().width/10,
										5*TestDrawingTool.screenSize().height/10)),
						
						farmer,
						Direction.DOWN_RIGHT));
					break;
						
				default:
							scenes.add((new SceneSec(
									farmer,
									i, 
									new Rectangle(
											new Point(00, 00),
											new Dimension(0,0)))));
							break;		
				}
			}
		
		return scenes;
	}

}
