package com.robestone.jjump.command;


public class LooksLikeBuilder extends AbstractCommandBuilder {

	public LooksLikeBuilder(Receiver receiver, CommandBuilderParent parent) {
		super(receiver, parent);
	}

	public LooksLikeBuilder size(int width, int height) {
		addCommand(new SizeCommand(receiver, width, height));
		return this;
	}
	
}
