package com.robestone.jjump;

import java.awt.Color;

public class TriangleSprite extends PolygonSprite {

	public TriangleSprite(String name) {
		super(name);
	}
			
	public TriangleSprite(String name, 
			int x1, int y1, 
			int x2, int y2, 
			int borderThickness, Color borderColor,
			Color fillColor) {
		super(name, borderThickness, borderColor, fillColor);
		addPoint(x1, y1);
		addPoint(x2, y2);
		addPoint(0, 0);
	}
	public void initPoints(int x1, int y1, int x2, int y2) {
		addPoint(x1, y1);
		addPoint(x2, y2);
		addPoint(0, 0);
	}

}
