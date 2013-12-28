package com.robestone.jjump;

/**
 * A light-weight message object.
 * @author jacob
 */
public class SpriteXYMove {

	public int oldX;
	public int oldY;
	
	public int newX;
	public int newY;
	
	/**
	 * For now, decided by sprite.
	 */
	public EdgeBehavior edgeBehavior;
	
	public MoveableSprite sprite;
	
	/**
	 * Set to be true if the proposed move is allowed.
	 * False indicates that the newX and newY were probably altered, and any edge behavior should be triggered.
	 */
	public boolean allowed;

}
