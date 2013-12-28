package com.robestone.jjump;

import java.awt.Color;
import java.awt.Rectangle;
import java.util.List;

public class SimpleRoom implements Room, PolygonPaintable {

	private PolygonCostume paintable;
	private Rectangle bounds;
	private MoveDecider moveDecider;
	
	public SimpleRoom(
			String name,
			int x, int y, int width, int height,
			int borderThickness, Color borderColor, Color fillColor
			) {
		bounds = new Rectangle(x, y, width, height);
		paintable = new PolygonCostume(name, borderThickness, borderColor, fillColor);
		paintable.addPoint(x, y);
		paintable.addPoint(x + width, y);
		paintable.addPoint(x + width, y + height);
		paintable.addPoint(x, y + height);
	}
	
	public void init(GameRunner gameRunner) {
		this.moveDecider = new SimpleRoomMoveDecider(this, gameRunner);
	}

	public List<Integer> getXPoints() {
		return paintable.getXPoints();
	}
	public List<Integer> getYPoints() {
		return paintable.getYPoints();
	}
	public int getBorderThickness() {
		return paintable.getBorderThickness();
	}
	public void setBorderThickness(int borderThickness) {
		paintable.setBorderThickness(borderThickness);
	}
	public Color getBorderColor() {
		return paintable.getBorderColor();
	}
	public void setBorderColor(Color borderColor) {
		paintable.setBorderColor(borderColor);
	}
	public Color getFillColor() {
		return paintable.getFillColor();
	}
	public void setFillColor(Color fillColor) {
		paintable.setFillColor(fillColor);
	}
	public int getX() {
		return paintable.getX();
	}
	public int getY() {
		return paintable.getY();
	}
	public String getName() {
		return paintable.getName();
	}
	public boolean isVisible() {
		return paintable.isVisible();
	}
	public void setVisible(boolean visible) {
		paintable.setVisible(visible);
	}
	public void hide() {
		paintable.hide();
	}
	public void show() {
		paintable.show();
	}
	public Rectangle getBounds() {
		return bounds;
	}
	public Paintable getPaintable() {
		return paintable;
	}
	public MoveDecider getMoveDecider() {
		return moveDecider;
	}
}
