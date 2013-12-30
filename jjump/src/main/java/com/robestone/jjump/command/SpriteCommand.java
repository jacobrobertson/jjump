package com.robestone.jjump.command;

/**
 * Should the receiver be the
 * * Sprite
 * * Costume
 * * Game itself
 * * Context dependent?
 */
public class SpriteCommand extends AbstractCommand {

	public SpriteCommand(Receiver receiver) {
		super(receiver);
	}

	public void execute() {
		// create a new sprite
		// - then do what?
		// TODO
		// We assume the CommandBuilderParent is for "something"
		// maybe we should parameterize that?
	}

}
