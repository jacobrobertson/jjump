package com.robestone.jjump;


public class SpriteBuilderImpl implements SpriteBuilder {

	private MovementBuilder movementBuilder;
	private LooksBuilder looksBuilder;
	
	public SpriteBuilderImpl() {
		this.movementBuilder = new MovementBuilderImpl(this);
	}
	public void setLooksBuilder(LooksBuilder looksBuilder) {
		this.looksBuilder = looksBuilder;
	}
	public String getName() {
		return getSprite().getName();
	}
	public Sprite getSprite() {
		return looksBuilder.getSprite();
	}
	public SpriteBuilder getSpriteBuilder() {
		return this;
	}
	public LooksBuilder looksLike() {
		return looksBuilder;
	}
	public MovementBuilder movesLike() {
		return movementBuilder;
	}

}
