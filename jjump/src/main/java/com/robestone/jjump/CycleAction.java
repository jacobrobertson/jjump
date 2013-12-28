package com.robestone.jjump;

/**
 * Each cycle, the game will check every action.
 * 
 * @author jacob
 */
public interface CycleAction {

	void doAction();
	void init(GameRunner runner);
	
}
