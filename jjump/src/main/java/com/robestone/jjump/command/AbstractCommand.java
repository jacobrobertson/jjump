package com.robestone.jjump.command;

public abstract class AbstractCommand implements Command {

	protected Receiver receiver;

	public AbstractCommand(Receiver receiver) {
		this.receiver = receiver;
	}
	protected Object getDelegate() {
		return receiver.getDelegate();
	}
	
}
