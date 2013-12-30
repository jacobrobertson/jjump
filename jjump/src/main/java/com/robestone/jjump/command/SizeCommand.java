package com.robestone.jjump.command;

public class SizeCommand extends AbstractCommand {

	private int width;
	private int height;
	
	public SizeCommand(Receiver receiver, int width, int height) {
		super(receiver);
		this.width = width;
		this.height = height;
	}

	public void execute() {
		((Sizeable) getDelegate()).size(width, height);
	}
	
}
