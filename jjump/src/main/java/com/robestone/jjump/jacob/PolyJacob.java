package com.robestone.jjump.jacob;

import java.awt.Color;

import com.robestone.jjump.EdgeBehavior;
import com.robestone.jjump.PolygonSprite;
import com.robestone.jjump.Room;

public class PolyJacob extends PolygonSprite {
	
	boolean canGetStuck;

	public PolyJacob(String name, int borderThickness, Color borderColor,
			Color fillColor, int xVelocity, int yVelocity, boolean canGetStuck) {
		super(name, borderThickness, borderColor, fillColor);
		init(xVelocity, yVelocity);
		this.canGetStuck = canGetStuck;
	}

	public PolyJacob(String name, int xVelocity, int yVelocity) {
		super(name);
		init(xVelocity, yVelocity);
	}
	
	private void init(int xVelocity, int yVelocity) {
		addPoint(0, 0);
		addPoint(20, 0);
		addPoint(20, 20);
		addPoint(0, 20);
		
		setMoving(xVelocity, yVelocity);
		setEdgeBehavior(EdgeBehavior.Bounce);
	}

	/*
	public void ifTyped_J() {
		if (canGetStuck) {
			// -------
			Room currentRoom = getGameRunner(). getRoom (this);
		
			Room jail = getGameRunner().getRoom("jail");
			Room screen = getGameRunner().getScreen();
			
			if  (currentRoom == jail) {
				getGameRunner(). putInRoom(this, screen);
		}
	}
	*/

	
}
