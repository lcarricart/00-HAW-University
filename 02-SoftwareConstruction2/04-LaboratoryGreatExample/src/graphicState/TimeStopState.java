package graphicState;

import scene.DrawingArea;

public class TimeStopState extends State{
	private static TimeStopState instance;

	 private TimeStopState(DrawingArea context) {
	 this.context = context;
	 timeStopped= this;
	 }

	 public static TimeStopState getInstance(DrawingArea context) {
	 if ( instance == null ) {
	 instance = new TimeStopState(context);
	 }
	 return instance;
	 }

	@Override
	public State timeStopped() {
		context.pause();
		return this;
	}

	@Override
	public State timeFlows() {
		context.play();
		return TimeRunningState.getInstance(context);
	}

	@Override
	public State timeResume() {
		context.play();
		return NoState.getInstance(context);
	}
}
