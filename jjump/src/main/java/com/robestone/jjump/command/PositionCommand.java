package com.robestone.jjump.command;

public class PositionCommand implements Command {

	private Positionable receiver;
	private int x;
	private int y;
	
	public PositionCommand(Positionable receiver, int x, int y) {
		this.receiver = receiver;
		this.x = x;
		this.y = y;
	}

	public void execute() {
		receiver.position(x, y);
	}
	
}
