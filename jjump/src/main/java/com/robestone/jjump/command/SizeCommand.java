package com.robestone.jjump.command;

public class SizeCommand implements Command {

	private Sizeable receiver;
	private int width;
	private int height;
	
	public SizeCommand(Sizeable receiver, int width, int height) {
		this.receiver = receiver;
		this.width = width;
		this.height = height;
	}

	public void execute() {
		receiver.size(width, height);
	}
	
}
