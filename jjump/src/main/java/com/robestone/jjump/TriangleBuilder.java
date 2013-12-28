package com.robestone.jjump;

import java.awt.Color;

public class TriangleBuilder extends AbstractLooksBuilder {

	private TriangleCostume costume;
	
	public TriangleBuilder(String name, SpriteBuilder parent) {
		super(parent);
		costume = new TriangleCostume(name);
		parent.getSprite().getCostumes().addCostume(costume);
	}
	
	public TriangleBuilder points(int x1, int y1, int x2, int y2) {
		costume.initPoints(x1, y1, x2, y2);
		return this;
	}
	public TriangleBuilder border(int thickness, Color color) {
		costume.setBorderColor(color);
		costume.setBorderThickness(thickness);
		return this;
	}
	public TriangleBuilder fill(Color color) {
		costume.setFillColor(color);
		return this;
	}
	
}
