package com.robestone.jjump;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;


public abstract class Sensor {

	private GameRunner gameRunner;
	private List<MoveDecider> moveDeciders = new ArrayList<MoveDecider>();

	public void init(GameRunner gameRunner) {
		this.gameRunner = gameRunner;
	}
	abstract public boolean isKeyPressed(int key);
	abstract public void addKeyTypedAction(int key, CycleAction action);
	
	public void addMoveDecider(MoveDecider moveDecider) {
		moveDeciders.add(moveDecider);
	}
	
	public boolean isTouching(String myName, String otherName) {
		Sprite other = gameRunner.getSprite(otherName);
		Sprite me = gameRunner.getSprite(myName);
		if (!other.isVisible() || !me.isVisible()) {
			return false;
		}
		Rectangle myBounds = gameRunner.getScreen().getBounds(me);
		Rectangle otherBounds = gameRunner.getScreen().getBounds(other);
		boolean touching = myBounds.intersects(otherBounds);
		return touching;
	}
	public void decide(SpriteXYMove move) {
		for (MoveDecider decider: moveDeciders) {
			// TODO could possibly find the most restrictive decision and abide by that
			boolean allowed = decider.decide(move);
			if (!allowed) {
				break;
			}
		}
	}
}
