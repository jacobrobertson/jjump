package com.robestone.jjump;

public interface MovementBuilder extends SpriteBuilder {

	MovementBuilder speed(int xSpeed, int ySpeed);
	MovementBuilder moveTo(int x, int y);
	MovementBuilder speed(int speed);
	MovementBuilder bounce();

}
