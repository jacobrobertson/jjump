package com.robestone.jjump;

import java.awt.Color;

public class TriangleBuilder extends AbstractLooksBuilder {

	private TriangleSprite sprite;
	
	public TriangleBuilder(String name, SpriteBuilder parent) {
		super(parent);
		sprite = new TriangleSprite(name);
	}
	
	public TriangleSprite getSprite() {
		return sprite;
	}
	
	public TriangleBuilder points(int x1, int y1, int x2, int y2) {
		sprite.initPoints(x1, y1, x2, y2);
		return this;
	}
	public TriangleBuilder border(int thickness, Color color) {
		sprite.setBorderColor(color);
		sprite.setBorderThickness(thickness);
		return this;
	}
	public TriangleBuilder fill(Color color) {
		sprite.setFillColor(color);
		return this;
	}
	
}
