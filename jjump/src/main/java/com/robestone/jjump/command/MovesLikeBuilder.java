package com.robestone.jjump.command;

public class MovesLikeBuilder extends AbstractCommandBuilder {

	public MovesLikeBuilder(Receiver receiver, CommandBuilderParent parent) {
		super(receiver, parent);
	}

	public MovesLikeBuilder putAt(int x, int y) {
		addCommand(new PositionCommand(receiver, x, y));
		return this;
	}

	
}
