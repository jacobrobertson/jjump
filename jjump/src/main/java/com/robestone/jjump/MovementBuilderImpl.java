package com.robestone.jjump;

public class MovementBuilderImpl implements MovementBuilder {

	private SpriteBuilder parent;
	
	public MovementBuilderImpl(SpriteBuilder spriteBuilder) {
		this.parent = spriteBuilder;
	}
	public void setLooksBuilder(LooksBuilder looksBuilder) {
		parent.setLooksBuilder(looksBuilder);
	}
	public String getName() {
		return parent.getName();
	}
	public MoveableSprite getSprite() {
		return (MoveableSprite) parent.getSprite();
	}
	
	public MovementBuilder speed(int xSpeed, int ySpeed) {
		getSprite().setMoving(xSpeed, ySpeed);
		return this;
	}
	public MovementBuilder moveTo(int x, int y) {
		getSprite().setPosition(x, y);
		return this;
	}
	public MovementBuilder speed(int speed) {
		getSprite().setMoving(speed, speed);
		return this;
	}
	public MovementBuilder bounce() {
		getSprite().setEdgeBehavior(EdgeBehavior.Bounce);
		return this;
	}
	public SpriteBuilder getSpriteBuilder() {
		return parent;
	}
	public LooksBuilder looksLike() {
		return parent.looksLike();
	}
	public MovementBuilder movesLike() {
		return this;
	}
	
}
