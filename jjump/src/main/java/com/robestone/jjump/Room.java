package com.robestone.jjump;

import java.awt.Rectangle;

public interface Room {

	Rectangle getBounds();
	String getName();
	Paintable getPaintable();
	MoveDecider getMoveDecider();
	void init(GameRunner gameRunner);

}
