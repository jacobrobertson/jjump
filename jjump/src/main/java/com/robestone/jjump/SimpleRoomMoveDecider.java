package com.robestone.jjump;

import java.awt.Rectangle;

public class SimpleRoomMoveDecider implements MoveDecider {

	private GameRunner gameRunner;
	private Room room;
	
	public SimpleRoomMoveDecider(Room room, GameRunner gameRunner) {
		this.room = room;
		this.gameRunner = gameRunner;
	}

	public boolean decide(SpriteXYMove move) {

		Room currentRoom = gameRunner.getRoom(move.sprite);
		if (currentRoom != room) {
			return true;
		}
		
		Rectangle roomBounds = room.getBounds();

		int roomRight = roomBounds.x + roomBounds.width;
		int spriteWidth = gameRunner.getScreen().getWidth(move.sprite);
		
		boolean bounceX = false;
		boolean bounceY = false;
		
		if (move.edgeBehavior == EdgeBehavior.Stick) {
			if (move.newX < roomBounds.x) {
				move.newX = roomBounds.x;
				move.allowed = false;
			} else {
				int right = move.newX + spriteWidth;
				if (right > roomRight) {
					move.newX = roomRight - spriteWidth;
				}
			}
		} else if (move.edgeBehavior == EdgeBehavior.Bounce) {
			if (move.newX < roomBounds.x) {
				move.allowed = false;
				move.newX = roomBounds.x;
				bounceX = true;
			} else if (move.newX + spriteWidth > roomRight) {
				move.allowed = false;
				move.newX = roomRight - spriteWidth;
				bounceX = true;
			}
		}
		int spriteHeight = gameRunner.getScreen().getHeight(move.sprite);
		int roomBottom = roomBounds.y + roomBounds.height;
		if (move.edgeBehavior == EdgeBehavior.Stick) {
			if (move.newY < roomBounds.y) {
				move.allowed = false;
				move.newY = roomBounds.y;
			} else {
				int bottom = move.newY + spriteHeight;
				if (bottom > roomBottom) {
					move.allowed = false;
					move.newY = roomBottom - spriteHeight;
				}
			}
		} else if (move.edgeBehavior == EdgeBehavior.Bounce) {
			if (move.newY < roomBounds.y) {
				move.newY = roomBounds.y;
				move.allowed = false;
				bounceY = true;
			} else if (move.newY + spriteHeight > roomBottom) {
				move.allowed = false;
				move.newY = roomBottom - spriteHeight;
				bounceY = true;
			}
		}
		
		int xv = move.sprite.getXVelocity();
		if (bounceX) {
			xv = -xv;
		}
		int yv = move.sprite.getYVelocity();
		if (bounceY) {
			yv = -yv;
		}
		move.sprite.setVelocity(xv, yv);
		
		return move.allowed;
	}

}
