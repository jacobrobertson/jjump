package com.robestone.jjump;

/**
 * Encapsulates all movement a sprite could do.
 * TODO Decide what to do with this - not currently being used
 * 		Could have an implementation "MovementRules" that creates rules
 */
public interface Movement {

	void changePosition(int xChange, int yChange);
	void changeVelocity(int xChange, int yChange);
	int getX();
	int getY();
	void setPosition(int x, int y);
	int getXVelocity();
	int getYVelocity();
	void setVelocity(int xVelocity, int yVelocity);
	void setMoving(int xVelocity, int yVelocity);
	void setMoving(boolean moving);
	void move();
	void setMoveKeys(int left, int right, int up, int down);
	void setEdgeBehavior(EdgeBehavior edgeBehavior);

}