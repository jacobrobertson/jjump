package com.robestone.jjump.command;

import java.util.HashMap;
import java.util.Map;

import com.robestone.jjump.RectangleBuilder;
import com.robestone.jjump.SimpleSprite;
import com.robestone.jjump.Sprite;
import com.robestone.jjump.SpriteBuilder;
import com.robestone.jjump.SpriteBuilderImpl;
import com.robestone.jjump.swing.SwingGame;

public abstract class GameBuilder2 {

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
	
	public RectangleCommand rectangle() {
		return null;
	}
	
	public RectangleBuilder rectangleZ(String name) {
		SpriteBuilderImpl spriteBuilder = newSpriteBuilder(name);
		RectangleBuilder rectBuilder = new RectangleBuilder(name, spriteBuilder);
		spriteBuilder.setLooksBuilder(rectBuilder);
		add(spriteBuilder);
		return rectBuilder;
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
	
}
