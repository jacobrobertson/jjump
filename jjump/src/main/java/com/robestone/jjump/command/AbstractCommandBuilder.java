package com.robestone.jjump.command;

import java.util.ArrayList;
import java.util.List;

public class AbstractCommandBuilder {

	protected Receiver receiver;
	protected CommandBuilderParent parent;
	private List<Command> commands = new ArrayList<Command>();

	public AbstractCommandBuilder(Receiver receiver, CommandBuilderParent parent) {
		this.receiver = receiver;
		this.parent = parent;
	}
	protected void addCommand(Command command) {
		commands.add(command);
	}
	public List<Command> getCommands() {
		return commands;
	}
	
	public LooksLikeBuilder looksLike() {
		return parent.looksLike();
	}
	public MovesLikeBuilder movesLike() {
		return parent.movesLike();
	}
	
}
