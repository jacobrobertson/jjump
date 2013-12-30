package com.robestone.jjump.command;

public class CommandBuilderParent extends AbstractCommandBuilder {

	private LooksLikeBuilder looksLike;
	private MovesLikeBuilder movesLike;
	
	public CommandBuilderParent(String name) {
		super(new SimpleReceiver(name), null);
		looksLike = new LooksLikeBuilder(receiver, this);
		movesLike = new MovesLikeBuilder(receiver, this);
	}
	
	public LooksLikeBuilder looksLike() {
		return looksLike;
	}
	public MovesLikeBuilder movesLike() {
		return movesLike;
	}
	
	public RectangleCommand rectangle(String name) {
		return null;
	}
	
	
	
	/*
	 * triangle(...).looksLike().size(...).movesLike().speed(1, 2);
	 * when(...).looksLike().size(...).movesLike().stop();
	 * when(...).looksLike().border(...).movesLike().start();
	 */
	
}
