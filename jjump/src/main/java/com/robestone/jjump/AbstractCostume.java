package com.robestone.jjump;

import com.robestone.jjump.command.Positionable;

public abstract class AbstractCostume implements Costume, Positionable {

	private String name;
	private boolean visible;
	private int x, y;
	
	public AbstractCostume(String name) {
		super();
		this.name = name;
	}

	public boolean isVisible() {
		return visible;
	}
	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	public void hide() {
		setVisible(false);
	}
	public void show() {
		setVisible(true);
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public String getName() {
		return name;
	}
	public void position(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
