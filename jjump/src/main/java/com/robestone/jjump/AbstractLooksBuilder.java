package com.robestone.jjump;

public abstract class AbstractLooksBuilder implements LooksBuilder {

	private SpriteBuilder parent;
	
	public AbstractLooksBuilder(SpriteBuilder parent) {
		this.parent = parent;
		setLooksBuilder(this);
	}
	public void setLooksBuilder(LooksBuilder looksBuilder) {
		parent.setLooksBuilder(looksBuilder);
	}
	public String getName() {
		return parent.getName();
	}
	public Sprite getSprite() {
		return parent.getSprite();
	}
	public SpriteBuilder getSpriteBuilder() {
		return parent;
	}
	public LooksBuilder looksLike() {
		return this;
	}
	public MovementBuilder movesLike() {
		return parent.movesLike();
	}

}
