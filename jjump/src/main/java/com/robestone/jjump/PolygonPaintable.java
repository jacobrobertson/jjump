package com.robestone.jjump;

import java.awt.Color;
import java.util.List;

public interface PolygonPaintable extends Paintable {

	List<Integer> getXPoints();
	List<Integer> getYPoints();
	int getBorderThickness();
	Color getBorderColor();
	Color getFillColor();

}