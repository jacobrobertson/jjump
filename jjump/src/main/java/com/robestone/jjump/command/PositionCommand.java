package com.robestone.jjump.command;

public class PositionCommand extends AbstractCommand {

	private int x;
	private int y;
	
	public PositionCommand(Receiver receiver, int x, int y) {
		super(receiver);
		this.x = x;
		this.y = y;
	}

	public void execute() {
		((Positionable) getDelegate()).position(x, y);
	}
	
}
