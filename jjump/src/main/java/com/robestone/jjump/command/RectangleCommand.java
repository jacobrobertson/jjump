package com.robestone.jjump.command;

import java.awt.Color;

import com.robestone.jjump.RectangleCostume;
import com.robestone.jjump.Sprite;

/**
 * How should this behave?
 * * do we want a command that creates a rectangle
 * * or do we just want to create a rectangle and set it as the receiver right away  
 * If everything is a command, it's simpler- but I'm not really sure how this builder would play out in different scenarios.
 * My first scenario is that at init-time, we want to create a rectangle, and then apply some things to it.
 * It would be nice to have a command that could also say "in 10 seconds create a rectangle"
 * 
 * 
 * Do I want the receiver's delegate to be a Sprite, or a costume?
 * "RectangleCommand" should create a new costume, but do we know whether to assign it to a sprite, or what?
 * 
 */
public class RectangleCommand extends AbstractCommand {

	public RectangleCommand(Receiver receiver) {
		super(receiver);
	}
	public void execute() {
		// TODO this won't be the right name now, since the receiver is the sprite
		RectangleCostume costume = new RectangleCostume(receiver.getName(), 1, Color.black, Color.white);
		Sprite sprite = (Sprite) getDelegate();
		sprite.getCostumes().addCostume(costume);
	}
	
}
