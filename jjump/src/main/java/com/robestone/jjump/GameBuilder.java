package com.robestone.jjump;

import java.util.HashMap;
import java.util.Map;

import com.robestone.jjump.swing.SwingGame;

public abstract class GameBuilder {

	private SwingGame game = new SwingGame();
	private Map<String, SpriteBuilder> builders = new HashMap<String, SpriteBuilder>();

	abstract public void build();
	
	public void run() {
		build();
		start();
	}
	
	public void start() {
		game.runGame();
	}
	
	public RectangleBuilder rectangle(String name) {
		SpriteBuilderImpl spriteBuilder = newSpriteBuilder(name);
		RectangleBuilder rectBuilder = new RectangleBuilder(name, spriteBuilder);
		spriteBuilder.setLooksBuilder(rectBuilder);
		add(spriteBuilder);
		return rectBuilder;
	}
	public TextBuilder text(String text) {
		SpriteBuilderImpl spriteBuilder = newSpriteBuilder(text);
		TextBuilder costumeBuilder = new TextBuilder(spriteBuilder, text);
		spriteBuilder.setLooksBuilder(costumeBuilder);
		add(spriteBuilder);
		return costumeBuilder;
	}
	public TriangleBuilder triangle(String name) {
		SpriteBuilderImpl spriteBuilder = newSpriteBuilder(name);
		TriangleBuilder looksBuilder = new TriangleBuilder(name, spriteBuilder);
		spriteBuilder.setLooksBuilder(looksBuilder);
		add(spriteBuilder);
		return looksBuilder;
	}
	public OvalBuilder oval(String name) {
		SpriteBuilderImpl spriteBuilder = newSpriteBuilder(name);
		OvalBuilder ovalBuilder = new OvalBuilder(spriteBuilder);
		spriteBuilder.setLooksBuilder(ovalBuilder);
		add(spriteBuilder);
		return ovalBuilder;
	}
	private SpriteBuilderImpl newSpriteBuilder(String name) {
		Sprite sprite = new SimpleSprite(name);
		SpriteBuilderImpl spriteBuilder = new SpriteBuilderImpl(sprite);
		return spriteBuilder;
	}
	private SpriteBuilder add(SpriteBuilder builder) {
		game.addRule(builder.getSprite());
		builders.put(builder.getSprite().getName(), builder);
		return builder;
	}
	
	public MovementBuilder move(String name) {
		SpriteBuilder old = builders.get(name);
		return old.movesLike();
	}
	public MovementBuilder position(String name) {
		return move(name);
	}
	
}
