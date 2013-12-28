package com.robestone.jjump;

import java.awt.Color;

public class RectangleBuilder extends AbstractLooksBuilder {

	private RectangleSprite rect;
	
	public RectangleBuilder(String name, SpriteBuilder parent) {
		super(parent);
		rect = new RectangleSprite(name);
	}
	
	public RectangleSprite getSprite() {
		return rect;
	}
	
	public RectangleBuilder size(int width, int height) {
		rect.initPoints(width, height);
		return this;
	}
	public RectangleBuilder border(int thickness, Color color) {
		rect.setBorderColor(color);
		rect.setBorderThickness(thickness);
		return this;
	}
	public RectangleBuilder fill(Color color) {
		rect.setFillColor(color);
		return this;
	}
	
}
