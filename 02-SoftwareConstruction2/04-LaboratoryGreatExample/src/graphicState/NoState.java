package graphicState;

import scene.DrawingArea;


public class NoState extends State{
	private static NoState instance;

	 private NoState(DrawingArea context) {
	 this.context = context;
	 noState = this;
	 }

	 public static NoState getInstance(DrawingArea context) {
	 if ( instance == null ) {
	 instance = new NoState(context);
	 }
	 return instance;
	 }

	@Override
	public State timeStopped() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public State timeFlows() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public State timeResume() {
		// TODO Auto-generated method stub
		return null;
	}

}
