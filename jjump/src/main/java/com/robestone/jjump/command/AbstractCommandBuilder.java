package com.robestone.jjump.command;

import java.util.ArrayList;
import java.util.List;

public class AbstractCommandBuilder {

	protected Object receiver;
	protected CommandBuilder parent;
	private List<Command> commands = new ArrayList<Command>();

	public AbstractCommandBuilder(Object receiver, CommandBuilder parent) {
		this.receiver = receiver;
		this.parent = parent;
	}
	protected void addCommand(Command command) {
		commands.add(command);
	}
	public List<Command> getCommands() {
		return commands;
	}
	
}
