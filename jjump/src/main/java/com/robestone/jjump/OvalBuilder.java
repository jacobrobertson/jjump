package com.robestone.jjump;

import java.awt.Color;

public class OvalBuilder extends AbstractLooksBuilder {

	private OvalCostume costume;
	
	public OvalBuilder(SpriteBuilder parent) {
		super(parent);
		costume = new OvalCostume(parent.getSprite().getName());
		parent.getSprite().getCostumes().addCostume(costume);
	}
	
	public OvalBuilder size(int width, int height) {
		costume.setWidth(width);
		costume.setHeight(height);
		return this;
	}
	public OvalBuilder border(int thickness, Color color) {
		costume.setBorderColor(color);
		costume.setBorderThickness(thickness);
		return this;
	}
	public OvalBuilder fill(Color color) {
		costume.setFillColor(color);
		return this;
	}
	
}
