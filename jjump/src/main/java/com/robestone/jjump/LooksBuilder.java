package com.robestone.jjump;

import java.awt.Color;

public interface LooksBuilder extends SpriteBuilder {

	LooksBuilder border(int thickness, Color color);
	LooksBuilder fill(Color color);

}
