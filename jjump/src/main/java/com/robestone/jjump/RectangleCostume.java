package com.robestone.jjump;

import java.awt.Color;

public class RectangleCostume extends PolygonCostume {

	public RectangleCostume(String name) {
		super(name);
	}

	public RectangleCostume(String name, int width, int height, int borderThickness, Color borderColor,
			Color fillColor) {
		super(name, borderThickness, borderColor, fillColor);
		initPoints(width, height);
	}
	public void initPoints(int width, int height) {
		addPoint(0, 0);
		addPoint(width, 0);
		addPoint(width, height);
		addPoint(0, height);
	}
	
}
