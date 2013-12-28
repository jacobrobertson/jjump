package com.robestone.jjump;



/**
 * A Sprite represents an interactive image in the game.
 * Sprite extends Rule to simplify the concept that a sprite does certain things.
 * 
 * @author jacob
 */
public interface Sprite extends Rule, Paintable {

	/**
	 * For most Sprite implementations, this will be the file name.
	 */
	String getName();

}
