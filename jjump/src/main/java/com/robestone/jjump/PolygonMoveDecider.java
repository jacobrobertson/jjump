package com.robestone.jjump;

import java.awt.Polygon;
import java.awt.Rectangle;

public class PolygonMoveDecider implements MoveDecider {

	private Room room;
	private GameRunner gameRunner;
	
	
	// TODO add "keepIn" and "keepOut"
	// TODO the bounce and stick behaviors aren't very good, because they can't prevent you from moving past the edge
	public boolean decide(SpriteXYMove move) {
		
		Room currentRoom = gameRunner.getRoom(move.sprite);
		if (currentRoom != room) {
			return true;
		}
		
		PolygonPaintable paintable = (PolygonPaintable) room.getPaintable();
		
		Polygon polygon = null;
		
		Rectangle spriteBounds = gameRunner.getScreen().getBounds(move.sprite);
		
		boolean contains = polygon.contains(spriteBounds);
		if (contains) {
			return true;
		}
		
		if (move.edgeBehavior == EdgeBehavior.Stick) {
			move.newX = move.oldX;
			move.newY = move.oldY;
		} else if (move.edgeBehavior == EdgeBehavior.Bounce) {
			move.newX = move.oldX;
			move.newY = move.oldY;
			
		}

//		int xv = move.sprite.getXVelocity();
//		if (bounceX) {
//			xv = -xv;
//		}
//		int yv = move.sprite.getYVelocity();
//		if (bounceY) {
//			yv = -yv;
//		}
//		move.sprite.setVelocity(xv, yv);

		return false;
	}

}
