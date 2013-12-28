package com.robestone.jjump;

import java.awt.Color;

public class RectangleBuilder extends AbstractLooksBuilder {

	private RectangleCostume costume;
	
	public RectangleBuilder(String name, SpriteBuilder parent) {
		super(parent);
		costume = new RectangleCostume(name);
		parent.getSprite().getCostumes().addCostume(costume);
	}
	
	public RectangleBuilder size(int width, int height) {
		costume.initPoints(width, height);
		return this;
	}
	public RectangleBuilder border(int thickness, Color color) {
		costume.setBorderColor(color);
		costume.setBorderThickness(thickness);
		return this;
	}
	public RectangleBuilder fill(Color color) {
		costume.setFillColor(color);
		return this;
	}
	
}
