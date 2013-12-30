package com.robestone.jjump;

import java.awt.Color;

import com.robestone.jjump.command.Sizeable;

public class RectangleCostume extends PolygonCostume implements Sizeable {

	public RectangleCostume(String name) {
		super(name);
	}

	public RectangleCostume(String name, int width, int height, int borderThickness, Color borderColor,
			Color fillColor) {
		super(name, borderThickness, borderColor, fillColor);
		initPoints(width, height);
	}
	/**
	 * Will require initPoints before this object can be used.
	 */
	public RectangleCostume(String name, int borderThickness, Color borderColor,
			Color fillColor) {
		super(name, borderThickness, borderColor, fillColor);
	}
	public void initPoints(int width, int height) {
		addPoint(0, 0);
		addPoint(width, 0);
		addPoint(width, height);
		addPoint(0, height);
	}
	
	public void size(int width, int height) {
		initPoints(width, height);		
	}
	
}
