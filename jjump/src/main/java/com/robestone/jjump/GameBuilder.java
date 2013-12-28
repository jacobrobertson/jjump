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
		SpriteBuilderImpl spriteBuilder = new SpriteBuilderImpl();
		RectangleBuilder rectBuilder = new RectangleBuilder(name, spriteBuilder);
		spriteBuilder.setLooksBuilder(rectBuilder);
		add(spriteBuilder);
		return rectBuilder;
	}
	public TriangleBuilder triangle(String name) {
		SpriteBuilderImpl spriteBuilder = new SpriteBuilderImpl();
		TriangleBuilder looksBuilder = new TriangleBuilder(name, spriteBuilder);
		spriteBuilder.setLooksBuilder(looksBuilder);
		add(spriteBuilder);
		return looksBuilder;
	}
	public OvalBuilder oval(String name) {
		
		SpriteBuilderImpl spriteBuilder = new SpriteBuilderImpl();
		OvalBuilder ovalBuilder = new OvalBuilder(name, spriteBuilder);
		spriteBuilder.setLooksBuilder(ovalBuilder);
		add(spriteBuilder);
		return ovalBuilder;
	}
	private SpriteBuilder add(SpriteBuilder builder) {
		game.addRule(builder.getSprite());
		builders.put(builder.getSprite().getName(), builder);
		return builder;
	}
	
	public MovementBuilder move(String name) {
		SpriteBuilder old = builders.get(name);
		return old.movesLike();
//		if (old instanceof MovementBuilder) {
//			return (MovementBuilder) old;
//		} else {
//			MoveableSprite sprite = (MoveableSprite) old.getSprite();
//			MovementBuilder newBuilder = new MovementBuilder(sprite);
//			builders.put(name, newBuilder);
//			return newBuilder;
//		}
	}
	public MovementBuilder position(String name) {
		return move(name);
	}
	
}
