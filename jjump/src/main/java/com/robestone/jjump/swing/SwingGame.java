package com.robestone.jjump.swing;

import java.util.List;

import com.robestone.jjump.GameRunner;
import com.robestone.jjump.ReflectionActionBuilder;
import com.robestone.jjump.Rule;
import com.robestone.jjump.Screen;
import com.robestone.jjump.Sensor;

public class SwingGame {

	private SwingScreen screen;
	private Sensor sensor;
	private GameRunner runner;
	
	public SwingGame() {
		screen = new SwingScreen();
		sensor = screen.getSensor();
		runner = new GameRunner(screen, new ReflectionActionBuilder(), sensor);
	}
	public List<Rule> getRules() {
		return runner.getRules();
	}
	public Screen getScreen() {
		return screen;
	}
	public Sensor getSensor() {
		return sensor;
	}
	public GameRunner getRunner() {
		return runner;
	}
	public void addRule(Rule rule) {
		runner.getRules().add(rule);
	}
	public void runGame() {
		runner.runGame();
	}
	
}
