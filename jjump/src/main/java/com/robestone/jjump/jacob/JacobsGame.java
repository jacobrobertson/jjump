package com.robestone.jjump.jacob;

import java.awt.Color;

import com.robestone.jjump.Room;
import com.robestone.jjump.SimpleRoom;
import com.robestone.jjump.swing.SwingGame;

public class JacobsGame {

	public static void main(String[] args) {
		SwingGame game = new SwingGame();

		Room jail = new SimpleRoom("jail", 200, 100, 250, 300, 10, Color.gray, Color.lightGray);
		game.getRunner().addRoom(jail);

		Room cell = new SimpleRoom("cell", 300, 150, 100, 200, 20, Color.black, Color.white);
		game.getRunner().addRoom(cell);
		
		game.addRule(new PolyJacob("jacob1", 10, Color.red, Color.black, 2, 4, true));

		PolyJacob jacob2 = new PolyJacob("jacob2", 1, Color.black, Color.red, 1, 1, false);
		jacob2.setPosition(305, 155);
		game.addRule(jacob2);

		PolyJacob jacob3 = new PolyJacob("jacob3", 1, Color.white, Color.black, 1, 1, false);
		jacob3.setPosition(305, 155);
		game.addRule(jacob3);
		
		game.addRule(new PolyJacob("jacob4", 7, 1));
		game.addRule(new PolyJacob("jacob5", 1, 1));
		
		game.addRule(new JozenPoly("jozen1"));
		
//		game.addRule(new JezecPoly("JezecPoly"));
//		game.addRule(new JozenPoly("JozenPoly"));
		
		game.getRunner().putInRoom(jacob2, jail);
		game.getRunner().putInRoom("jacob3", "cell");
		
		game.runGame();
	}

}
