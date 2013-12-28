package com.robestone.jjump.example;

import java.awt.Color;

import com.robestone.jjump.EdgeBehavior;
import com.robestone.jjump.RectangleSprite;
import com.robestone.jjump.swing.SwingGame;

public class SimplestGame {

	public static void main(String[] args) {
		SwingGame game = new SwingGame();
		
		RectangleSprite box = new RectangleSprite("rect", 60, 100, 3, Color.BLUE, Color.red);
		box.setMoving(1, 1);
		box.setEdgeBehavior(EdgeBehavior.Bounce);
		game.addRule(box);
		
		
		game.runGame();
	}
	
}
