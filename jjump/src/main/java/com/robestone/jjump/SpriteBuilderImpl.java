package com.robestone.jjump;


public class SpriteBuilderImpl implements SpriteBuilder {

	private MovementBuilder movementBuilder;
	private LooksBuilder looksBuilder;
	private Sprite sprite;
	
	public SpriteBuilderImpl(Sprite sprite) {
		this.movementBuilder = new MovementBuilderImpl(this);
		this.sprite = sprite;
	}
	public void setLooksBuilder(LooksBuilder looksBuilder) {
		this.looksBuilder = looksBuilder;
	}
	public String getName() {
		return getSprite().getName();
	}
	public Sprite getSprite() {
		return sprite;
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
