package com.robestone.jjump;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class PolygonCostume extends AbstractCostume implements PolygonPaintable {

	private int borderThickness = 2;
	private Color borderColor = Color.BLACK;
	private Color fillColor = Color.LIGHT_GRAY;
	
	private List<Integer> x = new ArrayList<Integer>();
	private List<Integer> y = new ArrayList<Integer>();

	public PolygonCostume(String name, int borderThickness,
			Color borderColor, Color fillColor) {
		this(name);
		this.borderThickness = borderThickness;
		this.borderColor = borderColor;
		this.fillColor = fillColor;
	}
	public PolygonCostume(String name) {
		super(name);
	}
	public void addPoint(int x, int y) {
		this.x.add(x);
		this.y.add(y);
	}
	public List<Integer> getXPoints() {
		return x;
	}
	public List<Integer> getYPoints() {
		return y;
	}
	public int getBorderThickness() {
		return borderThickness;
	}
	public void setBorderThickness(int borderThickness) {
		this.borderThickness = borderThickness;
	}
	public Color getBorderColor() {
		return borderColor;
	}
	public void setBorderColor(Color borderColor) {
		this.borderColor = borderColor;
	}
	public Color getFillColor() {
		return fillColor;
	}
	public void setFillColor(Color fillColor) {
		this.fillColor = fillColor;
	}

}
