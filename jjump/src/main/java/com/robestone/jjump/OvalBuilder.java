package com.robestone.jjump;

import java.awt.Color;

public class OvalBuilder extends AbstractLooksBuilder {

	private OvalSprite oval;
	
	public OvalBuilder(String name, SpriteBuilder parent) {
		super(parent);
		oval = new OvalSprite(name);
	}
	
	public OvalSprite getSprite() {
		return oval;
	}
	
	public OvalBuilder size(int width, int height) {
		oval.setWidth(width);
		oval.setHeight(height);
		return this;
	}
	public OvalBuilder border(int thickness, Color color) {
		oval.setBorderColor(color);
		oval.setBorderThickness(thickness);
		return this;
	}
	public OvalBuilder fill(Color color) {
		oval.setFillColor(color);
		return this;
	}
	
}
