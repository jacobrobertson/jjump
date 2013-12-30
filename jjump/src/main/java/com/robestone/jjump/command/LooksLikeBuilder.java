package com.robestone.jjump.command;


public class LooksLikeBuilder extends AbstractCommandBuilder {

	public LooksLikeBuilder(Object receiver, CommandBuilder parent) {
		super(receiver, parent);
	}

	public LooksLikeBuilder size(int width, int height) {
		addCommand(new SizeCommand((Sizeable) receiver, width, height));
		return this;
	}
	
}
