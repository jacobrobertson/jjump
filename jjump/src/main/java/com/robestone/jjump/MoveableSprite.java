package com.robestone.jjump;

public interface MoveableSprite extends Sprite {

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
	void moveAction();
	void setMoveKeys(int left, int right, int up, int down);
	void setEdgeBehavior(EdgeBehavior edgeBehavior);

}