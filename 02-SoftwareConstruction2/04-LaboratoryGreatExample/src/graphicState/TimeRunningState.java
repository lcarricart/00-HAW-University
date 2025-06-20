package graphicState;

import scene.DrawingArea;

public class TimeRunningState extends State{
	private static TimeRunningState instance;

	 private TimeRunningState(DrawingArea context) {
	 this.context = context;
	 timeRunning= this;
	 }

	 public static TimeRunningState getInstance(DrawingArea context) {
	 if ( instance == null ) {
	 instance = new TimeRunningState(context);
	 }
	 return instance;
	 }

	@Override
	public State timeStopped() {
		context.pause();
		return TimeStopState.getInstance(context);
	}

	@Override
	public State timeFlows() {
		context.play();
		return this;
	}

	@Override
	public State timeResume() {
		// TODO Auto-generated method stub
		context.play();
		return NoState.getInstance(context);
	}
}
