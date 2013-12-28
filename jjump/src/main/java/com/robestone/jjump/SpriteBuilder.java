package com.robestone.jjump;

public interface SpriteBuilder {

	String getName();
	Sprite getSprite();
	MovementBuilder movesLike();
	LooksBuilder looksLike();
	SpriteBuilder getSpriteBuilder();
	void setLooksBuilder(LooksBuilder looksBuilder);
	
}
