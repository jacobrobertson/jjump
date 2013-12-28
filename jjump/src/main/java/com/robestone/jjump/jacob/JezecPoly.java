package com.robestone.jjump.jacob;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import com.robestone.jjump.EdgeBehavior;
import com.robestone.jjump.PolygonCostume;
import com.robestone.jjump.Room;
import com.robestone.jjump.SimpleSprite;

public class JezecPoly extends SimpleSprite {

	public JezecPoly(String name) {
		super(name);
		PolygonCostume costume = new PolygonCostume(name);
		costume.addPoint(5, 10);
		costume.addPoint(20, 10);
		costume.addPoint(50, 25);
		costume.addPoint(4, 20);
		getCostumes().addCostume(costume);
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