package com.robestone.jjump.example;

import com.robestone.jjump.swing.SwingGame;

public class ExampleGame {

	public static void main(String[] args) {
		SwingGame game = new SwingGame();
		
		game.addRule(new PerryK());
		game.addRule(new PerryB());
//		game.addRule(new EvilBlob());
		
		game.runGame();
	}
	
}
