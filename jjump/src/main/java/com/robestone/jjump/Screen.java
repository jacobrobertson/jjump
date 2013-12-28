package com.robestone.jjump;

import java.awt.Rectangle;

/**
 * Provides the surface to paint onto.
 * @author jacob
 */
public interface Screen extends Room {

	void paintCycle();
	int getWidth(Sprite sprite);
	int getHeight(Sprite sprite);
	Rectangle getBounds(Sprite sprite);
	
}
