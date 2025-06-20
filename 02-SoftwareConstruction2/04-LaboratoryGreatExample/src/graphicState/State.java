package graphicState;

import scene.DrawingArea;

public abstract class State {
	
	protected DrawingArea context;

	protected static TimeStopState timeStopped;
	protected static TimeRunningState timeRunning;
	protected static NoState noState;

	public abstract State timeStopped();
	public abstract State timeFlows();
	public abstract State timeResume();

}