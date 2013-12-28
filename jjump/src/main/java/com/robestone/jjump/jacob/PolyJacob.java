package com.robestone.jjump.jacob;

import java.awt.Color;

import com.robestone.jjump.EdgeBehavior;
import com.robestone.jjump.PolygonCostume;
import com.robestone.jjump.SimpleSprite;

public class PolyJacob extends SimpleSprite {
	
	boolean canGetStuck;
	private PolygonCostume costume;

	public PolyJacob(String name, int borderThickness, Color borderColor,
			Color fillColor, int xVelocity, int yVelocity, boolean canGetStuck) {
		super(name);
		PolygonCostume costume = new PolygonCostume(name, borderThickness, borderColor, fillColor);
		getCostumes().addCostume(costume);
		init(xVelocity, yVelocity);
		this.canGetStuck = canGetStuck;
	}

	public PolyJacob(String name, int xVelocity, int yVelocity) {
		super(name);
		init(xVelocity, yVelocity);
	}
	
	private void init(int xVelocity, int yVelocity) {
		costume.addPoint(0, 0);
		costume.addPoint(20, 0);
		costume.addPoint(20, 20);
		costume.addPoint(0, 20);
		
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
