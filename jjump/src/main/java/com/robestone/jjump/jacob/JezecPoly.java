package com.robestone.jjump.jacob;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import com.robestone.jjump.EdgeBehavior;
import com.robestone.jjump.PolygonSprite;
import com.robestone.jjump.Room;

public class JezecPoly extends PolygonSprite {

	public JezecPoly(String name) {
		super(name);
		addPoint(5, 10);
		addPoint(20, 10);
		addPoint(50, 25);
		addPoint(4, 20);
		setVelocity(5, 4);
		setMoveKeys(KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT, KeyEvent.VK_UP, KeyEvent.VK_DOWN, true);
		setEdgeBehavior(EdgeBehavior.Bounce);
	}
	public void ifTyped_F() {
		changeVelocity(1, 1);
	}
	public void ifTyped_S() {
		changeVelocity(-1, -1);
	}
	public void ifTyped_P() {
		Room currentRoom = getGameRunner().getRoom(this);
		
		Room jail = getGameRunner().getRoom("jail");
		Room screen = getGameRunner().getScreen();
		
		if (currentRoom == jail) {
			// put me in the screen - which takes me out of jail
			getGameRunner().putInRoom(getName(), screen.getName());
		} else {
			// put me in the jail
			getGameRunner().putInRoom(getName(), "jail");
			// move me to the jail position too
			Rectangle jailBounds = jail.getBounds();
			Rectangle myBounds = getGameRunner().getScreen().getBounds(this);
			if (!jailBounds.contains(myBounds)) {
				setPosition(jailBounds.x + 10, jailBounds.y + 10);
			}
		}
	}

	// ------------------------
	// hide(), show()
	// foreverSomething()
	// getSensor().isTouching(name1, name2)
	//	 getSensor().isTouching(name1, name2)
}