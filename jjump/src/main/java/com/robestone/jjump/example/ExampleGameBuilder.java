package com.robestone.jjump.example;

import java.awt.Color;

import com.robestone.jjump.GameBuilder;

public class ExampleGameBuilder extends GameBuilder {

	public static void main(String[] args) {
		new ExampleGameBuilder().run();
	}
	
	@Override
	public void build() {
		rectangle("Present")
				.size(60, 100)
				.border(4, Color.blue)
				.fill(Color.white)
			.movesLike()
				.moveTo(20, 30)
				.speed(5, 2)
				.bounce()
				;

		triangle("Tree")
				.points(60, 0, 30, -90)
				.border(4, Color.green)
				.fill(Color.green)
			.movesLike()
				.moveTo(50, 90)
//				.speed(5, 2)
//				.bounce()
				;


		oval("Ornament")
				.size(50, 30)
				.border(10, Color.red)
				.fill(Color.pink)
			.movesLike()
				.moveTo(50, 90)
				.bounce().speed(2)
				;
		
		oval("Ornament2")
				.size(50, 30)
				.border(15, Color.CYAN)
				.fill(Color.pink)
			.movesLike()
				.moveTo(50, 100)
				.bounce().speed(3)
				;
		oval("Ornament3")
				.size(50, 30)
				.border(15, Color.DARK_GRAY)
				.fill(Color.BLACK)
			.movesLike()
				.moveTo(30, 10)
				.bounce().speed(5)
				;

 	}
	
}
