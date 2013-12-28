package com.robestone.jjump;

import java.awt.Color;

public class TextBuilder extends AbstractLooksBuilder {

	private TextCostume costume;
	
	public TextBuilder(SpriteBuilder parent, String text) {
		super(parent);
		costume = new TextCostume(parent.getSprite().getName(), text);
		parent.getSprite().getCostumes().addCostume(costume);
	}
	public TextBuilder border(int thickness, Color color) {
		costume.setBorderColor(color);
		costume.setBorderThickness(thickness);
		return this;
	}
	public TextBuilder fill(Color color) {
		costume.setFillColor(color);
		return this;
	}
	
}
